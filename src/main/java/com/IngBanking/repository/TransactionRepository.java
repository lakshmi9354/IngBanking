package com.IngBanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IngBanking.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	public Transaction findByFromAccount(String accountNumber);
	
}
