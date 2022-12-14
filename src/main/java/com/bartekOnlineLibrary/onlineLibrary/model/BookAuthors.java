package com.bartekOnlineLibrary.onlineLibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookAuthors {
    @Id
    private long id;
    private long bookId;
    private long authorId;

//    @OneToOne
//    @JoinColumn(name = "bookId")
//    private Book book;
//
//    @OneToOne
//    @JoinColumn(name = "authorId")
//    private Author author;

}
