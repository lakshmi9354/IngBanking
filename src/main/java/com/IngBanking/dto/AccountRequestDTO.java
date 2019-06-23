package com.IngBanking.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AccountRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String address;
	private int age;
	private String purpose;
	private String email;
	private String city;
	private Long phNum;
	private String accountType;
	private String gender;
}
