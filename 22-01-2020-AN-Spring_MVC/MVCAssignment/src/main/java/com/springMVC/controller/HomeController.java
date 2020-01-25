package com.springMVC.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springMVC.dao.EmployeeDAO;
import com.springMVC.exception.Exception404;
import com.springMVC.model.Employee;

@Controller
public class HomeController {
	
	 @Autowired
	 private EmployeeDAO employeeDAO;
	 
	 // home page
	 @RequestMapping(value="/home")
	 public ModelAndView listContact(ModelAndView model) throws IOException{
	     List<Employee> employeeList = employeeDAO.list();
	     model.addObject("EmployeeList", employeeList);
	     model.setViewName("home");
	     return model;
	 }
	 
	 // edit employee
	 @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	 public ModelAndView editEmployee(HttpServletRequest request) {
	     int empId = Integer.parseInt(request.getParameter("id"));
	     Employee newEmployee = employeeDAO.get(empId);
	     ModelAndView model = new ModelAndView();
	     model.addObject("Employee", newEmployee);
	     model.setViewName("employeeForm");
	     return model;
	 }
	 
	// create employee
	 @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	 public ModelAndView newEmployee(ModelAndView model) {
		 Employee newEmployee = new Employee();
	     model.addObject("Employee", newEmployee);
	     model.setViewName("employeeForm");
	     return model;
	 }

	// save employee
	 @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	 public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
	     employeeDAO.saveOrUpdate(employee);
	     return new ModelAndView("redirect:/home");
	 }

	 // delete employee
	 @RequestMapping(value = "deleteEmployee", method = RequestMethod.GET)
	 public ModelAndView deleteEmployee(HttpServletRequest request) {
	     int empId = Integer.parseInt(request.getParameter("id"));
	     employeeDAO.delete(empId);
	     return new ModelAndView("redirect:/home");
	 }
	 
	 // for page not found 
	 @ExceptionHandler(Exception404.class)
		public String pageNotFound() {
			return "404";
		}
		
	@RequestMapping("**")
	public void pageNotFound(ModelAndView modelAndView) {
		throw new Exception404();
			
	}
	 
}
