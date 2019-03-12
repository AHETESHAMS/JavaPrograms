package com.bridgelabz.SpringAnnotation.SpringAnnotation;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle
{
	public void drive()
	{
		System.out.println("oye Car chaal rahi si...?");
	}

}
