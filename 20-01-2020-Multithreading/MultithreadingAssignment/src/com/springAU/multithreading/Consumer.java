package com.springAU.multithreading;

import java.util.Random;

public class Consumer implements Runnable {

	@Override
	public void run(){

		while(true) {
			
			synchronized (Market.Basket) {
				
				Random rand = new Random();
				
		        // generate fruit qty from 1 to 3 
		        int fruit_qty = rand.nextInt(5) + 1;
		        
		        // generate random fruit from fruit array
		        int fruit_no = rand.nextInt(4);
		        String desiredFruit = Market.Fruits.get(fruit_no);

		        System.out.println(Thread.currentThread().getName() +" wants "+fruit_qty+" "+desiredFruit);
		        
		        // if desired fruit is not available in the basket
				if(Market.Basket.get(desiredFruit)==0) {
					
					System.out.println(desiredFruit+" is not Available");
					
					System.out.println(Market.Basket);
					System.out.println("=======================================================");
					
					try {
						
						Market.Basket.wait(); // wait for other thread to notify
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else {
				
					System.out.println(desiredFruit+" is Available");
					int available = Market.Basket.get(desiredFruit);
					int val = 0;
					
					// calculates remaining fruit count in the basket after consumption
					if(fruit_qty > available)
						val = fruit_qty-available;
					
					else 
						val = available-fruit_qty;
					
					// puts calculated value for the fruit
					Market.Basket.put(desiredFruit, val);
					
					Market.Basket.notifyAll(); // notify all the thread that its execution is done
					
					System.out.println(Thread.currentThread().getName()+" consumes "+fruit_qty+" "+desiredFruit+" ");
					System.out.println(Market.Basket);
					System.out.println("=======================================================");
					
					try {
						Thread.sleep(3000); // after consumption goes to sleep for 3 sec
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				

			}
		}
	 
	}
		
	}
	
	
		
		


