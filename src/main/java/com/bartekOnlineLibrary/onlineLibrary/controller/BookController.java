package com.bartekOnlineLibrary.onlineLibrary.controller;
import com.bartekOnlineLibrary.onlineLibrary.dto.BookDescDto;
import com.bartekOnlineLibrary.onlineLibrary.dto.BookDescDtoMapper;
import com.bartekOnlineLibrary.onlineLibrary.dto.BookDto;
import com.bartekOnlineLibrary.onlineLibrary.dto.BookReadDto;
import com.bartekOnlineLibrary.onlineLibrary.model.Book;
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

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public BookReadDto getBookToRead(@RequestParam(value = "id") Long id, @RequestHeader("Token") String token){
        LoginData loginData = Token.checkToken(token);
        if(loginData == null) return null;
        else{
            Book book = bookService.getBookById(id,loginData);
            if(book == null) return null;
            else{
                return BookDtoMapper.mapToBookReadDto(book);
            }
        }
    }

    @RequestMapping(value = "/bookdescription", method = RequestMethod.GET)
    public BookDescDto getBookDesc(@RequestParam(value = "id") Long id){
        Book book = bookService.getBookDesc(id);
        return BookDescDtoMapper.mapToBookDescDto(book);
    }

}
