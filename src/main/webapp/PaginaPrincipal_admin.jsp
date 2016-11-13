<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "es.uc3m.tiw.modelo.Usuario"%>
<%@ page import = "es.uc3m.tiw.modelo.Producto"%>
<%@ page import = "es.uc3m.tiw.modelo.daos.ProductoDAO"%>
<%@ page import = "es.uc3m.tiw.modelo.daos.ProductoDAOImpl"%>
<%@ page import = "es.uc3m.tiw.modelo.daos.UsuarioDAO"%>
<%@ page import = "es.uc3m.tiw.modelo.daos.UsuarioDAOImpl"%>
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
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="estilos.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

</head>
<body>
	<header class="container-fluid">
		<div class="col-xs-3 col-sm-3">
			<form action="pag_principal" method="post">
				<a href="PaginaPrincipal.jsp"><img src="images/logo.png"
					width="100" alt=logoWallapop"></a> <input type="hidden"
					name="Logo" value="Principal">

			</form>
		</div>
		<div class="col-xs-9 col-sm-5">
			<h1>
				<b>WALLAPOPTIW</b>
			</h1>
		</div>
		<nav class="col-xs-12 col-sm-4">
			<form action="pag_principal_admin" method="post">
				<ul id="menu" class="nav navbar-nav navbar-right">
					<li><button type="submit" name="accion" value="Editar"
							class="btn btn-default">
							<img src="images/usuario.png" width="30">
						</button></li>
					<li><button type="hidden"
							class="btn btn-default"><a href="Producto_admin.jsp"><img src="images/productos.png" width="30"></a>
						</button></li>
					<li><button type="submit" name="accion" value="Chat"
							class="btn btn-default">
							<img src="images/chats.png" width="30">
						</button></li>
				</ul>
			</form>
		</nav>
	</header>

	<div class="row">
		<div class="col-xs-12">
			<div class="input-group" id="buscador">
				<input type="text" class="form-control" placeholder="Buscar...">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">Buscar</button>
					<button class="btn btn-default" type="button">Busqueda
						avanzada</button>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
		<p>Listado de usuarios</p>
	</div>
	
	<!-- <c:if test="${empty usuarios}"> <!-- usuarios es un atributo metido en el request por eso no es necesario ponerle el prefijo param --> -->
		<!-- <p class="error">Si no ves usuarios es porque has accedido directamente a la pagina y por tanto no has pasado por el servlet controlador y no hay datos en el objeto request.</p>  -->
	<!-- </c:if> -->
	<table border="1">
		<tr>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Clave</th>
			<th>Modificar</th>
			<th>Borrar</th>		
		</tr>
		<!-- <c:forEach items="${usuarios }" var="usuario"> <!-- rLe vamos recorriendo toda la lista de usuarios --> 
		<%  
					HttpSession sesion = (HttpSession) request.getSession(false);
					EntityManager em = (EntityManager) sesion.getAttribute("em");
					UserTransaction ut = (UserTransaction) sesion.getAttribute("ut");
					
					UsuarioDAOImpl user_pintar = new UsuarioDAOImpl(em,ut);
					Collection<Usuario> coleccion = user_pintar.listarUsuarios();
					
					for(Usuario u: coleccion){
						sesion.setAttribute("Usuario_pintar", u);
		%>
		<tr>
			<td>${Usuario_pintar.nombre }</td> 
			<td>${Usuario_pintar.apellidos }</td>
			<td>${Usuario_pintar.password }</td>
			<td><a href="usuario?accion=editar&id=${Usuario_pintar.id }">Editar</a> </td>
			<td><a href="usuario?accion=borrar&id=${Usuario_pintar.id }">Borrar</a></td>
		</tr>
		<%
			} 
		%>
		<!--  </c:forEach> -->
	</table>

	<footer class="container-fluid">
		<div class="row">
			<p>Wallapop, compra y vende productos</p>
			<p>CONDICIONES DE USO. POLITICA DE PRIVACIDAD Y COOKIES</p>
			<p>Copyright © 2016 - Wallapop - de sus respectivos propietarios			
		</div>
	</footer>

	<script src="js/jquery.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>

</body>
</html>
