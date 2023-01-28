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

}
