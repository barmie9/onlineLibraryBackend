package com.bartekOnlineLibrary.onlineLibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    private long id;
    private int rating;
    private String content;
    private LocalDate created; // To check
    private long bookId;
    private long userId;
}
