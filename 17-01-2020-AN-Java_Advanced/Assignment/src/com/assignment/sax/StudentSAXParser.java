package com.assignment.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;




public class StudentSAXParser{
	public static void main(String[] args) {

	    try {
	    	 File inputFile = new File("students.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         Handler userhandler = new Handler();
	         saxParser.parse(inputFile, userhandler);  
	         
	    } 
	    catch (ParserConfigurationException | SAXException | IOException e) {
	        e.printStackTrace();
	    }
	   } 
}
