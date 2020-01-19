package com.assignment.triconsumer;

import java.util.Arrays;
import java.util.List; 
import java.util.function.BiConsumer; 
 import com.assignment.triconsumer.*;

 
public class triconsumerExample { 
	
	// Wrapper class for lambda function exception handling
	static <T, U, V,  E extends Exception> TriConsumer<T, U, V> triConsumerWrapper(TriConsumer<T, U, V> triConsumer, Class<E> exceptionClass) {
		return (t, u, v) -> {
			try {
				triConsumer.apply(t, u, v);
			} catch (Exception e) {
				try {
	                E exception = exceptionClass.cast(e);
	                System.err.println("Exception: " + exception.getMessage());
	                System.out.println();
	            } catch (ClassCastException exc) {
	                throw new RuntimeException(exc);
	            }
			}
		};
	}
	
    public static void main(String args[]) 
    { 
    	// using Triconsumer to find multiplication of 3 integers
    	TriConsumer<Integer, Integer, Integer> volume = (x,y,z) -> System.out.println(x*y*z);
    			
    		volume.apply(2,4,5);
    	
    	// using Triconsumer to sort Strings lexicographically
    	TriConsumer<String, String, String> sort = (a,b,c) -> {
    		String[] array = new String[] {a, b, c};
    	    Arrays.sort(array);
    	    System.out.println(array[0]+" "+array[1]+" "+array[2]);
    	};
    	
    	sort.apply("Rohit", "Rohan", "Darshan");
    	
    	 	
    	// Exception handling using lambda wrapper triConsumerWrapper
    	TriConsumer<Integer, Integer, Integer> exp = triConsumerWrapper((a,b,c) -> {
    		System.out.println(a/c);
    		System.out.println(a/b);
		}, ArithmeticException.class);
		
    	// throws DivideByZero Exception
		exp.apply(7, 3, 0);
    		
    } 
}
