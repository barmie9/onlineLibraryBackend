package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.dto.ProfileDto;
import com.bartekOnlineLibrary.onlineLibrary.dto.ProfileDto2;
import com.bartekOnlineLibrary.onlineLibrary.dto.ProfileDtoMaper;
import com.bartekOnlineLibrary.onlineLibrary.model.UserLibrary;
import com.bartekOnlineLibrary.onlineLibrary.service.UserLibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserLibraryController {

    private final UserLibraryService userLibraryService;

    @GetMapping("/usersLibrary")
    public List<UserLibrary> getUserLibrary(){
        return userLibraryService.getUserLibrary();
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<ProfileDto>  getUser(@RequestHeader("Token") String token){
        LoginData loginData = Token.checkToken(token);

        if(loginData == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        else{
            UserLibrary user = userLibraryService.getUserByUsernameAndPassword(loginData.getLogin(), loginData.getPass());
            ProfileDto profile = ProfileDtoMaper.mapToProfileDto(user);
            return ResponseEntity.status(HttpStatus.OK).body(profile);
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HashMap<String,String> login(@RequestBody LoginData loginData ){
         HashMap<String,String> response = new HashMap<>();
        if(userLibraryService.login(loginData) ){
            response.put("Token",Token.setToken(loginData) );
         }
         else{
            response.put("error","Nieprawidłowy login lub hasło");
         }

         return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HashMap<String,String> register(@RequestBody RegisterData registerData){
        HashMap<String,String> response = new HashMap<>();
        if(registerData.getPassword().equals(registerData.getConfirm())){
            String token = userLibraryService.register(registerData);
            if(token != null){
                response.put("message","Z sukcesem udało się zakończyć proces rejestracji w aplikacji.");
                response.put("Token", token);
            }
            else{
                response.put("error","Użytkownik już istnieje");
            }
        }
        else{
            response.put("error","Podałeś dwa różne hasła!");
        }
        return response;
    }

    @RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String, String>> updateProfile(@RequestHeader("Token") String token, @RequestBody ProfileDto2 profileDto2){
        LoginData loginData = Token.checkToken(token);
        HashMap<String,String> response = new HashMap<>();

        if(loginData == null) {
            response.put("error","Jesteś nie zalogowany");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( response);
        }
        else{
            userLibraryService.updateProfile(profileDto2,loginData);
            response.put("message","Profil zaaktualizowany");
            return ResponseEntity.status(HttpStatus.OK).body( response);
        }
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String,String>> changePassword(@RequestHeader("Token") String token, @RequestBody ChangePasswordForm changePasswordForm){
        LoginData loginData = Token.checkToken(token);
        HashMap<String,String> response = new HashMap<>();

        if(loginData == null) {
            response.put("error","Jesteś nie zalogowany");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( response);
        }
        else{
            if(loginData.getPass().equals(changePasswordForm.getOld())){
                if(!changePasswordForm.getNewPassword().equals(changePasswordForm.getConfirm())){
                    response.put("error","Dwa różne hasła");
                    return ResponseEntity.status(HttpStatus.OK).body( response);
                }
                else{
                    userLibraryService.changePassword(changePasswordForm,loginData);
                    response.put("message","Hasło zostało zmienione.");
                    LoginData newLoginData = new LoginData();
                    newLoginData.setLogin(loginData.getLogin());
                    newLoginData.setPass(changePasswordForm.newPassword);
                    response.put("Token",Token.setToken(newLoginData));
                }

            }
            else{
                response.put("error","Stare hasło niepoprawwne");
                return ResponseEntity.status(HttpStatus.OK).body( response);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body( response);
    }


    @RequestMapping(value = "/updatephoto" ,method = RequestMethod.PUT)
    public ResponseEntity<HashMap<String,String>> updatePhoto(@RequestHeader("Token") String token, @RequestParam("file") MultipartFile photo) {
        LoginData loginData = Token.checkToken(token);
        HashMap<String,String> response = new HashMap<>();
        if(loginData == null) {
            response.put("error","Jesteś nie zalogowany");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( response);
        }
        else{
            String fileName = userLibraryService.savePhoto(photo,loginData);
            response.put("message","Zdjęcie Zapisano");
            return ResponseEntity.ok().body(response);
        }

    }

}
