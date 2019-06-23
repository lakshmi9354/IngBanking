package com.IngBanking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IngBanking.dto.AccountDetailsDTO;
import com.IngBanking.dto.AccountRequestDTO;
import com.IngBanking.dto.AccountResponseDTO;
import com.IngBanking.service.AccountService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = {"*","*/"},origins = {"*","*/"})
public class AccountController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/createAccount")
	public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO accountRequestDTO){
		LOGGER.debug("AccountController:createAccount \n {}", accountRequestDTO);
		AccountResponseDTO accountResponseDTO = accountService.createAccount(accountRequestDTO);
		return new ResponseEntity<AccountResponseDTO>(accountResponseDTO,HttpStatus.OK);
	}
	
	@GetMapping(value="/summary/{userId}")	
	public ResponseEntity<List<AccountDetailsDTO>> accountSummery(@PathVariable("userId") Long userId){
		  LOGGER.debug("AccountController:accountSummary {} ", userId);
		return new ResponseEntity<>(accountService.accountSummary(userId),HttpStatus.OK);  
		  
	  }	
}
