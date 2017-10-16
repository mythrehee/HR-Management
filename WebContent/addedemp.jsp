<%@ page import="ca.myseneca.model.Employee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="user.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/custom.css" rel="stylesheet" type="text/css">
<title>Employee Added</title>
</head>
<body class="margin"><br><br><br><br><br><br>
<% Employee employee = (Employee)request.getAttribute("employee"); %>
<h3>Employee <%=employee.getFirstName() + " " + employee.getLastName() %> successfully added.</h3>
<br/>
<br/>
 <input class="  btn  btn-primary"  action="action" onclick="window.history.go(-1); return false;" type="button" value="Back" />

</body>
</html>