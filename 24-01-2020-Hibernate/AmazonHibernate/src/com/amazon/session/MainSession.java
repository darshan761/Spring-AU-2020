package com.amazon.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.amazon.model.Address;
import com.amazon.model.Buyer;
import com.amazon.model.Order;
import com.amazon.model.Payment;
import com.amazon.model.Product;
import com.amazon.model.Seller;

public class MainSession {
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+     Welcome to Amazon     +");
		System.out.println("+++++++++++++++++++++++++++++");
		
		System.out.println("NOTE: Use _ for space");
		System.out.println("Enter your personal Details:");
		
		System.out.println("Enter your Name:");
		String name = sc.next();
		
		System.out.println("Enter your Email:");
		String email = sc.next();
		
		System.out.println("Enter your Mobile:");
		String number = sc.next();
		
		System.out.println("Enter your Home Address streetname:");
		String haddstreet = sc.next();
		
		System.out.println("Enter your Home Address pincode:");
		int haddpin = sc.nextInt();
		
		System.out.println("Enter your Office Address street name:");
		String oaddstreet = sc.next();
		
		System.out.println("Enter your Home Address pincode:");
		int oaddpin = sc.nextInt();
		
		int choice = 0;
		
		Address home = new Address(haddpin, haddstreet);
		Address office = new Address(oaddpin, oaddstreet);
		
		
		while(choice!=3) {
			
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");	
		System.out.println("Please first add products using seller to view it in Buyer");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Who are you?\t 1.Seller\t 2.Buyer\t 3.Exit");
		
		choice = sc.nextInt();
				
		// seller
		if(choice==1) {
			
			Seller seller = new Seller(name, number, email, home, office);
			
			int choice1 = 0;
			int sellerId = 0;
			
			 while(choice1!=3) {
				 
				 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				 System.out.println("1.Add Product \n2.View Product \n3.Exit");
				 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				 choice1 = sc.nextInt();
				 
				switch(choice1) {
				
				// for adding product 
				case 1:
					
					System.out.println("Enter product name:");
					String pName = sc.next();
					System.out.println("Enter product description:");
					String pDescription = sc.next();
					System.out.println("Enter product price:");
					int price = sc.nextInt();
					
					Product product = new Product(pName,price,pDescription);
					
					product.setSeller(seller); // set seller for product 
					
					session.save(product); 
					
					seller.getProductList().add(product); // add product to seller
					
					sellerId = (Integer)session.save(seller); // to check whether product is added or not
					
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					System.out.println("            Product added successfully!");
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					
					session.getTransaction().commit();
					session.beginTransaction();
	
					break;
					
				// for viewing added product for seller	
				case 2:
						if(sellerId==0) System.out.println("NO product added!"); // product is not added 
						
						else {
							
							Seller seller1 = session.get(Seller.class, sellerId);
							
							for(Product p:seller1.getProductList())  // displays all products of the seller
								System.out.println(p.toString());
						}
						
						break;
						
				case 3: 
						
						System.out.println("Exit Successfully!");
						break;
						
				default: System.out.println("Invalid option");
				
				}
			}
					
			}	
			// if user is buyer	
			else if(choice==2) {
				
				Buyer buyer = new Buyer(name, number, email, home, office);
				
				int choice3=0;
				
				// transient array for storing added items
				List<Product> selected = new ArrayList<>();
				
				int pid = 0;
				boolean added = false;
				
				while(choice3!=4){
					
					// buyer menu
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					System.out.println("1. View Products \n2. View Added product \n3. confirmed orders \n4. Exit");
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					choice3 = sc.nextInt();
					
				switch(choice3) {
				
				// view products
				case 1: 
					
					List<Product> products = session.createQuery("from Product", Product.class).list(); // get all product using query
					
					for(Product p:products) 
						System.out.println(p.toString()); // display products
					
						System.out.println("1.Add product to your order\t2.Back");
					    int choice6 = sc.nextInt();
						
					    switch(choice6) {
					    
					    // add product
					    case 1:
					    	System.out.println("Enter Product id to add:");
					    	pid = sc.nextInt();
					    	
					    	// add selected product to transient array
					    	selected.addAll(session.createQuery("from Product where productid = "+pid , Product.class).list());
							
					    	// for checking whether product is added or not
					    	added= true;

							System.out.println("Product added Successfully!");
							
					    	break;
					    	
					    case 2: 
					    	System.out.println("going back.....");
					    	break;
					    	
					    default: System.out.println("Enter Proper option");
					    
					    }
						break;
				// view added products		
				case 2:
					
					int total = 0;
					
					if(!added) {
						System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						System.out.println("               NO product Added");
//						System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					}
					
					else {
						for(Product p:selected ) { // display products from transient array
							
							System.out.println(p.toString());
							total+=p.getPrice();
							
						}
						System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						System.out.println("1.Confirm Order  2.Back");
						System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						int choice4 = sc.nextInt();
						
						int orderid = 0;
						
						// confirm order
						if(choice4 == 1) {
						
								Order order = new Order();
								
								Payment payment = new Payment(); 
								
								System.out.println("Enter payment mode");
								
								String pay = sc.next();
								
								payment.setPayment_mode(pay);
								
							    payment.setPayment_amt(total);
							    
							    Date bookedDate = new Date();
							    payment.setPayment_date(bookedDate);
							    
							    order.setPayment(payment);
							    order.setBuyer(buyer);
							    order.setProductList(selected); 
							    
							    session.save(payment); // save payment
							    
							    orderid = (Integer)session.save(order); // save order
							    
							    session.save(buyer);
							    
							    System.out.println(order.toString());
							    
							    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
							    System.out.println("           Order placed Successfully!");
//							    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
							    
							    session.getTransaction().commit();
								session.beginTransaction();
							    selected.clear(); // empty cart - transient array emptied
								added = false;
							}
							else if(choice4==2) System.out.println("going back....");
						
							else System.out.println("Select valid option");
						
							}
					
							break;
							
				// display confirmed order		
				case 3:
						Query query = session.getNamedQuery("GET_ALL_ORDERS"); // using named query for getting all orders
						List<Order> orders = query.list();
						
						if(orders.isEmpty()) System.out.println("No orders yet!"); // if no order present
						
						else {
							for(Order o: orders) 
								System.out.println(o.toString()); // display orders
							
							System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
							System.out.println("1.DELETE  \n2.BACK");
							System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
							
							int choice5 = sc.nextInt();
							
							switch(choice5) {
							
							// delete order
							case 1:
								System.out.println("enter order id to DELETE");
								int delete = sc.nextInt();
								
								Order ord = (Order)session.load(Order.class, delete); // get order which needs to be deleted
								session.delete(ord); // deletes order
								
								System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
								System.out.println("Order deleted successfully!");
								
								session.getTransaction().commit();
								session.beginTransaction();
								break;
								
							case 2:
								
								System.out.println("going back.....");
//								break;
								
							default: System.out.println("Invalid option");
							}
						}
							break;
				
				// Exit
				case 4:
						System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						System.out.println("                   Exit Successfully!");
						break;
						
				default:
					System.out.println("Invalid option");
				
			}
		}
			
		}
			
		else if (choice==3) System.out.println("+++++++++++++++Thanks for shopping with us!+++++++++++++++");
		else System.out.println("Enter Correct option");
		
		}
	}

}
