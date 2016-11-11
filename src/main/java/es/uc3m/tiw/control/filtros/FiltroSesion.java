package es.uc3m.tiw.control.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SesionFiltro
 */
@WebFilter( urlPatterns = {"/index.jsp","/MiPerfil-contrasenya.jsp","/MiPerfil-editar.jsp","/MisProductos.jsp", "/PaginaPrincipal.jsp", "/Producto.jsp"})
public class FiltroSesion implements Filter {


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession sesion =  ((HttpServletRequest)request).getSession(); //accedemos a la sesion del servidor usando un casting al objeto HttpServletRequest ya que nos pasan solamente ServletRequest
		if (sesion.getAttribute("acceso")!=null && sesion.getAttribute("acceso").equals("ok")) { //buscamos el token de autenticacion
			
			chain.doFilter(request, response); 
		}else{
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}