package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.dto.BookDto;
import com.bartekOnlineLibrary.onlineLibrary.dto.BookReadDto;
import com.bartekOnlineLibrary.onlineLibrary.model.Book;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BookDtoMapper {
    private BookDtoMapper(){};

    public static List<BookDto> mapToBookDtos(List<Book> books){
        return books.stream()
                .map(BookDtoMapper::mapToBookDto)
                .collect(Collectors.toList());
    }



    public static BookDto mapToBookDto(Book book){
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .price(book.getPrice())
                .content(book.getContent())
                .description(book.getDescShort())
                .descriptionLong(book.getDescLong())
                .genreText(book.getBookGenre().getName())
                .genre(book.getBookGenre().getId())
                .author(book.getAuthor().getName()+" "+book.getAuthor().getLastName())
                .rating(getRating())
                .build();
    }


    public static List<BookReadDto> mapToBookReadDtos(List<Book> books){
        return books.stream()
                .map(BookDtoMapper::mapToBookReadDto)
                .collect(Collectors.toList());
    }
    public static BookReadDto mapToBookReadDto(Book book){
        return BookReadDto.builder()
                .title(book.getTitle())
                .content(book.getContent())
                .author(book.getAuthor().getName() + " " + book.getAuthor().getLastName())
                .build();
    }

    private static int getRating(){
        return (new Random().nextInt(4))+1;
    }

}
