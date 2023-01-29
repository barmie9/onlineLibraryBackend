package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.dto.BookDto;
import com.bartekOnlineLibrary.onlineLibrary.model.ShoppingCart;
import com.bartekOnlineLibrary.onlineLibrary.service.ShoppingCartService;
import com.bartekOnlineLibrary.onlineLibrary.service.UserLibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final UserLibraryService userLibraryService;

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
    @RequestMapping(value = "/payblik", method = RequestMethod.POST)
    public PayResponseForm payForCart(@RequestHeader("Token") String token,@RequestBody payBlikForm payBlikForm){
        LoginData loginData = Token.checkToken(token);
        PayResponseForm payResponseForm = new PayResponseForm();
        if(loginData == null) {
            payResponseForm.setMessage("nie jestes zalogowany");
            payResponseForm.setSuccess(false);
            return payResponseForm;
        }
        else{
            if(payBlikForm.getCode().equals("123456"))
            {
                userLibraryService.pay(loginData);
                payResponseForm.setMessage("Płatność ukończona pomyślnie");
                payResponseForm.setSuccess(true);
                return payResponseForm;
            }
            else{
                payResponseForm.setMessage("Zły kod blik");
                payResponseForm.setSuccess(false);
                return payResponseForm;
            }
        }

    }


}
