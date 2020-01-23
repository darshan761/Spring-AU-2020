package com.springAU.service;

import java.util.List;

import org.springframework.stereotype.Component;
import com.springAU.model.Employee;

@Component
public class EmployeeService {

	List<Employee> employeeList;
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Employee> getAllEmployees(){
		return employeeList;
	}
}
