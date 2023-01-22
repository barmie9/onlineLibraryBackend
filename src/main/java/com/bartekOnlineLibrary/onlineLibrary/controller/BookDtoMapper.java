package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.dto.BookDto;
import com.bartekOnlineLibrary.onlineLibrary.model.Book;

import java.util.List;
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
                .name(book.getBookGenre().getName())
                .build();
    }
}
