package com.IngBanking.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AccountResponseDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String status;
}
