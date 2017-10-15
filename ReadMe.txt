

********************************************************************************************
************************************ Brief description *************************************
********************************************************************************************

Package: ca.myseneca.model

DBAccess - This the data access class which provides the interface that is used
            to manipulate data in the database. It implements all the required 
            CRUD features.


Employee - This class is a java bean that has the respective fields for every column in the 
           employees table in the database.Entity generated from table
           
Job - This class is a java bean that has the respective fields for every column in the 
           job table in the database.Entity generated from table
           
Security - This class is a java bean that has the respective fields for every column in the 
           Security table in the database.Entity generated from table.Used for login.
Department - This class is a java bean that has the respective fields for every column in the 
           departments table in the database.Entity generated from table
                     
Package: ca.myseneca.controller

EditEmployee - Servlet used to update the fields of an employee and delete an employee 
EmployeeList - Servlet that displays the list of employee,both all and by department
Login        - Checks the login credentials from the database.
Logout       - Directs back to login page when the credentials are invalid
SearchEmployee - Servlet used to search for an Employee by typing in any part of a name, email
                 address, phone number or department name
User         -Servlet used to add a new employee
               
Web Content(View)

Login  - Start page of the application.Gets the user credentials
user   - User name and power off button common to all the pages
ListEmployees - Gets department id to find employees in that department or all
EmployeesList  - List of employees are displayed.
addEmployee - Gets data to add a new employee
addedemp - acknowledgement message of employee added.
editMessage - acknowledgement message of employee updated or deleted.
SearchEmployee - Gets part of a name, email
                 address, phone number or department name to search
error - error page
********************************************************************************************
************************************** Special Notes ***************************************
********************************************************************************************
To test the code in HRManagement and HRManagementClient class the following can be given as 
test input

User name : hr
Password  : password


