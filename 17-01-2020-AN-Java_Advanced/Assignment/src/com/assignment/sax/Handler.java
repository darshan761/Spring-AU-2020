package com.assignment.sax;

import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{
	
	 boolean bFName = false;
	 boolean bLName = false;
	 boolean bNumber = false;
	 boolean bAddress = false;
	 boolean bCgpa = false;
	 boolean bGender = false;
	 boolean bDob = false;
	 boolean bEmail = false;
	 boolean bId = false;
	 
	 @Override
	   public void startElement(String uri, 
	   String localName, String qName, Attributes attributes) throws SAXException {

		 if (qName.equalsIgnoreCase("id")) {
			 bId = true;
	      }  
		 else if (qName.equalsIgnoreCase("first_name")) {
			 bFName = true;
	      } else if (qName.equalsIgnoreCase("last_name")) {
	    	  bLName = true;
	      } else if (qName.equalsIgnoreCase("email")) {
	    	  bEmail = true;
	      } 
	      else if (qName.equalsIgnoreCase("gender")) {
	    	  bGender = true;
	      }
	      else if (qName.equalsIgnoreCase("number")) {
	    	  bNumber = true;
	      }
	      else if (qName.equalsIgnoreCase("cgpi")) {
	    	  bCgpa = true;
	      }
	      else if (qName.equalsIgnoreCase("addresss")) {
	    	  bAddress = true;
	      }
	      else if (qName.equalsIgnoreCase("dob")) {
	    	  bDob = true;
	      }

	   }
	 
	 @Override
	   public void endElement(String uri, 
	   String localName, String qName) throws SAXException {
	      if (qName.equalsIgnoreCase("student")) {
	         System.out.println("==============================");
	      }
	   }
	 
	 @Override
	   public void characters(char ch[], int start, int length) throws SAXException {
	      
		 if (bId) {
	         System.out.println("ID: " + new String(ch, start, length));
	         bId = false;
	      } 
		 else if (bFName) {
	         System.out.println("First Name: " + new String(ch, start, length));
	         bFName = false;
	      } 
	      
	     else if (bLName) {
	         System.out.println("Last Name: " + new String(ch, start, length));
	         bLName = false;
	      } 
	     
	     else if (bEmail) {
	         System.out.println("Email: " + new String(ch, start, length));
	         bEmail = false;
	      }
	     else if (bGender) {
	         System.out.println("Gender: " + new String(ch, start, length));
	         bGender = false;
	      } 
	     
	     else if (bNumber) {
	         System.out.println("Mobile: " + new String(ch, start, length));
	         bNumber = false;
	      }
	     else if (bCgpa) {
	         System.out.println("CGPA: " + new String(ch, start, length));
	         bCgpa = false;
	      } 
	     
	     else if (bAddress) {
	         System.out.println("Address: " + new String(ch, start, length));
	         bAddress = false;
	      }
	     else if (bDob) {
	         System.out.println("DOB: " + new String(ch, start, length));
	         bDob = false;
	      
	   }
	 }

}
