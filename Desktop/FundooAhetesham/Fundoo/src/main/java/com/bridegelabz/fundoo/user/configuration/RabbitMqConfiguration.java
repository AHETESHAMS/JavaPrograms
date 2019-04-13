package com.bridegelabz.fundoo.user.configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration 
{
	private String queueName = "queue";
	private String exchange = "exchange";
	private String routingkey = "Jerry";
	
	@Bean
	Queue queue()
	{
		return new Queue(queueName);
	}
	@Bean
	DirectExchange exchange() 
	{
		return new DirectExchange(exchange);
	}

	
	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind((org.springframework.amqp.core.Queue) queue).to(exchange).with(routingkey);
	}

	@Bean
	public Jackson2JsonMessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
}
}
