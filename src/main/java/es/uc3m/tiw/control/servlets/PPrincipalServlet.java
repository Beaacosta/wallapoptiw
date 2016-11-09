package es.uc3m.tiw.control.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.modelo.Usuario;
import es.uc3m.tiw.modelo.daos.UsuarioDAO;
import es.uc3m.tiw.modelo.daos.UsuarioDAOImpl;

@WebServlet("/pag_principal")
public class PPrincipalServlet extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String MIPERFIL_JSP = "/MiPerfil-editar.jsp";

	@PersistenceContext(unitName = "wallapoptiw")
	private EntityManager em;

	@Resource
	private UserTransaction ut;
	private ServletConfig config;
	private UsuarioDAO usuarioDAO;
	
	public void init(ServletConfig config) throws ServletException{
		this.config = config;
		usuarioDAO = new UsuarioDAOImpl (em,ut);
	}


	public void destroy() {
		usuarioDAO = null;

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*String salir = request.getParameter("accion");
		if(salir!=null && !salir.equals("")){
			request.getSession().invalidate();
		}*/
		
		config.getServletContext().getRequestDispatcher(MIPERFIL_JSP).forward(request, response);
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String accion = request.getParameter("accion");

		//caso iniciar sesion
		if(accion.equals("Editar")){
			config.getServletContext().getRequestDispatcher(MIPERFIL_JSP).forward(request, response);
			
		}
	}


}
