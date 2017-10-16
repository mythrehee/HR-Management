<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="ca.myseneca.model.Employee"%>  
  <%@page import="ca.myseneca.model.Job"%>
   <%@page import="ca.myseneca.model.Department"%>   
  <%@page import="ca.myseneca.model.DBAccess"%>  
  <%@ page import="java.util.List" %>
 <%@ include file="user.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body class="margin">

  
 <br>  <br>   <br>  <br> 

<form class="margin" action="EditEmployee" method="post">
    <h3 class="margin" align="center">Edit employee page</h3><br>
    <table class="margin" align="center" >
        <%
            DBAccess db = new  DBAccess();
            long employeeId = Long.parseLong(request.getParameter("id"));
            Employee currentEmployee = db.findEmployee(employeeId);
        %>
        <tr><td>Employee ID:</td><td><input type="number" name="employee_id"
                                            value="<%=currentEmployee.getEmployeeId() %>" readonly /></td></tr>
        <tr><td>First Name:</td><td><input name="first_name"
                                           value="<%=currentEmployee.getFirstName() %>" /></td></tr>
        <tr><td>Last Name:</td><td><input name="last_name"
                                          value="<%=currentEmployee.getLastName() %>"></td></tr>
        <tr><td>E-mail:</td><td><input name="email"
                                       value="<%=currentEmployee.getEmail() %>" /></td></tr>
        <tr><td>Phone Number:</td><td><input name="phone"
                                             value="<%=currentEmployee.getPhoneNumber() %>" /></td></tr>
        <tr><td>Hire Date:</td><td><input name="hire_date"
                                          value="<%=currentEmployee.getHireDate() %>" /></td></tr>
        <tr><td>Job:</td><td>
            <select name="job">
                <option value="<%=currentEmployee.getJob().getJobId() %>" selected>
                    <%=currentEmployee.getJob().getJobTitle() %></option>
                <option value=""></option>
                <%
                    List<Job> jobs = db.getJobList();
                    for (Job name : jobs) {
                %>
                <option value="<%=name.getJobId()  %>"><%=name.getJobTitle() %></option>
                <%
                    }
                %>
            </select>
        </td></tr>
        <tr><td>Salary:</td><td><input type="number" name="salary"
                                       value="<%=currentEmployee.getSalary() %>" /> </td></tr>
        <tr><td>Commission Pct:</td><td><input name="commission"
                                               value="<%=currentEmployee.getCommissionPct() %>" /> </td></tr>
        <tr><td>Manager:</td><td>
            <select name="manager">
                <% if (currentEmployee.getEmployee() != null) { %>
                <option value="<%=currentEmployee.getEmployee().getEmployeeId() %>" selected>
                        <%=currentEmployee.getEmployee().getLastName() + ", " +
                                currentEmployee.getEmployee().getFirstName()%>
                </option>
                <% } %>
                <option value=""></option>
                <%
                    List<Employee> mnames = db.findAllEmployees();
                    for (Employee name : mnames) {
                %>
                <option value="<%=name.getEmployeeId() %>"><%=name.getFirstName() + name.getLastName() %></option>
                <%
                    }
                %>
            </select>
        </td></tr>
        <tr><td>Department:</td><td>
            <select name="department">
                <% if (currentEmployee.getDepartment() != null) { %>
                <option value="<%=currentEmployee.getDepartment().getDepartmentId() %>">
                    <%=currentEmployee.getDepartment().getDepartmentName() %>
                </option>
                <% } %>
                <option value=""></option>
                <%
                    List<Department> dnames = db.getDepartmentList();
                    for (Department name : dnames) {
                %>
                <option value="<%=name.getDepartmentId() %>"><%=name.getDepartmentName() %></option>
                <%
                    }
                %>
            </select>
        </td></tr>
        <tr></tr> 
         </table>
         <br><br>
          <table class="margin" align="center">
        <tr>
            <td><input  class="  btn  btn-primary" type="submit" name="update" value="Update the Employee"></td>	 <td>&nbsp; </td> <td>&nbsp; </td>
            <td><input class="  btn btn-primary" type="submit" name="delete" value="Delete the Employee"></td>
        </tr>
    </table>
    <input class="  btn  btn-primary"  action="action" onclick="window.history.go(-1); return false;" type="button" value="Back" />

</form>
</body>
</html>