package com.bartekOnlineLibrary.onlineLibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartItem {
    @Id
    private long id;
    private long bookId;
    private long shoppingCartId;
}
