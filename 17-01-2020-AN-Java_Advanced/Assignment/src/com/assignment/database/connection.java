package com.assignment.database;

import java.util.*;
import java.sql.CallableStatement;
import java.sql.*;  
class connection{  
	public static void main(String args[]){  
		try{  
			// to store employee object in list
			List<Employee> employees = new ArrayList<Employee>();
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			// database connectivity
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/office","root","Root@123"); 

			// to call doJoin stored procedure
			CallableStatement cStmt = con.prepareCall("{call doJoin()}");
			
			cStmt.execute();
			
	          ResultSet rs1 = cStmt.getResultSet();
	          
	          while (rs1.next()) {
	        	  
	        	  // Mapping join result to employee object
	        	  Employee emp = new Employee();
	        	  emp.setEmp_id(rs1.getInt("emp_id"));
	        	  emp.setClient(rs1.getString("client"));
	        	  emp.setEmail(rs1.getString("email"));
	        	  emp.setName(rs1.getString("name"));
	        	  emp.setProject_id(rs1.getInt("project_id"));
	        	  emp.setProject_manager(rs1.getString("project_manager"));
	        	  emp.setProject_name(rs1.getString("project_name"));
	        	  emp.setScore(rs1.getDouble("score"));
	        	  System.out.println(emp.toString());
	        	  
	        	  // adding to employee list
	        	  employees.add(emp);
	               
	          }
	          
	          // display result
	          for(Employee e: employees)
	        	  System.out.println(e.toString());
	          
	          // close connection
			con.close();  
			}
		
		catch(Exception e)
		{ 
			System.out.println(e);}  
			}  
	
}  