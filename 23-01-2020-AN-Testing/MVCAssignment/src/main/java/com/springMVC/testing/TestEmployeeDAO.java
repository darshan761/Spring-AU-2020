package com.springMVC.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springMVC.dao.EmployeeDAO;
import com.springMVC.model.Employee;

public class TestEmployeeDAO {

	@Mock
	private EmployeeDAO employeeDAO;

	@Mock
	private Employee employee;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testMockCreation() {
		assertNotNull(employee);
		assertNotNull(employeeDAO);
		assertNotNull(employee);
	}

	// testing get() of EmployeeDAO
	@Test
	public void testGet() throws SQLException {

		// Employee object to be tested
		Employee emp = new Employee(1, "darshan", "darshan@spit.ac.in", 4256, "3424");

		// configure return behavior for mock get method
		when(employeeDAO.get(1)).thenReturn(emp);

		// checks value
		assertEquals(emp, employeeDAO.get(1));

		// verify invocation on mock can also be used for no. of times invoked
		verify(employeeDAO).get(1);
	}

	// testing list() of EmployeeDAO
	@Test
	public void testList() throws SQLException {

		// employee objects to be added to list
		Employee emp1 = new Employee(1, "darshan", "darshan@spit.ac.in", 4256, "3424");
		Employee emp2 = new Employee(2, "rohit", "rohit@spit.ac.in", 231, "34234");

		// list to be tested
		List<Employee> empList = new ArrayList();

		empList.add(emp1);
		empList.add(emp2);

		// // configure return behavior for mock list method
		when(employeeDAO.list()).thenReturn(empList);

		// checks value
		assertEquals(empList, employeeDAO.list());

		// verify invocation on mock
		verify(employeeDAO).list();
	}

	// testing saveOrUpdate() of EmployeeDAO
	@Test
	public void testSaveOrUpdate() throws SQLException {

		// object to be tested
		Employee emp = new Employee(3, "darshan", "darshan@spit.ac.in", 4256, "3424");

		// configure behavior for void method saveOrUpdate() using doAnswer
		doAnswer(invocation -> {

			// typeCast invocation mock to Employee
			Employee argEmp = (Employee) invocation.getMock();

			// checking values
			assertEquals(2, argEmp.getEmpId());
			assertEquals("darshan", argEmp.getName());
			assertEquals("darshan@spit.ac.in", argEmp.getEmail());
			assertEquals(4256, argEmp.getSalary());
			assertEquals("3424", argEmp.getMobile());

			return null;

		}).when(employeeDAO).saveOrUpdate(employee);

		// testing emp object
		employeeDAO.saveOrUpdate(emp);

		// verify invocation on mock
		verify(employeeDAO).saveOrUpdate(emp);
	}

	// testing delete() of EmployeeDAO
	@Test
	public void testDelete() throws SQLException {

		// configure behavior for void method delete() using doAnswer
		doAnswer(invocation -> {

			// get 1st argument passed to invocation
			Object arg = invocation.getArgument(0);

			// checks value
			assertEquals(1, arg);

			return null;

		}).when(employeeDAO).delete(1);

		// testing emp object
		employeeDAO.delete(1);

		// verify invocation on mock
		verify(employeeDAO).delete(1);
	}

}