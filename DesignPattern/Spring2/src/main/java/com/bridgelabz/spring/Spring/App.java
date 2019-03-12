package com.bridgelabz.spring.Spring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *Spring  Annotation Demo
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
       Vehicle obj1 = (Car) context.getBean("car");
       obj1.drive();
       	 
    }
}
