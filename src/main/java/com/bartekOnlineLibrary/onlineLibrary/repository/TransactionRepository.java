package com.bartekOnlineLibrary.onlineLibrary.repository;

import com.bartekOnlineLibrary.onlineLibrary.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
