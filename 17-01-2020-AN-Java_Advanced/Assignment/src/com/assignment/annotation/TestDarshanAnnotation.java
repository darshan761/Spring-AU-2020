package com.assignment.annotation;

import java.lang.reflect.Method;

import com.assignment.annotation.Demo;
import com.assignment.annotation.AnotherDemo;
import com.assignment.annotation.DarshanAnnotation;

public class TestDarshanAnnotation {
	
	public static void main(String args[]) throws Exception{  
		
	// checks default value of method DarshanAnnotation  
	Demo d1 = new Demo();  
	Method m = d1.getClass().getMethod("sayMyName");  
	DarshanAnnotation darsh = m.getAnnotation(DarshanAnnotation.class);
	System.out.println("Name in method: "+darsh.name()+"\nCity in method: "+ darsh.city()+"\n");  
	 
	// checks instantiated value of method DarshanAnnotation
	AnotherDemo d2= new AnotherDemo();
	Method m2 = d2.getClass().getMethod("sayMyName");  
	DarshanAnnotation darsh1=m2.getAnnotation(DarshanAnnotation.class);  
	System.out.println("Name in method: "+darsh1.name()+"\nCity in method: "+ darsh1.city()+"\n"); 
	
	// checks instantiated value of class annotation
	OneMoreDemo omd = new OneMoreDemo();
	DarshanClassAnnotation darsh2 = omd.getClass().getAnnotation(DarshanClassAnnotation.class);
	System.out.println("Name in Class: "+darsh2.name()+"\ncity in class: "+darsh2.city()+"\n");
	
	}

}
