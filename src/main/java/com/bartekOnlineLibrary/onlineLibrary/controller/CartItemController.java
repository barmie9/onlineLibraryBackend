package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.model.CartItem;
import com.bartekOnlineLibrary.onlineLibrary.service.CartItemService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @RequestMapping(value = "/addtocart", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String,String>> addItemCart(@RequestBody JsonToLong book, @RequestHeader("Token") String token){
        LoginData loginData = Token.checkToken(token);
        CartItem cartItem ;
        HashMap<String,String> response = new HashMap<>();

        if(loginData == null) {
            response.put("error","Nie jesteś zalogowany");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( response );
        }
        else{
           cartItem= cartItemService.addCartItem(book.getBook(),loginData.getLogin(),loginData.getPass());
        }


        if(cartItem != null){
            response.put("message","Produkt dodano do koszyka");
        }
        else{
            response.put("message","Nie doodano do koszyka");
        }
        return ResponseEntity.status(HttpStatus.OK).body( response );
    }

    @RequestMapping(value="/removefromcart", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String,String>> deleteCartItem(@RequestBody JsonToLong book, @RequestHeader("Token") String token){
        LoginData loginData = Token.checkToken(token);
        HashMap<String,String> response = new HashMap<>();

        if(loginData == null) {
            response.put("error","Nie jesteś zalogowany");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( response);
        }
        else {
            if( cartItemService.deleteCartItem(book.getBook(), loginData.getLogin(), loginData.getPass()) ){
                response.put("message","Produkt pomyślnie wyeliminowany");
                return ResponseEntity.status(HttpStatus.OK).body( response);
            }
            else{
                response.put("error","Nie znaleziono ksiązki w koszyku");
                return ResponseEntity.status(HttpStatus.OK).body( response);
            }
        }
    }


    //------------------------------------------------------------------------------------------------------------------
    public HashMap<String,String> getResponse(String name, String status){
        HashMap<String, String> response = new HashMap<>();
        response.put(name,status);
        return response;
    }

}

