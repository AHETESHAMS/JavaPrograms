package com.bridegelabz.fundoo.util;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridegelabz.fundoo.user.model.Email;

public class GenerateMail 
{
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	private String exchange = "exchange";
	private String routingkey = "Jerry";
	
	public void send(Email email) 
	{
		rabbitTemplate.convertAndSend(exchange , routingkey , email);
	}
}	
