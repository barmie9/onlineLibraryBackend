package com.bartekOnlineLibrary.onlineLibrary.service;

import com.bartekOnlineLibrary.onlineLibrary.controller.LoginData;
import com.bartekOnlineLibrary.onlineLibrary.model.UserLibrary;
import com.bartekOnlineLibrary.onlineLibrary.repository.UserLibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLibraryService {

    private final UserLibraryRepository userLibraryRepository;

    public List<UserLibrary> getUserLibrary(){
        return userLibraryRepository.findAll();
    }

    public UserLibrary getUserByUsernameAndPassword(String username, String password){
        return userLibraryRepository.findByUsernameAndPassword(username,password);
    }

    public boolean login (LoginData loginData){
        UserLibrary userLibrary = userLibraryRepository.findByUsernameAndPassword(loginData.getLogin(),loginData.getPass());

        if(userLibrary == null) return false; // Nieudane logowanie
        else return true; // Udane logowanie
    }
}
