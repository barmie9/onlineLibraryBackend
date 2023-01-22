package com.bartekOnlineLibrary.onlineLibrary.repository;


import com.bartekOnlineLibrary.onlineLibrary.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
