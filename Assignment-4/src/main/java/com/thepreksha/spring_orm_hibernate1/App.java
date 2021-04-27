package com.thepreksha.spring_orm_hibernate1;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thepreksha.spring_orm_hibernate1.dao.EmployeeDao;
import com.thepreksha.spring_orm_hibernate1.entities.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeDao dao = context.getBean("employeedao",EmployeeDao.class);
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome");
        boolean flag = true;
        while(flag) {
        	System.out.println("Press 1:Add Employee");
        	System.out.println("Press 2:get All Employees");
        	System.out.println("Press 3:get Employee By Id");
        	System.out.println("Press 4:Delete Employee");
        	System.out.println("Press 5:Add Employee");
        	System.out.println("Press 6:Exit\n");
        	try {
        		int input=s.nextInt();
        		switch(input) {
        		case 1:
        			System.out.println("Enter EmpId");;
        			int id = s.nextInt();
        			System.out.println("Enter Employee Name");
        			String name=s.next();
        			System.out.println("Enter Employee Name");
        			String email=s.next();
        			Employee employee = new Employee();
        			employee.setId(id);
        			employee.setName(name);
        	        employee.setEmail(email);
        			
        		}
        	}
        }
        
        
    }
}
