package com.bartekOnlineLibrary.onlineLibrary.service;

import com.bartekOnlineLibrary.onlineLibrary.model.Book;
import com.bartekOnlineLibrary.onlineLibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

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
}
