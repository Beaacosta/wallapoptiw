package es.uc3m.tiw.control.servlets;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
import es.uc3m.tiw.modelo.daos.ProductoDAO;
import es.uc3m.tiw.modelo.daos.ProductoDAOImpl;
import es.uc3m.tiw.modelo.daos.UsuarioDAO;
import es.uc3m.tiw.modelo.daos.UsuarioDAOImpl;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String MIPERFIL_JSP = "/MiPerfil-editar.jsp";
	private static final String MISPRODUCTOS_JSP = "/MisProductos.jsp";
	private String PAGINA = "";

	@PersistenceContext(unitName = "wallapoptiw")
	private EntityManager em;

	@Resource
	private UserTransaction ut;
	private ServletConfig config;
	private ProductoDAO productoDao;
	
	
	public void init(ServletConfig config) throws ServletException{

		this.config = config;
		productoDao = new ProductoDAOImpl (em,ut);

	}


	public void destroy() {
		productoDao = null;

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PAGINA=MISPRODUCTOS_JSP;

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

		
		//caso de añadir un producto
		if(accion.equals("producto")){

			String nombre = request.getParameter("NombreProducto");
			String categoria = request.getParameter("Categoria");
			String descripcion = request.getParameter("Descripcion");
			Double precio = Double.parseDouble(request.getParameter("Precio"));
			String estado = request.getParameter("Estado");
			

			Producto producto = new Producto();
			
			if(nombre!=null){
				producto.setTitulo(nombre);
			}
			if(categoria!=null){
				producto.setCategoria(categoria);
			}
			if(descripcion!=null){
				producto.setDescripcion(descripcion);
			}
			if(precio!=null){
				producto.setPrecio(precio);
			}
			if(estado!=null){
				producto.setEstado(estado);
			}
			
			producto.setPicture(null);
			producto.setUsuario(user);

			try{
				productoDao.crearProducto(producto);
				//Se ha creado correctamente
				PAGINA=MISPRODUCTOS_JSP;
			}catch(Exception e){
				//No se ha creado correctamente
				PAGINA=MISPRODUCTOS_JSP;
				e.printStackTrace();
			}
		}else if(accion.equals("eliminar")){
			try{
				
			}catch(Exception e){
				
			}
		}else if(accion.equals("no_eliminar")){
			try{
				
			}catch(Exception e){
				
			}
		}else if(accion.equals("modificar")){
			String nombre = request.getParameter("NombreProducto");
			String categoria = request.getParameter("Categoria");
			String descripcion = request.getParameter("Descripcion");
			String precio = request.getParameter("Precio");
			String estado = request.getParameter("Estado");
			
			//Este producto debe de ser el que se haya arcado, no se si por sesion id o como
			Producto producto = new Producto();
			
			if(nombre!=null){
				producto.setTitulo(nombre);
			}
			if(categoria!=null){
				producto.setCategoria(categoria);
			}
			if(descripcion!=null){
				producto.setDescripcion(descripcion);
			}
			if(precio!=null){
			//	producto.setPrecio(precio);
			}
			if(estado!=null){
				producto.setEstado(estado);
			}

			try{
				
			}catch(Exception e){
				
			}
		}
		
		
		config.getServletContext().getRequestDispatcher(PAGINA).forward(request, response);	
	}

}

