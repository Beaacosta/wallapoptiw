package es.uc3m.tiw.control.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

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

import es.uc3m.tiw.modelo.Producto;
import es.uc3m.tiw.modelo.Usuario;
import es.uc3m.tiw.modelo.daos.ProductoDAOImpl;
import es.uc3m.tiw.modelo.daos.UsuarioDAO;
import es.uc3m.tiw.modelo.daos.UsuarioDAOImpl;

@WebServlet("/editar_usuario")
public class EditarServlet extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String MIPERFIL_JSP = "/MiPerfil-editar.jsp";
	private static final String MICONTRASENYA_JSP = "/MiPerfil-contrasenya.jsp";
	private static final String INDEX_JSP = "/Index.jsp";
	private static final String MISPRODUCTOS_JSP = "/MisProductos.jsp";
	private String PAGINA = "";

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
		
		PAGINA=MIPERFIL_JSP;

		config.getServletContext().getRequestDispatcher(PAGINA).forward(request, response);
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String accion = request.getParameter("accion");

		HttpSession sesion = (HttpSession) request.getSession(false);
		Usuario user = (Usuario) sesion.getAttribute("usuario_sesion");
		
		//MENU SUPERIOR DERECHO
		//caso iniciar sesion
		if(accion.equals("Editar")){
			sesion.setAttribute("usuario_sesion", user);
			PAGINA=MIPERFIL_JSP;
		}
		//condicional Productos
		else if (accion.equals("Productos")){
			sesion.setAttribute("usuario_sesion", user);
			PAGINA=MISPRODUCTOS_JSP;
		}
		/*
		//Condicional de chat
		else if (accion.equals("Chat")){
			config.getServletContext().getRequestDispatcher(MISPRODUCTOS_JSP).forward(request, response);
		}*/
				
		//caso iniciar sesion
		if(accion.equals("Guardar")){
			
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
				//Comprobar que el email no exista ya en la bd
				user.setMail(email);
			}
			if(!ciudad.equals("")){
				user.setCiudad(ciudad);
			}
			
			try{
				user=usuarioDAO.actualizarUsuario(user);
				sesion.setAttribute("usuario_sesion", user);
				PAGINA=MIPERFIL_JSP;
				System.out.println("SI");
			}
			catch (Exception e){
				PAGINA=MIPERFIL_JSP;
				e.printStackTrace();
				//Mensaje no se ha podido editar
				System.out.println("NO");
				
			}
	
		}
		
		if(accion.equals("Cambiar")){
			
			String cont_actual=request.getParameter("ContrasenyaActual");
			String cont_nueva=request.getParameter("NuevaContrasenya");
			String verif_cont=request.getParameter("VerificarContrasenya");							
			
			if(cont_actual.equals("")||cont_nueva.equals("")||verif_cont.equals("")){
				PAGINA=MICONTRASENYA_JSP;
				//No se ha podido cambiar la contraseña
			}
			else{
				//Contraseña actual es correcta y coinciden las contraseñas nuevas
				if((user.getPassword().equals(cont_actual))&&(cont_nueva.equals(verif_cont))){
					user.setPassword(cont_nueva);
					user.setPassVerif(cont_nueva);
				}
				
				try{
					user=usuarioDAO.actualizarUsuario(user);
					sesion.setAttribute("usuario_sesion", user);
					PAGINA=MICONTRASENYA_JSP;
					//Mensaje si se ha podido editar
					System.out.println("SI");
				}
				catch (Exception e){
					PAGINA=MICONTRASENYA_JSP;
					//Mensaje no se ha podido editar
					System.out.println("NO");
					
				}
			}
			
		}
		
		if(accion.equals("Baja")){
			ProductoDAOImpl prod = new ProductoDAOImpl(em, ut);

			try{
				Collection<Producto> productos=prod.buscarProductosDeUsuario(user);
				for(Producto p: productos){
					ProductoDAOImpl prod_borrar = new ProductoDAOImpl(em, ut);
					prod_borrar.borrarProducto(p);
				}
				usuarioDAO.borrarUsuario(user);
				PAGINA=INDEX_JSP;
			}catch(Exception e){
				PAGINA=MIPERFIL_JSP;
			}
		}
		
		config.getServletContext().getRequestDispatcher(PAGINA).forward(request, response);	
	}

}
