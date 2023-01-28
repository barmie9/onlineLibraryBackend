package com.bartekOnlineLibrary.onlineLibrary.controller;


import java.util.HashMap;


public class Token {
       public static HashMap<String,LoginData> data= new HashMap<>();

       public static String setToken(LoginData loginData){
              String newToken= loginData.getLogin()+" "+loginData.getPass();
              data.put(newToken,loginData);
              return newToken;
       }
       public static LoginData checkToken(String token){
              return data.get(token);
       }

}
