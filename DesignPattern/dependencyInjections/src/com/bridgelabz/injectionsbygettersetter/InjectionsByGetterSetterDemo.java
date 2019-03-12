package com.bridgelabz.injectionsbygettersetter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;    
public class InjectionsByGetterSetterDemo 
{  
    public static void main(String[] args) 
    {  
          
        ApplicationContext context = new ClassPathXmlApplicationContext("injectionsByGetterSetter.xml"); 
        Employee e=(Employee)context.getBean("obj");  
        e.display();  
          
    }  
}  