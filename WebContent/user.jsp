<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="ca.myseneca.model.Employee"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  			
	<link href="css/user.css" rel="stylesheet" type="text/css">
	<link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	 <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
   
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Theme CSS -->
    <link href="css/agency.min.css" rel="stylesheet">
<%
Employee loggedUser = (Employee) request.getSession().getAttribute("User");
%>
<title></title>
</head>
<body>
<body id="page-top" class="index backg">

    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container">
        
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>			
                </button>
                
                          </div>
                          <form class="navbar-right " action="logout">
                          <button class="navbar-right logout btn-primary"  ><i class="fa fa-power-off"></i></button>
                          </form>
			<div class="collapse navbar-collapse">
				<a class="navbar-right navbar-brand page-scroll" href="#page-top">
					Welcome <%= loggedUser.getFirstName()%>&nbsp;&nbsp;&nbsp;
				</a>&nbsp;&nbsp;&nbsp;
				
				</div>

			<br>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse bg-darkest-gray" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-left">
                    <li>
                        <a class="page-scroll" href="ListEmployees.jsp">Employees List</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="addEmployee.jsp">New Employee</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="SearchEmployee.jsp">Search Employee</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
   

        
<h1>&nbsp;

</h1>

</body>
</html>