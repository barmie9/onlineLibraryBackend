package com.bartekOnlineLibrary.onlineLibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ShoppingCart {
    @Id
    private long id;
//    private long userId;
//    private long transactionId;


    // -------------------------------  TEST       -------------------------------
    @OneToOne
    @JoinColumn(name="user_id") // maybe genreId
    private UserLibrary user;

    @OneToOne
    @JoinColumn(name="transaction_id") // maybe genreId
    private Transaction transaction;
    // ---------------------------------------------------------------------------



}
