package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Jersey;

/**
 * Servlet implementation class navigationJerseyServlet
 */
@WebServlet("/navigationJerseyServlet")
public class navigationJerseyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationJerseyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JerseyHelper jh = new JerseyHelper();
		String act = request.getParameter("doThisToJersey");
		ListPlayerHelper lph = new ListPlayerHelper();
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllJerseyServlet").forward(request, response);
		}else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Jersey jerseyToDelete = jh.searchForJerseyById(tempId);
				jh.deleteJersey(jerseyToDelete);
			}catch(NumberFormatException e) {
				System.out.println("Forgot to click a button");
			}
			getServletContext().getRequestDispatcher("/viewAllJerseysServlet").forward(request, response);
		}else if(act.equals("add")) {
			request.setAttribute("allPlayers", lph.showAllPlayers());
			getServletContext().getRequestDispatcher("/new-jersey.jsp").forward(request, response);
		}
	}

}
