package com.bartekOnlineLibrary.onlineLibrary.repository;


import com.bartekOnlineLibrary.onlineLibrary.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    @Query
    List<CartItem> findAllByShoppingCartId(Long shoppingCartId);

    @Query
    List<CartItem> findByBookId(Long bookId);

    @Query
    CartItem findByBookIdAndShoppingCartId(Long bookId,Long shoppingCartId);
}
