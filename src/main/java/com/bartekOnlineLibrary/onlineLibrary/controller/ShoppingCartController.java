package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.dto.BookDto;
import com.bartekOnlineLibrary.onlineLibrary.model.ShoppingCart;
import com.bartekOnlineLibrary.onlineLibrary.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
    @GetMapping("/cart")
    public List<BookDto> getUserCart(@RequestHeader("Username") String username, @RequestHeader("Password") String password){
        return shoppingCartService.getUserShoppingCart(username,password);
    }
    @GetMapping("/myBooks")
    public List<BookDto> getUserBooks(@RequestHeader("Username") String username, @RequestHeader("Password") String password){
        return shoppingCartService.getUserBooks(username,password);
    }
}
