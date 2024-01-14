package com.smartbudget.smartbudget.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByCategoryContainingIgnoreCase(String category);
}
