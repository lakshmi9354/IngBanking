package com.IngBanking.service;

import com.IngBanking.dto.AccountRequestDTO;
import com.IngBanking.dto.AccountResponseDTO;

public interface AccountService {
	public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO);
}
