package com.springAU.aspect;

import java.time.Duration;
import java.time.LocalTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {
	
	// for storing start and end time
	LocalTime start ;
    LocalTime end ;
    Duration duration; 
    
    // Before advice on getAllEmployee
	@Before("execution(* com.springAU.service.EmployeeService.getAllEmployees(..))")
	public void logBeforeget(JoinPoint joinPoint){
		start = LocalTime.now();
		System.out.println("\nEmployeeAspect.logBefore()   started at: "+LocalTime.now()+ "   "+joinPoint.getSignature().getName()+"()");
	}
	
	// After advice on getAllEmployee to calculate time taken
	@After("execution(* com.springAU.service.EmployeeService.getAllEmployees(..))")
	public void logAfterget(JoinPoint joinPoint){
		end = LocalTime.now();
		System.out.println("EmployeeAspect.logAfter()    ended at: "+LocalTime.now()+ "   "+joinPoint.getSignature().getName()+"()");
		duration = Duration.between(start, end);
		System.out.println("\nTime taken by the method is " +duration.toMillis() +" milliseconds");
	}
}
