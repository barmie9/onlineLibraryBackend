package com.bartekOnlineLibrary.onlineLibrary.service;

import com.bartekOnlineLibrary.onlineLibrary.model.Book;
import com.bartekOnlineLibrary.onlineLibrary.model.CartItem;
import com.bartekOnlineLibrary.onlineLibrary.model.ShoppingCart;
import com.bartekOnlineLibrary.onlineLibrary.model.UserLibrary;
import com.bartekOnlineLibrary.onlineLibrary.repository.BookRepository;
import com.bartekOnlineLibrary.onlineLibrary.repository.CartItemRepository;
import com.bartekOnlineLibrary.onlineLibrary.repository.ShoppingCartRepository;
import com.bartekOnlineLibrary.onlineLibrary.repository.UserLibraryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserLibraryRepository userLibraryRepository;

    @Transactional
    public CartItem addCartItem(Long bookId, String username, String password){
        Book book = getBookById(bookId);
        UserLibrary user = getUserByUsernameAndPassword(username,password);
        Long userId = user.getId();
        ShoppingCart shoppingCart = getUserShoppingCart(userId);

        // ------ Sprawdzenie czy książka jest juz kupiona lub w koszyku -------
        List<CartItem> cartItems = cartItemRepository.findByBookId(bookId);
        boolean isInCartOrBuy = cartItems.stream()
                .filter( e -> e.getShoppingCart().getUser().getId() == userId)
                .toList().isEmpty();

        if(isInCartOrBuy){
            log.info("\n\n------- NIE KUPIONA\n\n");
            CartItem cartItem = new CartItem();
            cartItem.setBookId(book.getId());
            cartItem.setShoppingCart(shoppingCart);
            return cartItemRepository.save(cartItem) ;
        }
        else{
            log.info("\n\n----- KUPIONA LUB W KOSZYKU \n\n");
            return null;
        }

    }

    @Transactional
    public boolean deleteCartItem(Long bookId, String username, String password){
        UserLibrary user = getUserByUsernameAndPassword(username,password);
        ShoppingCart userCart = getUserShoppingCart(user.getId());
        CartItem cartItem = cartItemRepository.findByBookIdAndShoppingCartId(bookId,userCart.getId());
        if(cartItem == null){
            log.info("\n\n------- NIE ZNALEZIONO KSIAZKI W KOSZYKU\n\n");
            return false;
        }
        else{
            log.info("\n\n------- USUWANIE \n\n");
            cartItemRepository.deleteById(cartItem.getId());
            return true;
        }

    }

    Book getBookById(Long id){
        return bookRepository.findById(id).get();
    }
    UserLibrary getUserByUsernameAndPassword(String username, String password){
        return userLibraryRepository.findByUsernameAndPassword(username,password);
    }
    ShoppingCart getUserShoppingCart(Long userId){
        return shoppingCartRepository.findByUserIdAndTransactionId(userId,null);
    }

}
