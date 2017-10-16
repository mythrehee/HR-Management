<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ca.myseneca.model.Employee"%>
<%@ page import="java.util.List" %>
<%@ include file="user.jsp" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/custom.css" rel="stylesheet" type="text/css">
 <script type="text/javascript" src="helpers.js"></script>
    <title>Employees List</title>
</head>
<body>
<br><br><br><br><br>
 <h2 class="margin">Employee list</h2>
  <br><br>
    <%  
        @SuppressWarnings("unchecked")
        List<Employee> employees = (List<Employee>) request.getAttribute("employees");
        if (employees != null && !employees.isEmpty()) {
    %>

    <table class="margin">
        <tr><th>Employee ID</th><th>First Name</th><th>Last Name</th><th>E-mail</th><th>Phone Number</th>
            <th>Hire Date</th><th>Job Title</th><th>Salary</th><th>Commission Per</th><th>Manager</th>
            <th>Department</th>
        </tr>
        <%
            for (Employee emp : employees) {
            if (emp != null){
        %>
        <tr>
            <td><a href="UpdateandDeleteEmployee.jsp?id=<%=emp.getEmployeeId() %>"><%=emp.getEmployeeId() %></a></td>
            <td><%=emp.getFirstName() %></td>
            <td><%=emp.getLastName() %></td>
            <td><%=emp.getEmail() %></td>
            <td><%=emp.getPhoneNumber() %></td>
            <td><%=emp.getHireDate() %></td>
            <td><%=emp.getJob().getJobTitle()%></td>
            <td><%=emp.getSalary()%></td>
            <td><%=emp.getCommissionPct()%></td>
            <td><%=(emp.getEmployee() == null ? "" :
                    emp.getEmployee().getLastName() + ", " + emp.getEmployee().getFirstName())%></td>
            <td><%=(emp.getDepartment() == null ? "" : emp.getDepartment().getDepartmentName())%></td>
        </tr>
       <% }
       else {
       
       }
            }
        }
        //else if (employees.isEmpty()) out.println("No Employees found");
        
        %>
    </table>

<br/>
 <input class="  btn  btn-primary"  action="action" onclick="window.history.go(-1); return false;" type="button" value="Back" />

</body>
</html>