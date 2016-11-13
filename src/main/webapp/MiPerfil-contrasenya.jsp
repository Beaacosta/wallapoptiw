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
	
	<div class="container-fluid">
		<div class="row">
			<hr>
			<div class="col-md-3">
				<h4>Nombre de usuario</h4>
				<br>
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation"><a href="MiPerfil-editar.jsp">Editar perfil</a></li>
					<li role="presentation"class="active"><a href="MiPerfil-contrasenya">Cambiar contraseña</a></li>
					<li role="presentation"><a href="#">Notificaciones</a></li>
					<li role="presentation"><a href="#">Accesibilidad</a></li>
					<li role="presentation"><a href="#">Seguridad y privacidad</a></li>
				</ul>
			</div>
			<div class="col-xs-9">
				<h3>Contraseña</h3>
				<h4>Cambia tu contraseña actual</h4>
				<hr>
				<form action="editar_usuario" method="post">
				
				<div class="input-group input_espaciado">
					<span class="input-group-addon" id="basic-addon1">Contraseña actual</span>
					<input type="text" class="form-control" name="ContrasenyaActual" id="ContrasenyaActual" placeholder="ContrasenyaActual" aria-describedly="basic-addon1">
				</div>
				<div class="input-group input_espaciado">
					<span class="input-group-addon" id="basic-addon1">Nueva contraseña</span>
					<input type="text" class="form-control" name="NuevaContrasenya" id="NuevaContrasenya" placeholder="NuevaContrasenya" aria-describedly="basic-addon1">
				</div>
				<div class="input-group input_espaciado">
					<span class="input-group-addon" id="basic-addon1">Verificar nueva contraseña</span>
					<input type="text" class="form-control" name="VerificarContrasenya" id="VerificarContrasenya" placeholder="VerificarContrasenya" aria-describedly="basic-addon1">
				</div>
				<button type="hidden" name="accion" value="Cambiar" class="btn btn-default">Guardar cambios</button>	
				<a href="PaginaPrincipal.jsp" class="btn btn-default">Ir a inicio</a>
				</form>	
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
