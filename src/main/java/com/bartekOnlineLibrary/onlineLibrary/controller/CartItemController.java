package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.model.CartItem;
import com.bartekOnlineLibrary.onlineLibrary.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @RequestMapping(value = "/addCartItem", method = RequestMethod.POST)
    public HttpStatus addItemCart(@RequestBody CartItem cartItem){
        return cartItemService.addCartItem(cartItem) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }
}
