package com.IngBanking.service;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IngBanking.dto.ApprovalDTO;
import com.IngBanking.entity.Account;
import com.IngBanking.entity.User;
import com.IngBanking.repository.AdminRepository;
import com.IngBanking.repository.UserRepository;

@Service
@Transactional

public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MailService mailService;

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	public static final String STATUS_APPROVED = "APPROVED";
	public static final String STATUS_REJECTED = "REJECTED";

	public ApprovalDTO adminApproval(Long accountId, String status) {
		LOGGER.debug("findAccountById {}", accountId);
		ApprovalDTO approvalDTO = new ApprovalDTO();
		Account accounts = adminRepository.findById(accountId).get();
		if(!Objects.isNull(accounts)) {
			Random rand = new Random();
			String email = accounts.getEmail();
			if (status.equalsIgnoreCase(STATUS_APPROVED))		{
				User user=userRepository.findByEmail(email);
				Long accountNumber1 = 1000000000000L + rand.nextInt(999999999);
				String accountNumber=String.valueOf(accountNumber1);
				accounts.setAccountNumber(accountNumber);
			
				if(isNull(user))
				{
					Long userId = 1L + rand.nextInt(9);
					Long passcode=100000L+rand.nextInt(99999999);
					String password=String.valueOf(passcode);
					user = new User();
					user.setUserId(userId);
					user.setUserName(accounts.getFirstName());
					user.setPassword(password);
					user.setRole("user");
					user.setEmail(accounts.getEmail());
					userRepository.save(user);
					mailService.sendEmail(user.getEmail(),user.getUserName(),user.getPassword(),accounts.getAccountNumber(),user.getUserId());
				}
			}
			accounts.setStatus(status);
			adminRepository.save(accounts);
			BeanUtils.copyProperties(accounts, approvalDTO);
		}
		return approvalDTO;
	}


	public List<ApprovalDTO> getallusersList() {
		
		List<Account> accounts=adminRepository.findAll();
	
		
		List<ApprovalDTO> approvalDTOs=new ArrayList<>();
		for (Account account : accounts) {
			if (account.getStatus().equalsIgnoreCase("Pending")) {
				ApprovalDTO approvalDto = new ApprovalDTO();
				BeanUtils.copyProperties(account, approvalDto);
				approvalDTOs.add(approvalDto);
			}
		}

		return approvalDTOs;
	}
	

}


