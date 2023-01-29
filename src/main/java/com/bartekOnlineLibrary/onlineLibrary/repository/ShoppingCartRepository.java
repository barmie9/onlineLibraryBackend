package com.bartekOnlineLibrary.onlineLibrary.repository;

import com.bartekOnlineLibrary.onlineLibrary.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    @Query
    ShoppingCart findByUserIdAndTransactionId(Long userId, Long TransactionId);

    @Query
    List<ShoppingCart> findByUserId(Long userId);

    @Modifying
    @Transactional
    @Query("UPDATE ShoppingCart s SET s.transaction.id = :transactionId WHERE s.user.id = :userId and s.transaction.id = null")
    void updateTransactionById(@Param("transactionId") Long transactionId, @Param("userId") Long userId );

}
