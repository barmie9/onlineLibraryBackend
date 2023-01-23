package com.bartekOnlineLibrary.onlineLibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Book  {
    @Id
    private long id;
    private String title;
    private int price;
    private String content;
    private String descShort;
    private String descLong;
//    private long genreId;

    @OneToOne
    @JoinColumn(name="genre_id") // maybe genreId
    private BookGenre bookGenre;

    @OneToOne
    @JoinColumn(name="author_id")
    private Author author;






}
