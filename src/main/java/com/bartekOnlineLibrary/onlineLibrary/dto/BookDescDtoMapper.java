package com.bartekOnlineLibrary.onlineLibrary.dto;

import com.bartekOnlineLibrary.onlineLibrary.model.Book;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BookDescDtoMapper {
    private BookDescDtoMapper(){};

    public static List<BookDescDto> mapBookDescDtos(List<Book> books){
        return books.stream()
                .map(BookDescDtoMapper::mapToBookDescDto)
                .collect(Collectors.toList());
    }

    public static BookDescDto mapToBookDescDto(Book book){
        return BookDescDto.builder()
                .title(book.getTitle())
                .price(book.getPrice())
                .descriptionLong(book.getDescLong())
                .rating(getRating())
                .picture("https://legionowo.pl/img/artykuly/1/2016_09/13374.jpg")
                .genreText(book.getBookGenre().getName())
                .build();
    }

    private static int getRating(){
        return (new Random().nextInt(4))+1;
    }
}
