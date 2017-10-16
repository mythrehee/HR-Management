/**
 * @author Mythrehee Himachalapathy,
 * @author Vishesh Kumar, 
 * @author Vadym Datsiuk
 */
package ca.myseneca.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.myseneca.model.DBAccess;
import ca.myseneca.model.Employee;
/**
 * Servlet implementation class EmployeeList
 */
@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	     String choice = request.getParameter("Submit");
	     Long dep = null ;
	     DBAccess db = new DBAccess();
	     List<Employee> employees = null;
	     if (choice.equals("allemp")){
	    employees = db.findAllEmployees();
	    
	    	  request.setAttribute("employees",employees);
	            getServletContext().getRequestDispatcher("/EmployeesList.jsp").forward(request, response);
	    
	            
	      if (employees.isEmpty()) {
	  	        	 request.setAttribute("error", "No Employees Found");
	  	            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
	  	        
	  	        }
	  	        else {
	  	           
	  	            request.getSession().setAttribute("employees",employees);
	  	            getServletContext().getRequestDispatcher("/EmployeesList.jsp").forward(request, response);
	  	        }
	    	 
	     }
	     else if (choice.equals("empbydep"))
	    	 dep = Long.parseLong(request.getParameter("department"));
	     {
	    	 employees = db.findEmployeesByDepartment(dep.longValue());
	    	 if (employees.isEmpty()) {
	    		    request.setAttribute("error", "No Employees Found");
	  	           
	    		    getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
	  	        
	  	        }
	  	        else {
	  	        	 request.setAttribute("employees", employees);
	  	            getServletContext().getRequestDispatcher("/EmployeesList.jsp").forward(request, response);
	  	        }
	     }
	     }
	     
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
