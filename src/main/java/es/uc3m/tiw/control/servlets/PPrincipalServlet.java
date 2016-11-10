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
	private static final String MISPRODUCTOS_JSP="/MisProductos.jsp";
	private String PAGINA="";

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

	// Para introducir URL diretamente en la barra de direcciones del navegador
	// Cuando se hace click sobre un hipervinculo que apunta a la URL del server
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	// Encio de campos por un formulario
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String accion = request.getParameter("accion");
		//String logo = request.getParameter("Logo");
		//String producto = request.getParameter("producto");
		
		HttpSession sesion = (HttpSession) request.getSession(false);
		Usuario user = (Usuario) sesion.getAttribute("usuario_sesion");
		
		//caso iniciar sesion
		if(accion.equals("Editar")){
			sesion.setAttribute("usuario_sesion", user);
			PAGINA=MIPERFIL_JSP;
		}
		/*
		//condicional Productos
		else if (accion.equals("Productos")){
			config.getServletContext().getRequestDispatcher(MISPRODUCTOS_JSP).forward(request, response);

		}
		//Condicional de chat
		else if (accion.equals("Chat")){
			config.getServletContext().getRequestDispatcher(MISPRODUCTOS_JSP).forward(request, response);

		}
		//Condicional de home
		if (logo.equals("Principal")){
			config.getServletContext().getRequestDispatcher(MISPRODUCTOS_JSP).forward(request, response);

		}
		//Condicional de ver un producto
				//este habrá que hacerlo con el mismo identificador a todos
				//y buscar por el par -identificador que es un producto producto.equals(producto1)
				//mas el atributo id del producto (que no sabria como sacarlo)
				if (producto.equals("producto1")){
					config.getServletContext().getRequestDispatcher(MISPRODUCTOS_JSP).forward(request, response);

				}
	*/

		//Condicional de Sing Out que hay que crear
		 config.getServletContext().getRequestDispatcher(PAGINA).forward(request, response);

	}

}
