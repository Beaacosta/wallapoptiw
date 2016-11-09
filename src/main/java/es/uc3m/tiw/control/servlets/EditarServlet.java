package es.uc3m.tiw.control.servlets;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.modelo.daos.UsuarioDAO;
import es.uc3m.tiw.modelo.daos.UsuarioDAOImpl;

@WebServlet("/editar_usuario")
public class EditarServlet extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String MIPERFIL_JSP = "/MiPerfil-editar.jsp";
	private static final String MICONTRASENYA_JSP = "/MiPerfil-contrasenya.jsp";

	@PersistenceContext(unitName = "wallapoptiw")
	private EntityManager em;

	@Resource
	private UserTransaction ut;
	private ServletConfig config;
	private UsuarioDAO usuarioDAO;
	
	
	public void init(ServletConfig config) throws ServletException{

		System.out.println("HOLA");

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
		if(accion.equals("Guardar")){
			HttpSession sesion = request.getSession(true);
				
			String nombre=request.getParameter("Nombre");
			String apellidos=request.getParameter("Apellidos");
			String email=request.getParameter("Email");				
			String ciudad=request.getParameter("Ciudad");
				
			System.out.println(nombre);
			System.out.println(apellidos);
			System.out.println(email);
			System.out.println(ciudad);
			config.getServletContext().getRequestDispatcher(MIPERFIL_JSP).forward(request, response);

			
		}
	}

}
