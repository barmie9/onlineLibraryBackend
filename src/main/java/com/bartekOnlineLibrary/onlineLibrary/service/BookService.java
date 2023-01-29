package com.bartekOnlineLibrary.onlineLibrary.service;

import com.bartekOnlineLibrary.onlineLibrary.controller.LoginData;
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
public class BookService {

    private final BookRepository bookRepository;
    private final CartItemRepository cartItemRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public List<Book> getBooks(Long c,String q){
        List<Book> allBooks;
        if(c != null && c==0 ){
            allBooks = bookRepository.findAll();
        }
        else if(c != null && c >0 ){
            allBooks = bookRepository.findAllByBookGenreId(c);
        }
        else{
            allBooks = bookRepository.findAll();
        }

        if(q != null){
            return allBooks.stream()
                    .filter(e -> e.getTitle().toLowerCase().contains(q.toLowerCase()))
                    .toList();
        }
        else  return  allBooks;
    }

    public Book getBookById(Long bookId, LoginData loginData){
        List<Book> books = getUserBooks(loginData.getLogin(),loginData.getPass());
        List<Book> filteredBooks = books.stream()
                .filter(e -> e.getId() == bookId)
                .toList();

        if(filteredBooks.isEmpty()) return null;
        else{
            return filteredBooks.get(0);
        }

    }


    //------------------------------------------------------------------------------------------------------------------
    public List<Book> getUserBooks(String username, String password) {
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findAll();
        List<ShoppingCart> carts;
        carts = shoppingCarts.stream()
                .filter(e -> e.getUser().getUsername().equals(username))
                .filter(e -> e.getUser().getPassword().equals(password))
                .filter(e -> e.getTransaction() != null)
                .toList();

        return cartsToBook(carts);
    }
    public List<Book> getUserBooksFromCart(String username, String password){
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findAll();
        List<ShoppingCart> carts;
        carts = shoppingCarts.stream()
                .filter(e -> e.getUser().getUsername().equals(username))
                .filter(e -> e.getUser().getPassword().equals(password))
                .filter(e -> e.getTransaction() == null)
                .toList();

        return cartsToBook(carts);
    }
    private List<Book> cartsToBook(List<ShoppingCart> carts){
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
        return booksFromCart;
    }


}
