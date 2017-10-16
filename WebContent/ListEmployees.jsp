<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="user.jsp" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/custom.css" rel="stylesheet" type="text/css">
<title>List Employees</title>
</head>
<body><br><br><br><br><br>

<h2 class="margin" >Employee List</h2><br>

<p class="margin">Enter the department ID and click on "Show Employees By Department"" to view the employees in that department or click on "Show All Employees" to see the list of all employees.</p>
<form action="EmployeeList">
   <br>   <label class="margin">Department ID : <input type="text" name="department"> </label>
   <br>  <br> <button class="margin btn btn-primary "  name="Submit" value="empbydep" type="Submit">Show Employees By Department</button>  	
     <button class="margin btn  btn-primary "  name="Submit" value="allemp" type="Submit">Show All Employees</button>  	
   </form>
</body>
</html>