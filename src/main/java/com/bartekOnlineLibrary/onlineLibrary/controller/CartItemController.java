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

    @RequestMapping(value = "/addCartItem", method = RequestMethod.POST)
    public CartItem addItemCart(@RequestBody JsonToLong book, @RequestHeader("Username") String username, @RequestHeader("Password") String password){

        CartItem cartItem= cartItemService.addCartItem(book.getBook(),username,password);
        if(cartItem != null) return cartItem;
        else return new CartItem(); // Do poprawy (Na razie zwraca pustego CartItem jesli ksiazka jest juz w koszyku lub kupiona)
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

