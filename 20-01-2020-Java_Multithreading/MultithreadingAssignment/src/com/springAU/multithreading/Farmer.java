package com.springAU.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Farmer implements Runnable {

	@Override
	public void run() {
		while(true) {
			
			
			synchronized(Market.Basket) {
				
				System.out.println("Basket Limit: "+Market.BASKET_LIMIT + " Total fruit count: "+getTotal(Market.Basket));
				
				// checks the Maximum basket size criteria
				if(getTotal(Market.Basket) > Market.BASKET_LIMIT) {
					
					System.out.println("Basket is Full. Cannot produce");
					
					try {
						
						Market.Basket.wait(); // wait for other thread to notify
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(Market.Basket);
					System.out.println("=======================================================");
				}
				
				else {
					
					Random rand = new Random(); 
			        // Generate random fruit qty from 1 to 15 
			        int fruit_qty = rand.nextInt(15) + 1;
			        
			        // Generate random fruit from the available fruit array
			        int fruit_no = rand.nextInt(4);
			        String newfruit = Market.Fruits.get(fruit_no);
			        
			        // gets available count of selected fruit in basket
			        int available  = Market.Basket.get(newfruit);
			        
			        System.out.println(Thread.currentThread().getName()+" wants to put "+fruit_qty+ " " +newfruit );
			        
			        // checks if addition of fruits will violate the max basket size criteria
			        if(fruit_qty+getTotal(Market.Basket) > 50) {
			        	
			        	System.out.println("Basket limit will be violated if this fruit ("+fruit_qty+") is added");
			        	
			        	try {
			        		
							Market.Basket.wait(); // wait for other thread to notify
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			        else {
			        	
			        	// puts new fruit in the basket
			        	Market.Basket.put(newfruit ,available+fruit_qty);
			        	
				        System.out.println(Thread.currentThread().getName()+" puts "+fruit_qty+ " " +newfruit );
				        
				        Market.Basket.notifyAll(); // notifies other thread that its execution is done
				        
						System.out.println(Market.Basket);
				        System.out.println("=======================================================");
				        
				        try {
				        	
							Thread.sleep(3000); // after production goes to sleep for 3 sec
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }  
					
				}

			}
		}
		
	}
	
	public int getTotal(HashMap<String,Integer> fruits) {
		
		int total = 0;
		for (Map.Entry mapElement : fruits.entrySet()) 
            total+=(int)mapElement.getValue(); 
	
		return total;
	}

}
