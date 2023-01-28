package com.bartekOnlineLibrary.onlineLibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long bookId;
//    private long shoppingCartId;

    @OneToOne
    @JoinColumn(name="shopping_cart_id")
    private ShoppingCart shoppingCart;
}
