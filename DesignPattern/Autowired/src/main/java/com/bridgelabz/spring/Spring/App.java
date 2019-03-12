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
//       Vehicle obj1 = (Vehicle) context.getBean("car");
//       obj1.drive();
       	 Tyre t = (Tyre) context.getBean("studentbean");
       	 System.out.println(t);
    }
}
