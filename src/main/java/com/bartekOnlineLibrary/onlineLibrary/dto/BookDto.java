package com.bartekOnlineLibrary.onlineLibrary.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@Setter
@ToString
public class BookDto  {

    // BOOK
    private long id;
    private String title;
    private int price;
    private String content;

    // BOOK_GENRE
    private String name;

    // AUTHOR
    private String author;

}
