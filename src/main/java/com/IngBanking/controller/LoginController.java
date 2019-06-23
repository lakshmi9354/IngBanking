package com.IngBanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IngBanking.dto.LoginDTO;
import com.IngBanking.dto.LoginDetailsDTO;
import com.IngBanking.exception.UserNotFoundException;
import com.IngBanking.service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class LoginController {
	@Autowired
	LoginService loginService;

	@PutMapping("/login")
	public ResponseEntity<LoginDetailsDTO> validaetLogin(@RequestBody LoginDTO LoginDTO) throws UserNotFoundException {

		LoginDetailsDTO loginDetailsDTO = loginService.validateLogin(LoginDTO);
		return new ResponseEntity<>(loginDetailsDTO, HttpStatus.OK);
	}
}
