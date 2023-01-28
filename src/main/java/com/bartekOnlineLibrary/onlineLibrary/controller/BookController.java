package com.bartekOnlineLibrary.onlineLibrary.controller;
import com.bartekOnlineLibrary.onlineLibrary.dto.BookDto;
import com.bartekOnlineLibrary.onlineLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<BookDto> getBooks(@RequestParam(value = "c", required = false) Long c, @RequestParam(value = "q", required = false) String q){
        return BookDtoMapper.mapToBookDtos(bookService.getBooks(c,q));
    }

}
