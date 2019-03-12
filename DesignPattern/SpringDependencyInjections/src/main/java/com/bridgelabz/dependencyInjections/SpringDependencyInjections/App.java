package com.bridgelabz.dependencyInjections.SpringDependencyInjections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {  
        
//        ClassPathResource r=new ClassPathResource("applicationContext.xml");  
//     BeanFactory factory=new XmlBeanFactory(r);  
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Employee s=(Employee)context.getBean("e");  
        s.show();  
          
    }  
}
