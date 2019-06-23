package com.IngBanking.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private String userName;
	private Long password;
	private String role;
	private String email;
	
}
