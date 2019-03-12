package com.bridgelabz.spring.Spring;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle
{
	public void drive()
	{
		System.out.println("O bike chaal rahi si..");
	}
}
