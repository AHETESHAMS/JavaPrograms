package com.bridgelabz.SpringAnnotation.AnnotationSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgelabz.SpringAnnotation.AnnotationSpring.Vehicle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 ApplicationContext context = new ClassPathXmlApplicationContext("AnnotationSpring.xml");
         Vehicle obj1 = (Vehicle) context.getBean("vehicle");
         obj1.drive();
    }
}
