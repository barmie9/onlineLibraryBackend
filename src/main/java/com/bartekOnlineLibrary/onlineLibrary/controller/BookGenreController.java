package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.model.BookGenre;
import com.bartekOnlineLibrary.onlineLibrary.service.BookGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookGenreController {

    private final BookGenreService bookGenreService;

    @GetMapping("/categories")
    public List<BookGenre> getBookGenres(){
        return bookGenreService.getBookGenres();
    }
}
