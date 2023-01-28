package com.bartekOnlineLibrary.onlineLibrary.service;

import com.bartekOnlineLibrary.onlineLibrary.controller.BookDtoMapper;
import com.bartekOnlineLibrary.onlineLibrary.dto.BookDto;
import com.bartekOnlineLibrary.onlineLibrary.model.Book;
import com.bartekOnlineLibrary.onlineLibrary.model.CartItem;
import com.bartekOnlineLibrary.onlineLibrary.model.ShoppingCart;
import com.bartekOnlineLibrary.onlineLibrary.repository.BookRepository;
import com.bartekOnlineLibrary.onlineLibrary.repository.CartItemRepository;
import com.bartekOnlineLibrary.onlineLibrary.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;

    public List<ShoppingCart> getShoppingCarts(){
        return shoppingCartRepository.findAll();
    }

    public List<BookDto> getUserShoppingCart(String username, String password){
        return mapAll(getShoppingCarts(),username,password,false);
    }
    public List<BookDto> getUserBooks(String username, String password){
        return mapAll(getShoppingCarts(),username,password,true);
    }



    private  List<BookDto> mapAll(List<ShoppingCart> shoppingCarts,  String username, String password, boolean isUserBooks){

        List<ShoppingCart> carts;

        if(isUserBooks){
            carts = shoppingCarts.stream()
                    .filter( e  -> e.getUser().getUsername().equals(username) )
                    .filter(e -> e.getUser().getPassword().equals(password) )
                    .filter(e -> e.getTransaction() != null)
                    .toList();
        }
        else{
            carts = shoppingCarts.stream()
                    .filter( e  -> e.getUser().getUsername().equals(username) )
                    .filter(e -> e.getUser().getPassword().equals(password) )
                    .filter(e -> e.getTransaction() == null)
                    .toList();
        }


        List<CartItem> cartItems = new ArrayList<>();
        for (ShoppingCart c: carts) {
            cartItems.addAll(cartItemRepository.findAllByShoppingCartId(c.getId()));
        }

        List<Book> books = bookRepository.findAll();

        List<Book> booksFromCart = new ArrayList<>();
        for (Book b: books) {
            for (CartItem c: cartItems) {
                if(b.getId()==c.getBookId())
                {
                    booksFromCart.add(b);
                }
            }
        }

        return BookDtoMapper.mapToBookDtos(booksFromCart);

    }

}
