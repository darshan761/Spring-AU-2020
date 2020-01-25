<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Employee Manager Home</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<style>
table{
margin:30px;

}
td {
align:center;
}
</style>
<body>
	<div align="center">
			<div class="jumbotron"><h1>Employee List</h1></div>
            
            <h3><a href="newEmployee">Add New Employee</a></h3>
            <table border="1">
					<th style="width:5%">No</th>
					<th style="width:20%">Name</th>
	                <th style="width:20%">Email</th>
	                <th style="width:15%">Salary</th>
					<th style="width:20%">Mobile</th>
					<th style="width:20%">Action</th>
					<c:forEach var="emp" items="${EmployeeList}" varStatus="status">
	                <tr align="center">
	                    <td>${status.index + 1}</td>
	                    <td>${emp.name}</td>
	                    <td>${emp.email}</td>
	                    <td>${emp.salary}</td>
						<td>${emp.mobile}</td>
						<td>
	                        <a href="editEmployee?id=${emp.empId}" class="btn btn-primary" >Edit</a>
								<a href="deleteEmployee?id=${emp.empId}" class="btn btn-danger">Delete</a>
							
	                     
	                        
	                    </td>
                	</tr>
                </c:forEach>
            </table>
        </div>
</body>
</html>