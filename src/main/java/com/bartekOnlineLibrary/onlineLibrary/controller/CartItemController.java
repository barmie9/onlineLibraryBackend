package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.model.CartItem;
import com.bartekOnlineLibrary.onlineLibrary.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @RequestMapping(value = "/addCartItem", method = RequestMethod.POST)
    public CartItem addItemCart(@RequestBody CartItem cartItem){

//        return cartItemService.addCartItem(cartItem) ? Map("key1", "value") : Map.of("key1", "value") ;
        return cartItemService.addCartItem(cartItem);
    }

    @RequestMapping(value="/deleteCartItem/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteCartItem(@PathVariable Long id){
        cartItemService.deleteCartItem(id);
        return HttpStatus.NO_CONTENT;
    }

}
