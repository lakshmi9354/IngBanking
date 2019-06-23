package com.IngBanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IngBanking.dto.TransactionDTO;
import com.IngBanking.dto.TransactionDetailsDTO;
import com.IngBanking.service.TransactionService;

@RestController
@CrossOrigin(allowedHeaders = {"*","/"} , origins = {"*","/"})
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	private TransactionService TransactionService;
	
	@PostMapping("/transfer")
	public ResponseEntity<TransactionDetailsDTO> fundTransfer(@RequestBody TransactionDTO transactionDTO)
	{
		TransactionDetailsDTO transactionDetailsDTO=TransactionService.fundTransfer(transactionDTO);
		return new ResponseEntity<>(transactionDetailsDTO,HttpStatus.OK);
		
	}
	
}

