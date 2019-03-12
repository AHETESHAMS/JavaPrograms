package com.bridgelabz.SpringAnnotation.SpringAnnotation;

import org.springframework.stereotype.Component;

@Component
public class Bike  implements Vehicle
{
	public void drive() 
	{
		System.out.println("Oye bike chaal raahi si..?");
	}
	
}
