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

    public List<Book> getBooks(Long c){
        if(c == 0)
            return bookRepository.findAll();
        else
            return bookRepository.findAllByBookGenreId(c);
    }
}
