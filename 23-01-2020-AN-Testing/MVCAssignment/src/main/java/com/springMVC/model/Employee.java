package com.springMVC.model;

// POJO for employee
public class Employee {

	int empId;
	String name;
	String email;
	int salary;
	String mobile;
	
	public Employee(int empId, String name, String email, int salary, String mobile) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.salary = salary; 
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Employee() {}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int score) {
		this.salary = score;
	}
	
}
