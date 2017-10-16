<%@ include file="user.jsp" %>
<%@ page  language="java" %>
<%@ page import="ca.myseneca.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="ca.myseneca.model.Department" %>
<%@ page import="ca.myseneca.model.Job" %>
<%@ page import="ca.myseneca.model.DBAccess" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <script type="text/javascript" src="helpers.js"></script>
    <title>Add an Employee</title>
</head>
<body>
<br><br><br><br><br>
<form class="margin" action="User" method="post">
    <h3 class="margin" align="center">Add a new employee</h3><br>
    <table class="margin" align="center" >
        <!--tr><td>Employee ID:</td><td><input type="number" name="employee_id"></td></tr-->
        <tr><td>First Name:</td><td><input name="first_name"></td></tr>
        <tr><td>Last Name:</td><td><input name="last_name"></td></tr>
        <tr><td>E-mail:</td><td><input name="email"></td></tr>
        <tr><td>Phone Number:</td><td><input name="phone"></td></tr>
        <tr><td>Hire Date:</td><td><input placeholder="yyyy-mm-dd" name="hire_date"></td></tr>
        <tr><td>Job:</td><td>
            <select name="job">
                <option value="" selected></option>
                <%  
                    DBAccess db = new DBAccess();
                    List<Job> Jtitles = db.getJobList();
                    for (Job name : Jtitles) {
                %>
                <option value="<%=name.getJobId() %>"><%=name.getJobTitle() %></option>
                <%
                    }
                %>
            </select>
        </td></tr>
        <tr><td>Salary:</td><td><input type="number" name="salary"></td></tr>
        <tr><td>Commission Pct:</td><td><input name="commission"></td></tr>
        <tr><td>Manager:</td><td>
            <select name="manager">
                <option value="" selected></option>
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
                <option value="" selected></option>
                <%
                    List<Department> dnames = db.getDepartmentList();
                    for (Department name : dnames) {
                %>
                <option value="<%=name.getDepartmentId()%>"><%=name.getDepartmentName() %></option>
                <%
                    }
                %>
            </select>
        </td></tr> </table><br><table align="center">
        <tr><td><input class="margin btn  btn-primary" type="submit" value="Create Employee"></td><td>&nbsp;&nbsp;&nbsp;</td><td><input class=" margin btn  btn-primary" type="reset" value="Clear"></td></tr>
    </table>
    <br>
     <input class="  btn  btn-primary"  action="action" onclick="window.history.go(-1); return false;" type="button" value="Back" />
    
</form>
</body>
</html>

