<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "es.uc3m.tiw.modelo.Usuario"%>
<%@ page import = "es.uc3m.tiw.modelo.Producto"%>
<%@ page import = "es.uc3m.tiw.modelo.daos.ProductoDAO"%>
<%@ page import = "es.uc3m.tiw.modelo.daos.ProductoDAOImpl"%>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "javax.persistence.EntityManager" %>
<%@ page import = "javax.transaction.UserTransaction" %>
<%@ page import = "java.util.Collection" %>
<%@ page import = "java.io.PrintWriter" %>

<!DOCTYPE html>
<html>

    <head>
	<meta charset="UTF-8">
        <title>WallapopTiw</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="estilos.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    </head>
    <body>
    <%  
					HttpSession sesion = (HttpSession) request.getSession(false);
					String mensaje = (String)sesion.getAttribute("mensajeRegistro");
					if(mensaje!=null){
				%>
					<h3 style="background-color:red; width:95%; margin:10px 20px;" class="alert">${mensajeRegistro}</h3>
				<%} 
					sesion.setAttribute("mensajeRegistro", null);
				%>
	<header class="container-fluid">
		<div class="col-xs-3 col-sm-3">
			<a href="PaginaPrincipal.jsp"><img src="images/logo.png" width="100" alt=logo Wallapop"></a>
		</div>
		<div class="col-xs-9 col-sm-5">
			<h1><b>WALLAPOPTIW</b></h1>
		</div>
		<nav class="col-xs-12 col-sm-4">
			<ul id="menu" class="nav navbar-nav navbar-right">
				<li><a href="#"><img src="images/usuario.png" width="30"></a></li>
				<li><a href="#"><img src="images/productos.png" width="30"></a></li>
				<li><a href="#"><img src="images/chats.png" width=30"></a></li>
			</ul>
		</nav>	
	</header>
	
	<%  
			
			int id=Integer.parseInt(request.getParameter("id"));
			EntityManager em = (EntityManager) sesion.getAttribute("em");
			UserTransaction ut = (UserTransaction) sesion.getAttribute("ut");
			ProductoDAOImpl prod = new ProductoDAOImpl(em, ut);
	
			Producto producto = prod.productoPorClave(id);
			sesion.setAttribute("producto", producto);

	%>
	
	<div class="container-fluid">
		<div class="row col-xs-12 producto container-fluid">
			<div class="row" id="cajaproducto_linea1">
				<div class="col-xs-4">
					<span>${producto.categoria}</span>
				</div>
				<div class="col-xs-4">
					<span>${producto.id}</span>
				</div>
				<div class="col-xs-4">
					<span>${producto.estado}</span>
				</div>
			<hr>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-3">
					<img src="images/carrito.png" width="150" alt="imagenprod">
				</div>
				<div class="col-xs-12 col-sm-9">
					<h2>${producto.titulo}</h2>
					<p>${producto.descripcion}</p>
					<h4 class="precio">${producto.precio}</h4>
				</div>
			</div>
			<div class="row">
				<button class="btn btn-default" type="button" id="boton_chat">Abrir chat</button>
			</div>
		</div>
	</div>
	
	<footer class="container-fluid">
		<div class="row">
			<p>Wallapop, compra y vende productos</p>
			<p>CONDICIONES DE USO. POLITICA DE PRIVACIDAD Y COOKIES</p>
			<p>Copyright ©  2016 - Wallapop - de sus respectivos propietarios
		</div>
	</footer>
	
	<script src="js/jquery.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
    </body>
</html>