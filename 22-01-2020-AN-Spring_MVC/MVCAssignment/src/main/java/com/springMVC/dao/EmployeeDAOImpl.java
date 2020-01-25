package com.springMVC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.springMVC.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void saveOrUpdate(Employee employee) {
		// TODO Auto-generated method stub
		if (employee.getEmpId() > 0) {
	        // update
	        String sql = "UPDATE employee SET name=?, email=?, salary=?, mobile=? " + "WHERE emp_id=?";
	        
	        jdbcTemplate.update(sql,employee.getName(),employee.getEmail(),employee.getSalary(),employee.getMobile(),employee.getEmpId());
	        
	    } else {
	        // insert
	        String sql = "INSERT INTO employee (name, email, salary, mobile)" + " VALUES (?, ?, ?,?)";
	        jdbcTemplate.update(sql, employee.getName(), employee.getEmail(),employee.getSalary(),employee.getMobile());
	    }
		
	}

	public void delete(int empId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM employee WHERE emp_id=?";
	    jdbcTemplate.update(sql, empId);
	}

	public Employee get(int empId) {
		String sql = "SELECT * FROM employee WHERE emp_id=" + empId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {
	 
	        public Employee extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Employee emp = new Employee();
	                emp.setEmpId(rs.getInt("emp_id"));
	                emp.setName(rs.getString("name"));
	                emp.setEmail(rs.getString("email"));
	                emp.setSalary(rs.getInt("salary"));
	                emp.setMobile(rs.getString("mobile"));
	                return emp;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public List<Employee> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM employee";
		
	    List<Employee> listContact = jdbcTemplate.query(sql, new RowMapper<Employee>() {
	    	
	        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Employee emp = new Employee();
	 
	            emp.setEmpId(rs.getInt("emp_id"));
	            emp.setName(rs.getString("name"));
	            emp.setEmail(rs.getString("email"));
	            emp.setSalary(rs.getInt("salary"));
	            emp.setMobile(rs.getString("mobile"));
	            
	            return emp;
	        }
	 
	    });
	 
	    return listContact;
	}

}
