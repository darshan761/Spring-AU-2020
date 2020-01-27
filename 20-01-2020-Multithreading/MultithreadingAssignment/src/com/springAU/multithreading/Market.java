package com.springAU.multithreading;

import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class Market {
	
	// to store fruits with their count
	static HashMap<String, Integer> Basket = new HashMap<>() {
		{
			put("Apple",0);
			put("Watermelon",0);
			put("Grape",0);
			put("Orange",0);
		}
	};
	
	// maximum limit of fruit in the basket
	static final int BASKET_LIMIT = 50;
	
	// fruits available
	static List<String> Fruits = new ArrayList<>() { 
        { 
            add("Apple"); 
            add("Watermelon"); 
            add("Grape");
            add("Orange");
        } 
    }; 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of farmer:");
		int fnum = sc.nextInt();
		System.out.println("Enter Number of Consumer:");
		int cnum = sc.nextInt();
		
		// to check number of farmer/consumer 
		if(fnum==0 || cnum==0) System.out.println("Number of Farmer/Consumer cannot be Zero");
		
		else {
			
			System.out.println("===============Welcome to Fruit Bazaaar================");
			
			// creates farmer threads
			for(int i=0;i<fnum;i++) {
				
				 Thread farmers = new Thread(new Farmer(), "farmer "+(i+1));
				 farmers.start();
			}
			
			// creates comsumer threads
			for(int i=0;i<cnum;i++) {
				 
				 Thread consumers = new Thread(new Consumer(), "Consumer "+(i+1));
				 consumers.start();
			}
		}		
				
	}

}
