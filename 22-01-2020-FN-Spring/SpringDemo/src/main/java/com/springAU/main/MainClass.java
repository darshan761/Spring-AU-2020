package com.springAU.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springAU.config.AppConfig;
import com.springAU.model.Employee;
import com.springAU.service.EmployeeService;
import com.springAU.service.PointService;

@ComponentScan(basePackages = "com.springAU.")
public class MainClass {
	
	public static void main(String[] args) throws Exception {

		// creating context for injecting from spring.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		// creating context for injecting from AppConfig.class
		ApplicationContext anotherContext = new  AnnotationConfigApplicationContext(AppConfig.class);
		
		// get bean employeeServiceList from spring.xml
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		System.out.println("\n1. Using AOP to get total time for getAllEmployees()");
		System.out.println(employeeService.getAllEmployees()+"\n");
		


		// using HashMap from XML for injection
		// get bean mapEmployee from spring.xml
		Employee employee = (Employee) context.getBean("mapEmployee");
		
		System.out.println("2. Using HashMap to inject from XML");
		System.out.println("\n"+employee.employeeMap+"\n");
		
		
		
		// get pointService from AppConfig.class
		PointService pointService = anotherContext.getBean(PointService.class);
		System.out.println("\n3. Reading values from application.properties file");
		System.out.println("\n"+pointService.getPoint());
		
		// closing the application context
		((ConfigurableApplicationContext)context).close();
		((ConfigurableApplicationContext)anotherContext).close();

		
	}
}
