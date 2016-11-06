package es.uc3m.tiw.control.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
import javax.transaction.UserTransaction;

import es.uc3m.tiw.modelo.daos.UsuarioDAO;
import es.uc3m.tiw.modelo.daos.UsuarioDAOImpl;

/**
 * Servlet de ejemplo que muestra distintos aspectos dentro de los ambitos request y session. 
 * -Como usar el metodo init para inicializar datos
 * -Como recoger datos desde un formulario por post
 * -Como no permitir acceso por get redirigiendo a la pagina de login.jsp
 * -Uso del objeto RequestDispatcher y forward
 * -Introduccion de atributos en el objeto request
 * -Uso de objeto sesion para mantener al usuario autenticado
 * -Control de flujo y logica de negicio de un controlador.
 * 
 */

@WebServlet("/inicio")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INDEX_JSP = "/Index.jsp";
	private static final String PPRINCIPAL_JSP = "/PaginaPrincipal.jsp";
	private ServletConfig config;
	
	@PersistenceContext(unitName = "demoTIW")
	private EntityManager em;
	
	@Resource
	private UserTransaction ut;
	private ServletConfig config2;
	private UsuarioDAO usDao;
	
	public void init(ServletConfig config) throws ServletException{
		config2 = config;
		usDao = new UsuarioDAOImpl (em,ut);
		
	}
	
	
	public void destroy() {
		usDao = null;

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
		}
		
		config2.getServletContext().getRequestDispatcher(INDEX_JSP).forward(request, response);*/
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String mensaje ="";
		String pagina ="";
		pagina = "PPRINCIPAL_JSP";
		HttpSession sesion = request.getSession(true);
		ServletContext context = sesion.getServletContext();
		try{
			//busqueda bbdd
		}catch (Exception e){
			e.printStackTrace();
		}
		//puesto el condicional con true pero la condicion es la de !u
		//hay que descomentar ultima linea
		//si el usuario esta en la bbdd
		if (true){//u!=null){
			pagina = PPRINCIPAL_JSP;
			
			//creamos una sesion de usuario
		}else{
			mensaje = "No existen usuarios registrados con esos datos.";
			sesion.setAttribute("mensajeInicio", mensaje);
		}
		
		//config2.getServletContext().getRequestDispatcher(pagina).forward(request, response);
		
	}



}
