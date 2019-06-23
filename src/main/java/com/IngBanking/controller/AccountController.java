package com.IngBanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IngBanking.dto.AccountRequestDTO;
import com.IngBanking.dto.AccountResponseDTO;
import com.IngBanking.service.AccountService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = {"*","*/"},origins = {"*","*/"})
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/createAccount")
	public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO accountRequestDTO){
		AccountResponseDTO accountResponseDTO = accountService.createAccount(accountRequestDTO);
		return new ResponseEntity<AccountResponseDTO>(accountResponseDTO,HttpStatus.OK);
	}
}
