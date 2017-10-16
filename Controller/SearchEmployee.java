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
 * Servlet implementation class SearchEmployee
 */
@WebServlet("/SearchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 List<Employee> employees;
	        String pattern = request.getParameter("pattern");
	        DBAccess db = new DBAccess();
	        employees = db.search(pattern);
	        if (employees != null) {
	            request.setAttribute("employees", employees);
	            request.setAttribute("blah", "selected employees.");
	            this.getServletContext().getRequestDispatcher("/EmployeesList.jsp").forward(request, response);
	        }
	        else {
	            request.setAttribute("message","Something went wrong!");
	            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
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
