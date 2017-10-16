<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="user.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/custom.css" rel="stylesheet" type="text/css">
 <script type="text/javascript" src="helpers.js"></script>
    <title>	Search Employee</title>

</head>
<body>
  <br><br><br><br><br><br>
         <h2 class="margin">Search for Employee Page</h2><br><br>
    <p class="margin">Search for an Employee by typing in any part of a name, email address, phone number or department name</p>
<br><br>    <form action="SearchEmployee" method="post" onsubmit="return checkField('pattern', 'Search field', this.submitted)">
        <input class="margin "id="pattern" name="pattern">
                <input class="margin btn  btn-primary"type="submit" value="Search"
                           onclick="this.form.submitted=this.name">
         
    </form>
</body>
</body>
</html>