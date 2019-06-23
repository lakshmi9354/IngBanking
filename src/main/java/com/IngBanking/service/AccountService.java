package com.IngBanking.service;

import java.util.List;

import com.IngBanking.dto.AccountDetailsDTO;
import com.IngBanking.dto.AccountRequestDTO;
import com.IngBanking.dto.AccountResponseDTO;

public interface AccountService {
	public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO);
	public List<AccountDetailsDTO> accountSummary(Long userId);	
}
