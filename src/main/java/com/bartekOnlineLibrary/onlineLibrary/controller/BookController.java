package com.bartekOnlineLibrary.onlineLibrary.controller;
import com.bartekOnlineLibrary.onlineLibrary.dto.BookDescDto;
import com.bartekOnlineLibrary.onlineLibrary.dto.BookDescDtoMapper;
import com.bartekOnlineLibrary.onlineLibrary.dto.BookDto;
import com.bartekOnlineLibrary.onlineLibrary.dto.BookReadDto;
import com.bartekOnlineLibrary.onlineLibrary.model.Book;
import com.bartekOnlineLibrary.onlineLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
    public ResponseEntity<BookReadDto> getBookToRead(@RequestParam(value = "id") Long id, @RequestHeader("Token") String token){
        LoginData loginData = Token.checkToken(token);
        if(loginData == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        else{
            Book book = bookService.getBookById(id,loginData);
            if(book == null) return null;
            else{
                return ResponseEntity.status(HttpStatus.OK).body(BookDtoMapper.mapToBookReadDto(book));
            }
        }
    }

    @RequestMapping(value = "/bookdescription", method = RequestMethod.GET)
    public BookDescDto getBookDesc(@RequestParam(value = "id") Long id){
        Book book = bookService.getBookDesc(id);
        return BookDescDtoMapper.mapToBookDescDto(book);
    }

    @GetMapping("/pictures/{filename}")
    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable String filename) throws IOException {
        File file = new File("zdj/" + filename + ".jpg");
        if(!file.exists()){
            if(filename.contains("book")){
                file = new File("zdj/default_book.jpg");
            }
            else {
                file = new File("zdj/default_profile.jpg");
            }
        }

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        if(filename.contains("profile")){
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                    .header(HttpHeaders.CACHE_CONTROL, "no-store")
                    .contentType(MediaType.IMAGE_JPEG)
                    .contentLength(file.length())
                    .body(resource);
        }
        else{
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                    .contentType(MediaType.IMAGE_JPEG)
                    .contentLength(file.length())
                    .body(resource);
        }
    }
}
