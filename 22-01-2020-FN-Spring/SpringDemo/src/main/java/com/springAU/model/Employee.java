package com.springAU.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// POJO for Employee
public class Employee {
	
	private int empId;
	private String name;
	private String pos;
	
	public List<Employee> employeeList = new ArrayList<Employee>();
	public Map<Integer,Employee> employeeMap = new HashMap<Integer,Employee>();
	
	public Employee(int empId, String name, String pos) {
		super();
		this.empId = empId;
		this.name = name;
		this.pos = pos;
	}
	
	Employee(){	}
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Map<Integer, Employee> getEmployeeMap() {
		return employeeMap;
	}

	public void setEmployeeMap(Map<Integer, Employee> employeeMap) {
		this.employeeMap = employeeMap;
	}

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
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	@Override
	public String toString() {
		return "[empId=" + empId + ", name=" + name + ", pos=" + pos + "]";
	}

}
