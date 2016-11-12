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

import es.uc3m.tiw.modelo.Usuario;
import es.uc3m.tiw.modelo.Producto;
import es.uc3m.tiw.modelo.daos.UsuarioDAO;
import es.uc3m.tiw.modelo.daos.ProductoDAO;

import es.uc3m.tiw.modelo.daos.UsuarioDAOImpl;
import es.uc3m.tiw.modelo.daos.ProductoDAOImpl;


@WebServlet("/administrador_productos")
public class Administrador_productos extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String PRODUCTOS = "/Producto_admin.jsp";
	private static final String USUARIOS = "/PaginaPrincipal_admin.jsp";

	private String PAGINA = "";

	@PersistenceContext(unitName = "wallapoptiw")
	private EntityManager em;

	@Resource
	private UserTransaction ut;
	private ServletConfig config;
	private ProductoDAO productoDAO;
	
	
	public void init(ServletConfig config) throws ServletException{

		this.config = config;
		productoDAO = new ProductoDAOImpl (em,ut);
	}


	public void destroy() {
		productoDAO = null;

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = (HttpSession) request.getSession(false);
		int id = Integer.parseInt(request.getParameter("id"));
		String accion = request.getParameter("accion");
		
		if(accion.equals("eliminar")){

			try{
				Producto product = null;
				ProductoDAOImpl prod = new ProductoDAOImpl(em, ut);
				product = prod.productoPorClave(id);
				prod.borrarProducto(product);
				String mens ="Producto eliminado correctamente";
				sesion.setAttribute("mensaje", mens);	
				PAGINA=PRODUCTOS;
			}
			catch (Exception e){
				String mens ="Producto no eliminado correctamente";
				sesion.setAttribute("mensaje", mens);	
				PAGINA=PRODUCTOS;
				e.printStackTrace();
				//mensaje no se ha podido eliminar
				
			}
	
		}
		if(accion.equals("editar")){
			
			Producto p = null;
			try{
				p = productoDAO.productoPorClave(id);
				String nombre=request.getParameter("titulo");
				String categoria=request.getParameter("Categoria");
				String descripcion=request.getParameter("Descripcion");				
				Double precio=Double.parseDouble(request.getParameter("Precio"));
				String estado=request.getParameter("Estado");
				
				
				if(!nombre.equals("")){
					p.setTitulo(nombre);
				}
				if(!categoria.equals("")){
					p.setCategoria(categoria);
				}
				if(!descripcion.equals("")){
					//Comprobar que el email no exista ya en la bd
					p.setDescripcion(descripcion);
				}
				if(!precio.equals("")){
					p.setPrecio(precio);
				}
				if(!estado.equals("")){
					p.setEstado(estado);
				}
				
				try{
					p=productoDAO.actualizarProducto(p);
					String mens ="Producto actualizado correctamente";
					sesion.setAttribute("mensaje", mens);	
					PAGINA=PRODUCTOS;
				}
				catch (Exception e){
					String mens ="Producto no actualizado correctamente";
					sesion.setAttribute("mensaje", mens);	
					PAGINA=PRODUCTOS;
					e.printStackTrace();	
				}
			}
			catch(Exception e){
				PAGINA=USUARIOS;
				e.printStackTrace();
			}	
		}
		config.getServletContext().getRequestDispatcher(PAGINA).forward(request, response);	

	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	

}
