package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.dto.BookDto;
import com.bartekOnlineLibrary.onlineLibrary.model.ShoppingCart;
import com.bartekOnlineLibrary.onlineLibrary.service.ShoppingCartService;
import com.bartekOnlineLibrary.onlineLibrary.service.UserLibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<BookDto>> getUserCart(@RequestHeader("Token") String token){
        LoginData loginData = Token.checkToken(token);
        if(loginData == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( null);
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body( shoppingCartService.getUserShoppingCart(loginData.getLogin(),loginData.getPass()));
        }
    }

    @GetMapping("/mybooks")
    public ResponseEntity<List<BookDto>> getUserBooks(@RequestHeader("Token") String token){
        LoginData loginData = Token.checkToken(token);

        if(loginData == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( null);
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body( shoppingCartService.getUserBooks(loginData.getLogin(), loginData.getPass()));
        }

    }
    @RequestMapping(value = "/payblik", method = RequestMethod.POST)
    public ResponseEntity<PayResponseForm> payForCart(@RequestHeader("Token") String token,@RequestBody PayBlikForm payBlikForm){
        LoginData loginData = Token.checkToken(token);
        PayResponseForm payResponseForm = new PayResponseForm();
        if(loginData == null) {
            payResponseForm.setMessage("nie jestes zalogowany");
            payResponseForm.setSuccess(false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( payResponseForm);
        }
        else{
            if(payBlikForm.getCode().equals("123456"))
            {
                userLibraryService.pay(loginData);
                payResponseForm.setMessage("Płatność ukończona pomyślnie");
                payResponseForm.setSuccess(true);
                return ResponseEntity.status(HttpStatus.OK).body( payResponseForm);
            }
            else{
                payResponseForm.setMessage("Zły kod blik");
                payResponseForm.setSuccess(false);
                return ResponseEntity.status(HttpStatus.OK).body( payResponseForm);
            }
        }
    }

    @RequestMapping(value = "/paycard", method = RequestMethod.POST)
    public ResponseEntity<PayResponseForm> payForCartByCard(@RequestHeader("Token") String token,@RequestBody PayCardForm payCardForm){
        LoginData loginData = Token.checkToken(token);
        PayResponseForm payResponseForm = new PayResponseForm();

        if(loginData == null) {
            payResponseForm.setMessage("nie jestes zalogowany");
            payResponseForm.setSuccess(false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( payResponseForm);
        }
        else{
            if(payCardForm.getProcessor().equals("card") && payCardForm.getNumer().equals("6969696969696969") &&
                    payCardForm.getCvv().equals("420") && payCardForm.getHolder().equals("Jan Kowalski"))
            {
                userLibraryService.pay(loginData);
                payResponseForm.setMessage("Płatność ukończona pomyślnie");
                payResponseForm.setSuccess(true);
                return ResponseEntity.status(HttpStatus.OK).body( payResponseForm);
            }
            else{
                payResponseForm.setMessage("Złe dane karty");
                payResponseForm.setSuccess(false);
                return ResponseEntity.status(HttpStatus.OK).body( payResponseForm);
            }
        }
    }

}
