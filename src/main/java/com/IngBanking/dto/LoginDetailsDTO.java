package com.IngBanking.dto;

import java.io.Serializable;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private String message;
	private String role;
}
