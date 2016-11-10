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

import es.uc3m.tiw.modelo.Usuario;
import es.uc3m.tiw.modelo.daos.UsuarioDAO;
import es.uc3m.tiw.modelo.daos.UsuarioDAOImpl;

@WebServlet("/editar_usuario")
public class EditarServlet extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String MIPERFIL_JSP = "/MiPerfil-editar.jsp";
	//private static final String MICONTRASENYA_JSP = "/MiPerfil-contrasenya.jsp";
	private String PAGINA = "";

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
		
		PAGINA=MIPERFIL_JSP;
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
			Usuario user = (Usuario) sesion.getAttribute("usuario_sesion");
			
			String nombre=request.getParameter("Nombre");
			String apellidos=request.getParameter("Apellidos");
			String email=request.getParameter("Email");				
			String ciudad=request.getParameter("Ciudad");
			
			
			if(!nombre.equals("")){
				user.setNombre(nombre);
			}
			if(!apellidos.equals("")){
				user.setApellidos(apellidos);
			}
			if(!email.equals("")){
				user.setMail(email);
			}
			if(!ciudad.equals("")){
				user.setCiudad(ciudad);
			}
			
			
			try{
				user=usuarioDAO.actualizarUsuario(user);
				String usuario_sesion="usuario_sesion";
				sesion.setAttribute("usuario_sesion", user);
				PAGINA=MIPERFIL_JSP;
				System.out.println("SI");
			}
			catch (Exception e){
				PAGINA=MIPERFIL_JSP;
				//Mensaje no se ha podido editar
				System.out.println("NO");
				
			}
			
		}
		config.getServletContext().getRequestDispatcher(PAGINA).forward(request, response);

		
	}

}
