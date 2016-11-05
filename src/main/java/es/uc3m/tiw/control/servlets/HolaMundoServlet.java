package es.uc3m.tiw.control.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundoServlet
 */
@WebServlet("/HolaMundoServlet")
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_JSP = "/Index.jsp";
	private ServletConfig config;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HolaMundoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		config.getServletContext().getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}



}
