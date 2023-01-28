package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.model.CartItem;
import com.bartekOnlineLibrary.onlineLibrary.service.CartItemService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;




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

    @RequestMapping(value="/deleteCartItem/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteCartItem(@PathVariable Long id){
        cartItemService.deleteCartItem(id);
        return HttpStatus.NO_CONTENT;
    }

}

