package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.model.CartItem;
import com.bartekOnlineLibrary.onlineLibrary.service.CartItemService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @RequestMapping(value = "/addtocart", method = RequestMethod.POST)
    public HashMap<String,String> addItemCart(@RequestBody JsonToLong book, @RequestHeader("Token") String token){
        LoginData loginData = Token.checkToken(token);
        CartItem cartItem = null;
        HashMap<String,String> response = new HashMap<>();
        if(loginData == null){
            response.put("error","Nie jesteś zalogowany");
            return response;
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
        return response;
    }

    @RequestMapping(value="/deleteCartItem", method = RequestMethod.DELETE)
    public HashMap<String,String> deleteCartItem(@RequestBody JsonToLong book, @RequestHeader("Username") String username, @RequestHeader("Password") String password){
        if(cartItemService.deleteCartItem(book.getBook(),username,password))
        {
            return getResponse("BOOK REMOVE","OK");
        }
        else{
            return getResponse("BOOK REMOVE","ERROR");
        }

    }

    public HashMap<String,String> getResponse(String name, String status){
        HashMap<String, String> response = new HashMap<String, String>();
        response.put(name,status);
        return response;
    }

}

