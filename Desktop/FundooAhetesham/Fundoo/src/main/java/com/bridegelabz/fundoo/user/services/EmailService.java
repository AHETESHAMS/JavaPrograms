package com.bridegelabz.fundoo.user.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bridegelabz.fundoo.util.UserToken;

@Service
public class EmailService 
{
	@Autowired
	JavaMailSender emailSender;
	public EmailService() 
	{
		
	}
	public void sendMail(String to, String subject, String url) 
	{
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(url);
		emailSender.send(simpleMailMessage);
	}
	
}
