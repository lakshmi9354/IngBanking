package com.IngBanking.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IngBanking.dto.AccountDetailsDTO;
import com.IngBanking.dto.AccountRequestDTO;
import com.IngBanking.dto.AccountResponseDTO;
import com.IngBanking.entity.Account;
import com.IngBanking.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
	@Autowired
	AccountRepository accountRepository;

	public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO) {
		LOGGER.debug("AccountServiceImpl createAccount()");
		AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
		Account account = new Account();
		account.setFirstName(accountRequestDTO.getFirstName());
		account.setLastName(accountRequestDTO.getLastName());
		account.setAccountType(accountRequestDTO.getAccountType());
		account.setAddress(accountRequestDTO.getAddress());
		account.setAge(accountRequestDTO.getAge());
		account.setPAN(accountRequestDTO.getPAN());
		account.setEmail(accountRequestDTO.getEmail());
		account.setGender(accountRequestDTO.getGender());
		account.setPhNum(accountRequestDTO.getPhNum());
		account.setPurpose(accountRequestDTO.getPurpose());
		account.setStatus("Pending");
		accountRepository.save(account);
		BeanUtils.copyProperties(account, accountResponseDTO);
		return accountResponseDTO;
	}

	public List<AccountDetailsDTO> accountSummary(Long userId) {
		LOGGER.debug("AccountServiceImpl summary {}", userId);
		List<AccountDetailsDTO> accountDetailsDTOs = new ArrayList<>();
		List<Account> accounts = accountRepository.findByUserId(userId);
		LOGGER.debug("accounts size {}", accounts.size());
		for(Account account:accounts) {
			AccountDetailsDTO accountDetailsDTO = new AccountDetailsDTO();
			BeanUtils.copyProperties(account, accountDetailsDTO);
			accountDetailsDTOs.add(accountDetailsDTO);
		}
		return accountDetailsDTOs;
	}

}
