package com.IngBanking.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Transaction")
@Getter
@Setter
@NoArgsConstructor 
@ToString
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId ;
	private String fromAccount;
	private String toAccount;
	private String description;
	private double amount;
	private Date transactionDate;
	private String transactionStatus;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
	private Account account;
	
	
	
	

	

}
