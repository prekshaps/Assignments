package com.thepreksha.spring_training;


import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
        
        AbstractApplicationContext context =  new ClassPathXmlApplicationContext("config.xml");
         context.registerShutdownHook();
         //Employee employee = (Employee)context.getBean("employee1");
         //System.out.println(employee);
        
         
         Student student = (Student)context.getBean("student1");
         System.out.println(student);
        
         
         
         
         
        
    }
}
