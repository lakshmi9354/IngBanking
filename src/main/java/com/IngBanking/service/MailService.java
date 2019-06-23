package com.IngBanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(String email, String userName, String accountNumber, String password, Long userId)
			throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Login Details for Your Account");
		mail.setText("Email for Account is" + email);
		mail.setText("UserName for Login is" + userName);
		mail.setText("AccountNumber for Login is" + accountNumber);
		mail.setText("Password for Login is" + password);
		mail.setText("UserId for Login is" + userId);

		javaMailSender.send(mail);
	}

}