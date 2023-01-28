package com.bartekOnlineLibrary.onlineLibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class UserLibrary {
    @Id
    private long id;
    private String email;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth; // To check
    @Lob
    private byte[] picture; // To check
}
