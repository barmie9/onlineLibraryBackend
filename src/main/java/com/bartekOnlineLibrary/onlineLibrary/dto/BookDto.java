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
    private String description;
    private String descriptionLong;
    private String picture;

    // BOOK_GENRE
    private String genreText;
    private long genre;

    // AUTHOR
    private String author;

    //COMMENT
    private int rating;

}
