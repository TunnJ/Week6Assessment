package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Jersey;

/**
 * Servlet implementation class viewAllJerseysServlet
 */
@WebServlet("/viewAllJerseysServlet")
public class viewAllJerseysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllJerseysServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JerseyHelper jh = new JerseyHelper();
		List<Jersey> abc = jh.showAllJerseys();
		request.setAttribute("allJerseys", abc);
		if(abc.isEmpty()) {
			request.setAttribute("allJerseys", " ");
		}
		getServletContext().getRequestDispatcher("/jersey-by-user.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
