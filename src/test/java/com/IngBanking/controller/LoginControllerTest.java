package com.IngBanking.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.IngBanking.dto.LoginDTO;
import com.IngBanking.dto.LoginDetailsDTO;
import com.IngBanking.entity.User;
import com.IngBanking.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginController.class)
public class LoginControllerTest {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	LoginService loginService;

	@Test
	public void getLogin() throws Exception {
		User user = new User();
		LoginDetailsDTO loginDetailsDTO = new LoginDetailsDTO();
		LoginDTO loginDTO = new LoginDTO();
		loginDetailsDTO.setUserId(1L);
		loginDetailsDTO.setRole("Admin");
		loginDetailsDTO.setMessage("Login Successfull");
		Mockito.when(loginService.validateLogin(loginDTO)).thenReturn(loginDetailsDTO);

		mockMvc.perform(put("/api/login").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
