package com.bartekOnlineLibrary.onlineLibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Author {
    @Id
    private long id;
    private String name;
    private String lastName;
    private String dateOfBirth;
    private String dateOfDeath;
}
