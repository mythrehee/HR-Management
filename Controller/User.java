/**
 * @author Mythrehee Himachalapathy,
 * @author Vishesh Kumar, 
 * @author Vadym Datsiuk
 */
package ca.myseneca.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.myseneca.model.DBAccess;
import ca.myseneca.model.Employee;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 boolean added = false;
		 DBAccess  db = new  DBAccess(); 
		 Employee employee = null;
		try {
			employee = db.empToBeAdded(request);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	        
	        if (employee != null)
	            added = db.addEmployee(employee);
	        if (!added) {
	            request.setAttribute("message", "Something went wrong!");
	            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
	        }
	        else {
	            request.setAttribute("employee", employee);
	            getServletContext().getRequestDispatcher("/addedemp.jsp").forward(request, response);
	        }
	}

}
