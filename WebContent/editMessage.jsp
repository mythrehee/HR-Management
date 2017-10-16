<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="ca.myseneca.model.Employee"%>   
    <%@ include file="user.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
    <link href="css/custom.css" rel="stylesheet" type="text/css">
</head>
<body class="margin" >
<header>
 
  
</header><br><br><br><br><br><br>
<% Employee employee = (Employee)request.getAttribute("employee"); %>
<h3 class="margin" >Employee <%=employee.getFirstName() + " " + employee.getLastName() %> successfully updated.</h3>
<br/>
<br/>
 <input class="  btn  btn-primary"  action="action" onclick="window.history.go(-1); return false;" type="button" value="Back" />

</body>
</html>