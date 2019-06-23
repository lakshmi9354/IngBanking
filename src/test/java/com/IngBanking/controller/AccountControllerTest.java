package com.IngBanking.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.IngBanking.dto.AccountRequestDTO;
import com.IngBanking.dto.AccountResponseDTO;
import com.IngBanking.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class)
public class AccountControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	AccountService accountService;
	
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
	public void createAccountTest() throws Exception {
		Mockito.when(accountService.createAccount(accountRequestDTO)).thenReturn(accountResponseDTO);
		String uri = "/api/createAccount";
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		String expected = this.mapToJson(accountResponseDTO);
		String output = mvcResult.getResponse().getContentAsString();
		assertThat(output).isEqualTo(expected);
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
