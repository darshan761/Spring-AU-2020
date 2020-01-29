package com.springMVC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springMVC.model.Employee;

	
public interface EmployeeDAO {
	     
	    public void saveOrUpdate(Employee employee);
	     
	    public void delete(int empId);
	     
	    public Employee get(int empId);
	     
	    public List<Employee> list();
	}

