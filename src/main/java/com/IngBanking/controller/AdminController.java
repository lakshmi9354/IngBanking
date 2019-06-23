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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IngBanking.dto.ApprovalDTO;
import com.IngBanking.service.AdminService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class AdminController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	@GetMapping("/users")
	public ResponseEntity<List<ApprovalDTO>> getapprovalsList() {
		LOGGER.debug("get all UsersList: {}");
		List<ApprovalDTO> approvalDtos = adminService.getallusersList();
		return new ResponseEntity<>(approvalDtos, HttpStatus.OK);
	}

	@GetMapping("/approval/{accountId}/{status}")
	public ResponseEntity<ApprovalDTO> adminApproval(@PathVariable(name = "accountId") Long accountId,
			@PathVariable("status") String status) {
		LOGGER.debug("getUsers by accountId : {}", accountId);
		ApprovalDTO approvalDto = adminService.adminApproval(accountId, status);
		return new ResponseEntity<>(approvalDto, HttpStatus.OK);
	}
}
