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
    public HttpStatus addItemCart(@RequestBody CartItem cartItem){
        return cartItemService.addCartItem(cartItem) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value="/deleteCartItem/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteCartItem(@PathVariable Long id){
        cartItemService.deleteCartItem(id);
        return HttpStatus.NO_CONTENT;
    }

}
