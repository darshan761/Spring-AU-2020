package com.assignment.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.assignment.annotation.DarshanAnnotation;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD ) 
public @interface DarshanAnnotation {
	String name() default "default name";
	String city() default "default city"; 

}

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.TYPE ) 
@interface DarshanClassAnnotation {
	String name() default "default name";
	String city() default "default city"; 
}

class Demo{  
	@DarshanAnnotation(name="Darshan", city = "Bengaluru")  
	public void sayMyName(){System.out.println("hello annotation");}  
}


class AnotherDemo{  
	@DarshanAnnotation
	public void sayMyName(){System.out.println("Default hello annotation");}  
} 

@DarshanClassAnnotation(name="Darshan Patil", city="Kolkata")
class OneMoreDemo {
	void show() {
		System.out.println("Printed from class annotation!");
	}
}





