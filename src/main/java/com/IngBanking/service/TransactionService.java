package com.IngBanking.service;

import com.IngBanking.dto.TransactionDTO;
import com.IngBanking.dto.TransactionDetailsDTO;

public interface TransactionService {

	public TransactionDetailsDTO fundTransfer(TransactionDTO transactionDTO);
	
}
