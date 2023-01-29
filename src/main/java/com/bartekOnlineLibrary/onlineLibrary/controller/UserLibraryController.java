package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.dto.ProfileDto;
import com.bartekOnlineLibrary.onlineLibrary.dto.ProfileDto2;
import com.bartekOnlineLibrary.onlineLibrary.dto.ProfileDtoMaper;
import com.bartekOnlineLibrary.onlineLibrary.model.UserLibrary;
import com.bartekOnlineLibrary.onlineLibrary.service.UserLibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public ProfileDto getUser(@RequestHeader("Token") String token){
        LoginData loginData = Token.checkToken(token);
        if(loginData == null) return null;
        else{
            UserLibrary user = userLibraryService.getUserByUsernameAndPassword(loginData.getLogin(), loginData.getPass());
            ProfileDto profile = ProfileDtoMaper.mapToProfileDto(user);
            return profile;
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
    public HashMap<String, String> updateProfile(@RequestHeader("Token") String token, @RequestBody ProfileDto2 profileDto2){
        LoginData loginData = Token.checkToken(token);
        HashMap<String,String> response = new HashMap<>();
        if(loginData == null){
            response.put("error","Jesteś nie zalogowany");
        }
        else{
            userLibraryService.updateProfile(profileDto2,loginData);
            response.put("message","Profil zaaktualizowany");
        }
        return  response;
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public HashMap<String, String> changePassword(@RequestHeader("Token") String token, @RequestBody ChangePasswordForm changePasswordForm){
        LoginData loginData = Token.checkToken(token);
        HashMap<String,String> response = new HashMap<>();
        if(loginData == null){
            response.put("error","Jesteś nie zalogowany");
        }
        else{
            if(loginData.getPass().equals(changePasswordForm.getOld())){
                if(!changePasswordForm.getNewPassword().equals(changePasswordForm.getConfirm())){
                    response.put("error","Dwa różne hasła");
                    return  response;
                }
                else{
                    userLibraryService.changePassword(changePasswordForm,loginData);
                    response.put("message","Hasło zostało zmienione.");
                    response.put("Token",Token.setToken(loginData));
                }

            }
            else{
                response.put("error","Stare hasło niepoprawwne");
                return  response;
            }
        }
        return  response;
    }
}
