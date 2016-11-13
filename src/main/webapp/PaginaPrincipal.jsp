<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.uc3m.tiw.modelo.Usuario"%>
<%@ page import="es.uc3m.tiw.modelo.Producto"%>
<%@ page import="es.uc3m.tiw.modelo.daos.ProductoDAO"%>
<%@ page import="es.uc3m.tiw.modelo.daos.ProductoDAOImpl"%>
<%@ page import="es.uc3m.tiw.modelo.daos.UsuarioDAOImpl"%>
<%@ page import="es.uc3m.tiw.modelo.daos.UsuarioDAO"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="javax.persistence.EntityManager"%>
<%@ page import="javax.transaction.UserTransaction"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.io.PrintWriter"%>



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
			<form action="pag_principal" method="post">
				<ul id="menu" class="nav navbar-nav navbar-right">
					<li><button type="submit" name="accion" value="Editar"
							class="btn btn-default">
							<img src="images/usuario.png" width="30">
						</button></li>
					<li><button type="submit" name="accion" value="Productos"
							class="btn btn-default">
							<img src="images/productos.png" width="30">
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


	<!-- EMPEZAMOS A LISTAR PRODUCTOS -->

	<div class="row" id="listaproductos">


		<div class="col-xs-9">
			<%
				HttpSession sesion = (HttpSession) request.getSession(false);
				EntityManager em = (EntityManager) sesion.getAttribute("em");
				UserTransaction ut = (UserTransaction) sesion.getAttribute("ut");
				ProductoDAOImpl prod = new ProductoDAOImpl(em, ut);
				UsuarioDAOImpl usuarioDao = new UsuarioDAOImpl(em, ut);

				//Collection<Usuario> coleccionUsuario = usuarioDao.listarUsuarios();

				Collection<Producto> coleccionProducto = prod.listarProductos();
				if (coleccionProducto.isEmpty()) {
			%>
			<div class="col-xs-12 col-md-4 cajaproducto">
				<p>No existen productos a la venta</p>
			</div>
			<%
				} else {
					for (Producto p : coleccionProducto) {

						sesion.setAttribute("prod_sesion", p);
			%>
			<form action="productos" method="post">
				<div class="col-xs-12 col-md-4 cajaproducto">
					<div class="container">
						<div class="row">
							<form action="pag_principal" name="item1" method="post">
								<a href="#" onclick="PaginaPrincipal.item1.submit();">
									<div class="col-xs-3 col-md-1">
										<img src="images/carrito.png" width="100" alt="imagenprod1">
									</div> <input type="hidden" name="producto" value="producto1">
									<div class="col-xs-9 col-md-3 datos">
										<h3>${prod_sesion.titulo}</h3>
										<h4>${prod_sesion.categoria}</h4>
									</div>
						</div>
						</a>
			</form>
			<div class="row col-xs-12 col-md-4 precio">
				<h2>${prod_sesion.precio}</h2>
			</div>
		</div>
	</div>
	</form>
	<%
		}
		}
	%>
	</div>

	</div>

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
