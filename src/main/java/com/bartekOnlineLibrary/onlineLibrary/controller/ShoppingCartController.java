package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.dto.BookDto;
import com.bartekOnlineLibrary.onlineLibrary.model.ShoppingCart;
import com.bartekOnlineLibrary.onlineLibrary.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
    public List<BookDto> getUserCart(@RequestHeader("Token") String token){
        LoginData loginData = Token.checkToken(token);
        if(loginData != null) return shoppingCartService.getUserShoppingCart(loginData.getLogin(),loginData.getPass());
        else return new ArrayList<BookDto>();
    }
    @GetMapping("/mybooks")
    public List<BookDto> getUserBooks(@RequestHeader("Token") String token){
        LoginData loginData = Token.checkToken(token);
        if(loginData == null){
            return new ArrayList<>();
        }
        else{
            return shoppingCartService.getUserBooks(loginData.getLogin(), loginData.getPass());
        }

    }
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public HashMap<String,String> payForCart(@RequestHeader("Username") String username, @RequestHeader("Password") String password,@RequestBody  PayForm payForm){
        return getResponse("STATUS","OK");
    }

    public HashMap<String,String> getResponse(String name, String status){
        HashMap<String, String> response = new HashMap<String, String>();
        response.put(name,status);
        return response;
    }


}
