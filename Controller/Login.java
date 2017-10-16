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
import ca.myseneca.model.DBAccess;;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 String username = request.getParameter("uname");
	     String password = request.getParameter("password");
	     
	     DBAccess db = new DBAccess();
	     boolean loggedIn = db.loginCheck(username, password);
	        if (loggedIn) {
	            request.getSession().setAttribute("User", db.getLoggedEmployee());
	            getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
	        //    response.sendRedirect("/user.jsp");
	        }
	        else {
	            request.setAttribute("error", "Invalid credentials!");
	            getServletContext().getRequestDispatcher("/invalid.jsp").forward(request, response);
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
