package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Jersey;

/**
 * Servlet implementation class createNewJerseyServlet
 */
@WebServlet("/createNewJerseyServlet")
public class createNewJerseyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewJerseyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JerseyHelper jh = new JerseyHelper();
		ListPlayerHelper lph = new ListPlayerHelper();
		String color = request.getParameter("jerseyColor");
		String type = request.getParameter("jerseyType");
		
		String selectedPlayer = request.getParameter("playerToAdd");
		int playerId = Integer.parseInt(selectedPlayer);
		
		Jersey jerseyToAdd = new Jersey(color, type, lph.searchForPlayerById(playerId));
		jh.insertJersey(jerseyToAdd);
		getServletContext().getRequestDispatcher("/viewAllJerseysServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
