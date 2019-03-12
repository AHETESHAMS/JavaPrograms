package com.bridgelabz.dependencyinjections.constructor;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.core.io.*;  
public class ConstructorExample 
{
	 public static void main(String[] args) {  
         
	        Resource r=new ClassPathResource("applicationContext.xml");  
	        BeanFactory factory=new XmlBeanFactory(r);  
	          
	        Employee s=(Employee)factory.getBean("e");  
	        s.show();  
	          
	    }  
}
