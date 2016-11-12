package es.uc3m.tiw.control.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

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

import es.uc3m.tiw.control.validaciones.Herramientas;
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
	private String PAGINA = "";

	@PersistenceContext(unitName = "wallapoptiw")
	private EntityManager em;

	@Resource
	private UserTransaction ut;
	private ServletConfig config;
	private UsuarioDAO usuarioDAO;
	Collection<Usuario> u = null;



	public void init(ServletConfig config) throws ServletException{
		this.config = config;
		usuarioDAO = new UsuarioDAOImpl (em,ut);

	}


	public void destroy() {
		usuarioDAO = null;

	}



	/* protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

	    	if (validarResgistro(request) == false) {
	            request.setAttribute("resultados", "Error iniciando sesion");
	            Herramientas.anadirMensaje(request, "El formulario enviado no es correcto");
	            request.getRequestDispatcher("/login.jsp").forward(request, response);
	        } else if (request.getSession().getAttribute("intentosLogin") != null && (Integer) request.getSession().getAttribute("intentosLogin") >= 5) {
	            request.setAttribute("resultados", "Innicio de sesión bloqueado");
	            Herramientas.anadirMensaje(request, "Se han superado el número de intentos de inicio de sesión, se ha bloqueado el incio de sesión");
	            Herramientas.anadirMensaje(request, "Deberá esperar unos minutos para volver a intentarlo");
	            this.starTimer(request.getSession());
	            request.getRequestDispatcher("/login.jsp").forward(request, response);
	        }

	}*/



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

			boolean trueEmail=Herramientas.validarMail(email);
			boolean truePassword=Herramientas.validarPass(password);


			if(trueEmail==false||truePassword==false){
				/*String mensje ="Ya existe un usuario con este email. Por favor, elija otro";
				sesion.setAttribute("mensajeRegistro", mensje);*/
				PAGINA=INDEX_JSP;
			}

			else{
				try{
					usuario=usuarioDAO.recuperarUnUsuarioPorEmailAndPass(email, password);
					if (usuario==null) {
						PAGINA=INDEX_JSP;
						Herramientas.anadirMensaje(request, "El usuario o contraseña son incorrectos");

					}else {
						sesion.setAttribute("usuario_sesion", usuario);
						Herramientas.anadirMensaje(request, "login con exito");
						PAGINA=PPRINCIPAL_JSP;
					}
				}catch (Exception e){
					PAGINA=INDEX_JSP;
					Herramientas.anadirMensaje(request, "No se ha encontrado ningún usuario con los datos especificados");
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

			Boolean trueInputMail = Herramientas.validarMail(inputMail);
			Boolean trueNombre = Herramientas.validarNombre (nombre);
			Boolean trueApellidos = Herramientas.validarNombre (apellidos);
			Boolean trueContrasenya = Herramientas.validarPass(contrasenya);
			Boolean trueVerificacionContrasenya = Herramientas.validarPass (verificacionContrasenya);
			Boolean trueCiudad= Herramientas.validarNombre (ciudad);			



			HttpSession sesion = request.getSession(true);

			Usuario usuario_bd = null;

			if((trueInputMail && trueNombre && trueApellidos && trueContrasenya && trueVerificacionContrasenya && trueCiudad) ==true){
				//todos los parametros son validos
				Usuario user = new Usuario();
				user.setNombre(nombre);
				user.setApellidos(apellidos);
				user.setMail(inputMail);
				user.setCiudad(ciudad);
				user.setPassword(contrasenya);
				user.setPassVerif(verificacionContrasenya);

				if(verificacionContrasenya.equals(contrasenya)){

					try{
						usuario_bd=usuarioDAO.buscarPorMail(inputMail);
						if (usuario_bd.equals(null)) {
							try{
								//usuario no registrado en la bbdd
								//registro valido
								usuarioDAO.crearUsuario(user);
								sesion.setAttribute("usuario_sesion", user);
								PAGINA=PPRINCIPAL_JSP;
							}
							catch (Exception e1){
								e1.printStackTrace();
							}
						}else {
							//usuario registrado en la base de datos
							//Registro no valido
							PAGINA=INDEX_JSP;
						}
					}catch (NoResultException e){
						try{
							//usuario no registrado en la bbdd
							//registro valido
							usuarioDAO.crearUsuario(user);
							sesion.setAttribute("usuario_sesion", user);
							PAGINA=PPRINCIPAL_JSP;
						}
						catch (Exception e1){
							e1.printStackTrace();
						}
						e.printStackTrace();
					}			
				}else{
					//las contrasenyas no son iguales
					config.getServletContext().getRequestDispatcher(PAGINA).forward(request, response);
				}
			}
			else{

				//los campos no estan bien configurados
				config.getServletContext().getRequestDispatcher(PAGINA).forward(request, response);
			}

		}
	}



	public boolean validarResgistro(HttpServletRequest request){

		Map <String, String []> param = request.getParameterMap();
		if(param.size()==3 && param.containsKey("email") && param.containsKey("password")){
			return true;
		}else {
			Herramientas.anadirMensaje(request, "El formulario enviado no tiene el formato correcto");
			return false;
		}
	}

	protected void starTimer(final HttpSession sesion) {
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				sesion.invalidate();
			}
		};

		Timer timer = new Timer();
		//10 minutos ---> 600.000 milisegundos
		timer.schedule(timerTask, 10000);
	}



}
