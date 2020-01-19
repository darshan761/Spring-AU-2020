import java.util.*;
import java.util.Scanner;

public class Home {
	public static void clearScreen() {  
		System.out.print("\033[H\033[2J");
		System.out.flush();  
	   }
	public static void main(String [] args) {
		
		HashMap<Integer,Product> products = new HashMap<Integer,Product>();
		HashMap<Integer,Order> orders = new HashMap<Integer,Order>();
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		int sum = 0; //  for maintaining total bill
		int count = 0; // for increment of orders
		int wallet = 2000; // wallet amount
		boolean flag = true;
		
		Cart c = new Cart(); // for temporary storing cart items
		
		// Initializing products
		Product p1 = new Product(1,20,"Mac Pro",1000);
		Product p2 = new Product(2,10,"Mac Air",850);
		Product p3 = new Product(3,100,"HP",700);
		Product p4 = new Product(4,200,"Dell",600);
		Product p5 = new Product(5,150,"Asus",500);
		Product p6 = new Product(6,250,"Lenovo",750);
		Product p7 = new Product(7,210,"MSI",800);
		
		products.put(1,p1);
		products.put(2,p2);
		products.put(3,p3);
		products.put(4,p4);
		products.put(5,p5);
		products.put(6,p6);
		products.put(7,p7);
		
		do {
		
			System.out.println("\n================== WELCOME TO AMAZON!=====================\n");
			System.out.println("1.ADD PRODUCT\n2.REMOVE PRODUCT\n3.VIEW CART\n4.PLACE ORDER\n5.CANCEL ORDER\n6.EXIT");
			System.out.println("\nYour wallet Amount:"+wallet+"\n");
			
			System.out.println("Enter your choice:");
			
			// to catch number format exception
			try {
			choice = Integer.parseInt(sc.next());
			
			switch(choice) {
			
				case 1: 
						// display products 
						for(Product p:products.values()) System.out.println(p.toString());
						
						System.out.println("\nEnter Product ID:");
						
						int choice1 = 0;
						
						// to catch number format exception
						try {
							 choice1 = Integer.parseInt(sc.next());
						}
						catch(NumberFormatException e) {
							System.out.println("ERROR: Input proper numeric value");
						}
						
						
						// check whether selected id is in the products
						if(products.containsKey(choice1)) {
							
							// adds selected product to cart
							c.Cart_Products.add(products.get(choice1));
							
							// set cart total
							c.cart_total+= products.get(choice1).rate;
							
							// reduces product qty
							products.get(choice1).qty--;
							
							System.out.println("\nAdded Successfully!");
							
							// display cart total
							System.out.println("\nCart Total:"+c.getCart_total());
						}
						else {
							
							System.out.println("Product id not existing");
							
						}
						
						break;
						
					
				case 2: 
						// check whether cart is empty
						if(c.Cart_Products.isEmpty()) 
							System.out.println("\nYour Cart is Empty!");
						
						else {
							
							// display cart products
							for(Product p: c.Cart_Products) System.out.println(p.toString());
							
							System.out.println("\nEnter product id to remove:");
							
							int choice2 = 0;
							
							// to catch number format exception
							try {
								 choice2 = Integer.parseInt(sc.next());
							}
							catch(NumberFormatException e) {
								System.out.println("ERROR: Input proper numeric value");
							}
							
							// checks selected product in cart products
							for(Product p:c.Cart_Products) {
								
								if(p.product_id==choice2) { 
									
									c.cart_total -= p.rate;
									
									products.get(choice2).qty++;
									
									c.Cart_Products.remove(p);
									
									System.out.println("\nRemoved Successfully!");
									
									System.out.println("\nCart Total:"+c.getCart_total());
									
									break;
								}
							}
							
							}
						break;
					
				case 3: 
						// checks whether cart is empty
						if(c.Cart_Products.isEmpty()) System.out.println("\nYour Cart is Empty");
						
						else {
							
							System.out.println("\nYour Cart:");
							// display cart items
							for(Product p: c.Cart_Products) System.out.println(p.toString());
							
							System.out.println("\nCart Total:"+c.getCart_total());
							
						}
						break;
						
				case 4: 
						// checks whether cart is empty
						if(c.Cart_Products.isEmpty()) System.out.println("\nYour Cart is Empty");
						
						else {
							
							System.out.println("\nEnter your Name");
							String name = sc.next();
							
							if (c.cart_total < wallet) {
								// create new order
								Order o = new Order();
								o.setUsername(name);
								o.order_id = ++count;
								
								// adds cart products to order products
								o.Products.addAll(c.Cart_Products);
								
								o.total_bill = c.cart_total;
								
								orders.put(o.order_id,o);
								
								// set cart total = 0 for new cart
								c.cart_total = 0;
								
								// removes entries from cart once order placed
								c.Cart_Products.clear();
								
								System.out.println("\nOrder Placed Successfully!");
								
								sum = 0;
								// calculates total bill of all orders
								for(Order y:orders.values()) 
									sum+= y.total_bill;
								
								System.out.println("\nTotal Amount to pay:"+sum);
								wallet-=sum;
								System.out.println("\nWallet Balance:"+wallet);
							}
							else {
								System.out.println("\nYou Don't have enough money in wallet:"+wallet);
							}
							
						}
						break;
						
				case 5: 
						// check if order is empty
						if(orders.isEmpty()) System.out.println("\nNo orders yet! :(");
						
						else {
							// display all orders
							for(Order i: orders.values())  System.out.println(i.toString());
							
							System.out.println("\nTotal Amount to pay:"+sum);
							
							System.out.println("\nEnter order id to remove:");
							
							int choice3 = 0;
							
							// to catch number format exception
							try {
								 choice3 = Integer.parseInt(sc.next());
							}
							catch(NumberFormatException e) {
								System.out.println("ERROR: Input proper numeric value");
							}
							
							// checks if selected order id is present in the orders
							if(orders.containsKey(choice3)) {
								
								sum -= orders.get(choice3).total_bill;
								wallet += orders.get(choice3).total_bill;
								orders.remove(choice3);
								
								System.out.println("\nOrder removed Successfully!");
								
								System.out.println("\nWallet Balance:"+wallet);
							}
							
							else {System.out.println("order id not existing");}
							
						}
						break;
					
				case 6: 
						System.out.println("\nExiting......");
						System.out.println("Thanks for shopping with us!");
						break;
										
				default: System.out.println("Please Select Appropriate options");
				
				}
			
			}catch(NumberFormatException e) {
				
				System.out.println("ERROR: Input proper numeric value");
				continue;
				
			}

		System.out.println("==========================================================");
		
		}while(choice!=6);
	}

}
