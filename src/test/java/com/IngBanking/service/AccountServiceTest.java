package com.IngBanking.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.IngBanking.dto.AccountRequestDTO;
import com.IngBanking.dto.AccountResponseDTO;
import com.IngBanking.repository.AccountRepository;
import com.IngBanking.service.AccountServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
	
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	@Mock
	AccountRepository accountRepository;
	
	AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
	AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
	
	@Before
	public void setup() {
		accountRequestDTO.setAccountType("SA");
		accountRequestDTO.setFirstName("Manne");
		accountRequestDTO.setPurpose("sal");
		
		accountResponseDTO.setFirstName("Manne");
		accountResponseDTO.setStatus("Pending");
	}
	
	@Test
	public void accountCreationTest() {
		Mockito.when(accountServiceImpl.createAccount(accountRequestDTO)).thenReturn(accountResponseDTO);
		assertEquals(accountResponseDTO.toString(), accountServiceImpl.createAccount(accountRequestDTO).toString());
	}
}
