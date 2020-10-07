package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;

/**
 * Servlet implementation class AddPlayerServlet
 */
@WebServlet("/addPlayerServlet")
public class AddPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String team = request.getParameter("team");
		String player = request.getParameter("player");
		
		Player li = new Player(team, player);
		ListPlayerHelper dao = new ListPlayerHelper();
		
		dao.insertPlayer(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
