package com.IngBanking.service;

import com.IngBanking.dto.LoginDTO;
import com.IngBanking.dto.LoginDetailsDTO;
import com.IngBanking.exception.UserNotFoundException;

public interface LoginService {
 public LoginDetailsDTO validateLogin(LoginDTO loginDTO) throws UserNotFoundException;

}
