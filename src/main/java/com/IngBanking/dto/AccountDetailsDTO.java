package com.IngBanking.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AccountDetailsDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String accountNumber;
	private Double balance;
	private String accountType;
	private String status;

}
