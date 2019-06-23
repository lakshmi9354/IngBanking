package com.IngBanking.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IngBanking.dto.TransactionDTO;
import com.IngBanking.dto.TransactionDetailsDTO;
import com.IngBanking.entity.Account;
import com.IngBanking.entity.Transaction;
import com.IngBanking.repository.AccountRepository;
import com.IngBanking.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

	@Autowired 
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);
	
	@Override
	public TransactionDetailsDTO fundTransfer(TransactionDTO transactionDTO) {

		TransactionDetailsDTO transactionDetailsDTO=new TransactionDetailsDTO();
		
		Transaction transactionDebit=new Transaction();
		Account accountdebit=new Account();
		Account accountcredit=new Account();
		LOGGER.debug("TransactionServiceImpl fundTransfer()");
		System.out.println("--bal----");
		System.out.println(transactionDTO.getFromAccount());
		Account accountfrom=accountRepository.findByAccountNumber(transactionDTO.getFromAccount());
		
		
		System.out.println(accountfrom.getBalance());
		System.out.println(transactionDTO.getAmount());
		

		double balDeducted=accountfrom.getBalance()-transactionDTO.getAmount();
		Account accountTo=accountRepository.findByAccountNumber(transactionDTO.getToAccount());
		double balAdded=accountTo.getBalance()+transactionDTO.getAmount();
		
		transactionDebit.setAccount(accountfrom);
		transactionDebit.setAmount(transactionDTO.getAmount());
		transactionDebit.setDescription(transactionDTO.getDescription());
		transactionDebit.setFromAccount(accountfrom.getAccountNumber());
		transactionDebit.setToAccount(accountTo.getAccountNumber());
		transactionDebit.setTransactionStatus("Fund debit");
		transactionDebit.setUser(accountfrom.getUser());
		
		accountdebit.setAccountId(accountfrom.getAccountId());
		accountdebit.setAccountNumber(accountfrom.getAccountNumber());
		accountdebit.setAccountType(accountfrom.getAccountType());
		accountdebit.setAddress(accountfrom.getAddress());
		accountdebit.setAge(accountfrom.getAge());
		accountdebit.setBalance(balDeducted);
		accountdebit.setEmail(accountfrom.getEmail());
		accountdebit.setFirstName(accountfrom.getFirstName());
		accountdebit.setLastName(accountfrom.getLastName());
		accountdebit.setPAN(accountfrom.getPAN());
		accountdebit.setPhNum(accountfrom.getPhNum());
		accountdebit.setPurpose(accountfrom.getPurpose());
		accountdebit.setStatus(accountfrom.getStatus());
//		List<Transaction> transactionDebitList=new ArrayList<>();
//		transactionDebitList.add(transactionDebit);
//		accountdebit.setTransaction(transactionDebitList);
		System.out.println("debit save--");
		transactionRepository.save(transactionDebit);
//		Transaction enqiry=transactionRepository.findByFromAccount(transactionDebit.getFromAccount());
//		transactionDebit.setTransactionId(enqiry.getTransactionId());
		accountRepository.save(accountdebit);
		
		Transaction transactionCredit=new Transaction();
		transactionCredit.setAccount(accountTo);
		transactionCredit.setAmount(transactionDTO.getAmount());
		transactionCredit.setDescription(transactionDTO.getDescription());
		transactionCredit.setFromAccount(accountTo.getAccountNumber());
		transactionCredit.setToAccount(accountTo.getAccountNumber());
		transactionCredit.setTransactionStatus("Funds credit");
		transactionCredit.setUser(accountTo.getUser());
//		transactionRepository.save(transactionCredit);
		
		accountcredit.setAccountId(accountTo.getAccountId());
		accountcredit.setAccountNumber(accountTo.getAccountNumber());
		accountcredit.setAccountType(accountTo.getAccountType());
		accountcredit.setAddress(accountTo.getAddress());
		accountcredit.setAge(accountTo.getAge());
		accountcredit.setBalance(balAdded);
		accountcredit.setEmail(accountTo.getEmail());
		accountcredit.setFirstName(accountTo.getFirstName());
		accountcredit.setLastName(accountTo.getLastName());
		accountcredit.setPAN(accountTo.getPAN());
		accountcredit.setPhNum(accountTo.getPhNum());
		accountcredit.setPurpose(accountTo.getPurpose());
		accountcredit.setStatus(accountTo.getStatus());
//		List<Transaction> transactionDbit=new ArrayList<>();
//		transactionDbit.add(transactionCredit);
//		accountdebit.setTransaction(transactionDbit);
		
		System.out.println("---credit");
		transactionRepository.save(transactionCredit);
		
		Transaction transactionFrom=transactionRepository.findByFromAccount(accountfrom.getAccountNumber());

//		Transaction enqirycre=transactionRepository.findByFromAccount(transactionCredit.getToAccount());
//		transactionCredit.setTransactionId(enqirycre.getTransactionId());
		accountRepository.save(accountcredit);
		
		transactionDetailsDTO.setFromAccount(accountfrom.getAccountNumber());
		transactionDetailsDTO.setToAccount(accountTo.getAccountNumber());
		transactionDetailsDTO.setTransactionDate(transactionFrom.getTransactionDate());
		transactionDetailsDTO.setTransactionStatus(transactionFrom.getTransactionStatus());
		
		return transactionDetailsDTO;
	}

}

//{transactionDate:Date,transactionStatus:String,fromAccount:String,toAccount:String}