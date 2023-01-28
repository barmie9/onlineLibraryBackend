package com.bartekOnlineLibrary.onlineLibrary.service;

import com.bartekOnlineLibrary.onlineLibrary.controller.LoginData;
import com.bartekOnlineLibrary.onlineLibrary.controller.RegisterData;
import com.bartekOnlineLibrary.onlineLibrary.controller.Token;
import com.bartekOnlineLibrary.onlineLibrary.model.ShoppingCart;
import com.bartekOnlineLibrary.onlineLibrary.model.UserLibrary;
import com.bartekOnlineLibrary.onlineLibrary.repository.ShoppingCartRepository;
import com.bartekOnlineLibrary.onlineLibrary.repository.UserLibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLibraryService {

    private final UserLibraryRepository userLibraryRepository;
    private final ShoppingCartRepository shoppingCartRepository;

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

    public String register(RegisterData registerData){

        if(userLibraryRepository.findByUsername(registerData.getUsername()) == null){ // Sprawdzenie czy uzytkownik istnieje
            UserLibrary userLibrary = new UserLibrary();
            userLibrary.setName(registerData.getName());
            userLibrary.setEmail(registerData.getEmail());
            userLibrary.setPassword(registerData.getPassword());
            userLibrary.setLastName(registerData.getSurname());
            userLibrary.setUsername(registerData.getUsername());
            userLibrary.setDateOfBirth(null);
            userLibrary.setPicture(null);
            UserLibrary response = userLibraryRepository.save(userLibrary);

            // Tworzenie koszyka dla użytkownika
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setUser(response);
            shoppingCart.setTransaction(null);
            ShoppingCart cartResponse = shoppingCartRepository.save(shoppingCart);
            if(response != null && cartResponse != null){
                LoginData loginData = new LoginData();
                loginData.setLogin(registerData.getUsername());
                loginData.setPass(registerData.getPassword());
                String token = Token.setToken(loginData);
                return token;
            }
            else{
                return null;
            }
        }
        else return null;


    }
}
