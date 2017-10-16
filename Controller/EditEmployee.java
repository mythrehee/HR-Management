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
import ca.myseneca.model.Employee;
import ca.myseneca.model.DBAccess;
/**
 * Servlet implementation class EditEmployee
 */
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployee() {
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
		boolean doUpdate = false, doDelete = false;
        if (request.getParameter("update") != null)
            doUpdate = true;
        else if (request.getParameter("delete") != null)
            doDelete = true;

        boolean hasSucceed = false; 

        DBAccess db = new DBAccess();
        Employee employee = null;
        try {
            employee = db.empToBeAdded(request);
            
        } catch (Exception ex) {
            ex.getMessage();
        }

        if (doUpdate) {
            if (employee != null)
                hasSucceed = db.updateEmployee(employee);
        }
        if (doDelete) {
            if (employee != null)
                hasSucceed = db.deleteEmployee(employee);
        }


        if (!hasSucceed) {
            request.setAttribute("message", "Something went wrong!");
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
        else {
            request.setAttribute("employee", employee);
            getServletContext().getRequestDispatcher("/editMessage.jsp").forward(request, response);
        }
	}

}
