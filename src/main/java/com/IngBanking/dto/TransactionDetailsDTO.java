package com.IngBanking.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class TransactionDetailsDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Date transactionDate;
	private String transactionStatus;
	private String fromAccount;
	private String toAccount;

}


//{transactionDate:Date,transactionStatus:String,fromAccount:String,toAccount:String}