package com.assignment.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class dob {
	
	// method to find difference in days and time i nanoseconds
	public static void getDifference(String self, String sibling){
		try {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			
			LocalDate first = LocalDate.parse(self,formatter);
		    LocalDate second = LocalDate.parse(sibling,formatter);
		    
		    LocalDateTime localDateTime1 = first.atStartOfDay();	    
		    LocalDateTime localDateTime2 = second.atStartOfDay();
		 
		    long period = ChronoUnit.DAYS.between(first, second);
		    
		    long diff = ChronoUnit.NANOS.between(localDateTime1, localDateTime2);
		    
		    System.out.println("Difference in days is:"+period);
		    
		    System.out.println("Difference in nanoseconds is:"+diff);
		}
		
		catch(Exception e) {
			System.out.println("ERROR: Enter date in given format");
		}

	}
	
	// method to find difference in days in different time zone
	public static void getDifferentTimeZone(String self, String sibling, String Zone) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			
			LocalDate first = LocalDate.parse(self,formatter);
		    LocalDate second = LocalDate.parse(sibling,formatter);
		    
		    LocalDateTime localDateTime1 = first.atStartOfDay();	    
		    LocalDateTime localDateTime2 = second.atStartOfDay();
		    
		    ZonedDateTime two = localDateTime2.atZone(ZoneId.of(Zone));
		    
		    long period = ChronoUnit.DAYS.between(localDateTime1, two);
		    
		    System.out.println("Difference in days is:"+period);
		    
		}
		catch(Exception e) {
			System.out.println("ERROR: Enter appropriate time zone");
		}
	    
	}
		
	public static void  main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter your DOB (dd/mm/yyyy): ");
			String self = sc.next();
			
			System.out.println("Enter your parent/sibling DOB (dd/mm/yyyy):");
			String sibling = sc.next();
			
			getDifference(self,sibling); 
			
			System.out.println("Enter time zone:");
			String zone = sc.next();
			
			getDifferentTimeZone(self,sibling,zone);
		
	}

}
