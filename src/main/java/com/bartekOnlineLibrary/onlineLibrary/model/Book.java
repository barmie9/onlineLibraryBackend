package com.bartekOnlineLibrary.onlineLibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    private long id;
    private String title;
    private int price;
    private String content;
//    private long genreId;

    @OneToOne
    @JoinColumn(name="genre_id") // maybe genreId
    private BookGenre bookGenre;




}
