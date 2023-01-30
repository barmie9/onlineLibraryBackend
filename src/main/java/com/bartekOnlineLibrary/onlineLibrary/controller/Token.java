package com.bartekOnlineLibrary.onlineLibrary.controller;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

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


       // --------------------------- Szyfrowanie nie używane ---------------------------
       private static Key generateKey() throws Exception {
              String keyString = "secretsquirrel";
              byte[] key = keyString.getBytes("UTF-8");
              SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
              return secretKey;
       }

       public static String encrypt(String plainText) throws Exception {
              Key key = generateKey();
              Cipher cipher = Cipher.getInstance("AES");
              cipher.init(Cipher.ENCRYPT_MODE, key);
              byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
              return Base64.getEncoder().encodeToString(encryptedBytes);
       }

       public static String decrypt(String encryptedText) throws Exception {
              Key key = generateKey();
              Cipher cipher = Cipher.getInstance("AES");
              cipher.init(Cipher.DECRYPT_MODE, key);
              byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
              return new String(decryptedBytes);
       }
       //---------------------------------------------------------------------------------


}
