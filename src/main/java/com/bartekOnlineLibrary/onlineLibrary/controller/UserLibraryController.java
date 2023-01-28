package com.bartekOnlineLibrary.onlineLibrary.controller;

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

    @GetMapping("/user")
    public UserLibrary getUser(@RequestHeader("Username") String username, @RequestHeader("Password") String password){
        return userLibraryService.getUserByUsernameAndPassword(username,password);
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
                response.put("token", token);
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

}
