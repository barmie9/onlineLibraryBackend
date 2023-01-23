package com.bartekOnlineLibrary.onlineLibrary.repository;

import com.bartekOnlineLibrary.onlineLibrary.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
}
