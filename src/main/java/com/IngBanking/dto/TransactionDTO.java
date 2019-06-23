package com.IngBanking.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String description;
	private double amount;
	private String fromAccount;
	private String toAccount;

}
