package com.IngBanking.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IngBanking.dto.LoginDTO;
import com.IngBanking.dto.LoginDetailsDTO;
import com.IngBanking.entity.User;
import com.IngBanking.exception.UserNotFoundException;
import com.IngBanking.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	LoginRepository loginRepository;

	@SuppressWarnings("unused")
	@Override
	public LoginDetailsDTO validateLogin(LoginDTO loginDTO) throws UserNotFoundException {

		User user = loginRepository.findByUserIdAndPassword(loginDTO.getUserId(), loginDTO.getPassword());

		logger.info(user.toString());
		LoginDetailsDTO loginDetailsDTO = new LoginDetailsDTO();
		
		loginDetailsDTO.setRole(user.getRole());
	
		BeanUtils.copyProperties(user, loginDetailsDTO);

		if (user != null) {
			loginDetailsDTO.setMessage("Login Successfull");
		} else {

			throw new UserNotFoundException("Invalid credential Exception");

		}
		return loginDetailsDTO;
	}
}
