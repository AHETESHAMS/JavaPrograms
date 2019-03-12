package com.bridgelabz.injectionsbyconstructor;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class InjectionsByConstructorDemo 
{
	public static void main(String[] args) 
	{  
        
		ApplicationContext context = new ClassPathXmlApplicationContext("injectionsByConstructor.xml");
	 	Employee s=(Employee)context.getBean("e");  
        s.show();  
	}
}	
