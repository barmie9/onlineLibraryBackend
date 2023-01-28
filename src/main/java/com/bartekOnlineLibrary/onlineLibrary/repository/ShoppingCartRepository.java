package com.bartekOnlineLibrary.onlineLibrary.repository;

import com.bartekOnlineLibrary.onlineLibrary.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    @Query
    ShoppingCart findByUserIdAndTransactionId(Long userId, Long TransactionId);

    @Query
    List<ShoppingCart> findByUserId(Long userId);

}
