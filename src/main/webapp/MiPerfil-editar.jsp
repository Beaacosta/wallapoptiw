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
				<form action="editar_usuario" method="post">
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
			</ul>
		</nav>	
	</header>
	
	<div class="container-fluid">
		<div class="row">
			<hr>
			<div class="col-xs-3">
				<h4>${usuario_sesion.nombre} ${usuario_sesion.apellidos}</h4>
				<br>
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation" class="active"><a href="MiPerfil-editar.jsp">Editar perfil</a></li>
					<li role="presentation"><a href="MiPerfil-contrasenya.jsp">Cambiar contraseña</a></li>
					<li role="presentation"><a href="#">Notificaciones</a></li>
					<li role="presentation"><a href="#">Accesibilidad</a></li>
					<li role="presentation"><a href="#">Seguridad y privacidad</a></li>
				</ul>
			</div>
			<div class="col-xs-9">
				<h3>Perfil</h3>
				<h4>Cambia tus datos personales</h4>
				<hr>
				<form action="editar_usuario" method="post">
					<div class="input-group input_espaciado">
						<span class="input-group-addon" id="basic-addon1">Nombre</span>
						<input type="text" class="form-control" value="${usuario_sesion.nombre}" name="Nombre" id="Nombre" placeholder="Nombre" aria-describedly="basic-addon1">
					</div>
					<div class="input-group input_espaciado">
						<span class="input-group-addon" id="basic-addon1">Apellidos</span>
						<input type="text" class="form-control" value="${usuario_sesion.apellidos}"name="Apellidos" id="Apellidos" placeholder="Apellidos" aria-describedly="basic-addon1">
					</div>
					<div class="input-group input_espaciado">
						<span class="input-group-addon" id="basic-addon1">Email</span>
						<input type="text" class="form-control" value="${usuario_sesion.mail}"name="Email" id="Email" placeholder="Email" aria-describedly="basic-addon1">
					</div>
					<div class="input-group input_espaciado">
						<span class="input-group-addon" id="basic-addon1">Ciudad</span>
						<input type="text" class="form-control" value="${usuario_sesion.ciudad}"name="Ciudad" id="Ciudad" placeholder="Ciudad" aria-describedly="basic-addon1">
					</div>
					<button type="hidden" class="" name="accion" value="Baja">Dar de baja de la aplicación</button>
					<br>
					<br>
					<button type="hidden" class="btn btn-default" name="accion" value="Guardar">Guardar cambios</button>	
				</form>
				<a href="PaginaPrincipal.jsp" class="btn btn-default">Ir a inicio</a>
				
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
