package es.uc3m.tiw.control.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
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
import javax.transaction.UserTransaction;

import es.uc3m.tiw.modelo.Usuario;
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
public class InicioServlet extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String INDEX_JSP = "/Index.jsp";
	private static final String PPRINCIPAL_JSP = "/PaginaPrincipal.jsp";

	@PersistenceContext(unitName = "demoTIW")
	private EntityManager em;

	@Resource
	private UserTransaction ut;
	private ServletConfig config;
	private UsuarioDAO usuarioDAO;
	 

	public void init(ServletConfig config) throws ServletException{
		config = config;
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
		}

		config2.getServletContext().getRequestDispatcher(INDEX_JSP).forward(request, response);*/
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String mensaje ="";
		String pagina ="";
		pagina = "PPRINCIPAL_JSP";
		
		HttpSession sesion = request.getSession(true);
		ServletContext context = sesion.getServletContext();

		Usuario usuario = null;

		String accion = request.getParameter("accion");
		String operacion=(String)request.getParameter("action");

		
		//caso iniciar sesion
		if(accion.equals("IniciarSesion")){
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			try{
				usuario=usuarioDAO.recuperarUnUsuarioPorEmailAndPass(email, password);
			}catch (Exception e){
				e.printStackTrace();
			}
			
			//si el usuario esta en la bbdd
			if (usuario!=null && validarResgistro(request) == true){
				pagina = PPRINCIPAL_JSP;

				//creamos una sesion de usuario con TODOS los campos
				
				
				config.getServletContext().getRequestDispatcher(PPRINCIPAL_JSP).forward(request, response);

			}else{
				mensaje = "No existen usuarios registrados con esos datos.";
				sesion.setAttribute("mensajeInicio", mensaje);
			}
		}

		//caso de registrarse
		if(accion.equals("registro")){
			
			String inputEmail = request.getParameter("InputEmail");
			String nombre = request.getParameter("Nombre");
			String apellidos = request.getParameter("Apellidos");
			String contrasenya = request.getParameter("Contrasenya");
			String verificacionContrasenya = request.getParameter("InputEmail");
			String ciudad = request.getParameter("Ciudad");
						
			usuario.setNombre(nombre);
			usuario.setApellidos(apellidos);
			usuario.setMail(inputEmail);
			usuario.setCiudad(ciudad);
			usuario.setPassword(contrasenya);
			
			Collection <Usuario> usuCollection= null;
			
			try{
				
				usuCollection=usuarioDAO.recuperarUnUsuarioPorMail(usuario.getMail());
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			if(usuCollection.isEmpty()){
				try{
					usuario=usuarioDAO.crearUsuario(usuario);
				}catch(Exception e){
					e.printStackTrace();
				}
				
				sesion.setAttribute("usuario", usuario);
				//Collection <Usuario> usuarios = usuarioDAO.listarUsuarios();
				//sesion.setAttribute("usuarios", usuarios);
				sesion.setAttribute("acceso", "ok");
				sesion.setAttribute("mensajeRegistro", mensaje);
				
				config.getServletContext().getRequestDispatcher(PPRINCIPAL_JSP).forward(request, response);
			}else{
				mensaje ="Ya existe un usuario con este email. Por favor, elija otro";
				sesion.setAttribute("mensajeRegistro", mensaje);
				sesion.setAttribute("usuario", usuario);
				config.getServletContext().getRequestDispatcher(INDEX_JSP).forward(request, response);
				
			}
		}


	}

	public boolean validarResgistro(HttpServletRequest request){

		int numParametros= request.getParameterMap().size();

		if(numParametros==2 && request.getParameter("email")!=null && request.getParameter("password")!=null){
			return true;
		}else return false;
	}



}
