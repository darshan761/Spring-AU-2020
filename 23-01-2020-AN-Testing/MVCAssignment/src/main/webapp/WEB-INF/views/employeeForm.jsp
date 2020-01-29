<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Add New Employee</title>
<style>
table{
font-size:27px;
}


</style>
<script type="text/javascript">
            function validate()
            {
                var a = document.getElementById("username").value;
                var b = document.getElementById("useremail").value;
                var c = document.getElementById("salary").value;
                var d = document.getElementById("mobile").value;
                var valid = true;
                if(a.length<=0 || b.length<=0 || c.length<=0 || d.length<=0 )
                    {
                        alert("Don't leave the field empty!");
                        valid = false;
                    }
                    else {
                        if(isNaN(c) || isNaN(d)){
                            alert("Enter a number");
                   			 valid = false;}
                        if (d.length!=10) {
                        	alert("Enter 10 digit mobile number");
                            valid = false;
                        }
                        if (c.length<=3) {
                        	alert("Enter salary greater than 1000");
                            valid = false;
                        }
                }
                    
                return valid;
            };
        </script>
</head>
<body>
    <div align="center">
        <div class="jumbotron"><h1>New Employee</h1></div>
        <form:form action="saveEmployee" method="post" modelAttribute="Employee" onsubmit="return validate();" >
        <table>
           <form:hidden path="empId"/>

            <tr>
                <td>Name:</td>
                <td><form:input path="name" id="username" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" id="useremail"/></td>
            </tr>
             <tr>
                <td>Salary:</td>
                <td><form:input path="salary" id="salary"/></td>
            </tr>
            <tr>
                <td>Mobile:</td>
                <td><form:input path="mobile" id="mobile"/></td>
            </tr>
            </br></br>
            <tr>
                <td colspan="2"  align="center"><input type="submit"  class="btn btn-primary" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>