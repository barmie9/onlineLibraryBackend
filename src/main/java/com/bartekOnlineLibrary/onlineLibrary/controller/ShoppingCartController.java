package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.model.ShoppingCart;
import com.bartekOnlineLibrary.onlineLibrary.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @GetMapping("/carts")
    public List<ShoppingCart> getShoppingCarts(){
        return shoppingCartService.getShoppingCarts();
    }
}
