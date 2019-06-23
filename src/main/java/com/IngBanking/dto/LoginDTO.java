package com.IngBanking.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private String password;
}
