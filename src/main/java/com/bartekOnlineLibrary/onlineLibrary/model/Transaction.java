package com.bartekOnlineLibrary.onlineLibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Transaction {
    @Id
    private long id;
    private LocalDate dateTransaction; // To check
}
