package com.bartekOnlineLibrary.onlineLibrary.service;

import com.bartekOnlineLibrary.onlineLibrary.model.BookGenre;
import com.bartekOnlineLibrary.onlineLibrary.repository.BookGenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookGenreService {

    private final BookGenreRepository bookGenreRepository;

    public List<BookGenre> getBookGenres(){
        return  bookGenreRepository.findAll();
    }

}
