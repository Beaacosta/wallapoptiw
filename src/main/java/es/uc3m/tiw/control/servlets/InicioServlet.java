package es.uc3m.tiw.control.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	private static final String PPRINCIPAL_ADMIN= "/PaginaPrincipal_admin.jsp";
	private String PAGINA = "";

	@PersistenceContext(unitName = "wallapoptiw")
	private EntityManager em;

	@Resource
	private UserTransaction ut;
	private ServletConfig config;
	private UsuarioDAO usuarioDAO;
	private List<Usuario> usuarios;
	Collection<Usuario> u = null;



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
	

		PAGINA=INDEX_JSP;
		config.getServletContext().getRequestDispatcher(PAGINA).forward(request, response);

	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String mensaje ="";

		String accion = request.getParameter("accion");

		
		//caso iniciar sesion
		if(accion.equals("IniciarSesion")){

			HttpSession sesion = request.getSession(true);

			Usuario usuario = null;
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			if(email.equals("")||password.equals("")){
				/*String mensje ="Ya existe un usuario con este email. Por favor, elija otro";
				sesion.setAttribute("mensajeRegistro", mensje);*/
				PAGINA=INDEX_JSP;
			}
			
			else if(email.equals("admin@admin.com") && password.equals("admin")){
				try {
					usuarios = (List<Usuario>) usuarioDAO.listarUsuarios();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("usuarios", usuarios);
				PAGINA=PPRINCIPAL_ADMIN;
				
			}
			
			else{
				 try{
					 usuario=usuarioDAO.recuperarUnUsuarioPorEmailAndPass(email, password);
					 if (usuario==null) {
						 PAGINA=INDEX_JSP;
					 }else {
						 sesion.setAttribute("usuario_sesion", usuario);
						 PAGINA=PPRINCIPAL_JSP;
					 }
				 }catch (Exception e){
					 PAGINA=INDEX_JSP;					 
					 e.printStackTrace();
				 }				
			}							
		}

		//caso de registrarse
		if(accion.equals("registro")){
			String inputMail = request.getParameter("InputEmail");
			String nombre = request.getParameter("Nombre");
			String apellidos = request.getParameter("Apellidos");
			String contrasenya = request.getParameter("Contrasenya");
			String verificacionContrasenya = request.getParameter("VerificacionContrasenya");
			String ciudad = request.getParameter("Ciudad");

			Usuario user = new Usuario();
			user.setNombre(nombre);
			user.setApellidos(apellidos);
			user.setMail(inputMail);
			user.setCiudad(ciudad);
			user.setPassword(contrasenya);
			user.setPassVerif(verificacionContrasenya);

			HttpSession sesion = request.getSession(true);
			
			Usuario usuario_bd = null;
			
			 try{
				 usuario_bd=usuarioDAO.buscarPorMail(inputMail);
				 if (usuario_bd.equals(null)) {
					 try{
						 usuarioDAO.crearUsuario(user);
						 sesion.setAttribute("usuario_sesion", user);
						 PAGINA=PPRINCIPAL_JSP;
					 }
						 catch (Exception e1){
							 e1.printStackTrace();
						 }
				 }else {
					 PAGINA=INDEX_JSP;
				 }
			 }catch (NoResultException e){
				 try{
				 usuarioDAO.crearUsuario(user);
				 sesion.setAttribute("usuario_sesion", user);
				 PAGINA=PPRINCIPAL_JSP;
				 }
				 catch (Exception e1){
					 e1.printStackTrace();
				 }
				 e.printStackTrace();
			 }			
		}
		 config.getServletContext().getRequestDispatcher(PAGINA).forward(request, response);

	}

	public boolean validarResgistro(HttpServletRequest request){

		int numParametros= request.getParameterMap().size();
		if(numParametros==2 && request.getParameter("email")!=null && request.getParameter("password")!=null){
			return true;
		}else return false;
	}



}
