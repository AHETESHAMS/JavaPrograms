package com.bridgelabz.SpringAnnotation.SpringAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Using annotation
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringAnnotation.xml");
    	Vehicle obj = (Vehicle) context.getBean("car");
    	obj.drive();
    }
}
