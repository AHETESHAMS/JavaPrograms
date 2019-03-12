package com.bridgelabz.spring.Spring;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle 
{
	public void drive()
	{
		System.out.println("o gaddi chaal rahi si!");
	}
}
