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
			<div class="col-xs-3">
				<h4>Nombre de usuario</h4>
				<br>
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation" class="active"><a href="MiPerfil-editar.jsp">Editar perfil</a></li>
					<li role="presentation"><a href="MiPerfil-contrasenya.jsp">Cambiar contrase�a</a></li>
					<li role="presentation"><a href="#">Notificaciones</a></li>
					<li role="presentation"><a href="#">Accesibilidad</a></li>
					<li role="presentation"><a href="#">Seguridad y privacidad</a></li>
				</ul>
			</div>
			<div class="col-xs-9">
				<h3>Perfil</h3>
				<h4>Cambia tus datos personales</h4>
				<hr>
				<div class="input-group input_espaciado">
					<span class="input-group-addon" id="basic-addon1">Nombre</span>
					<input type="text" class="form-control" id="Nombre" placeholder="Nombre" aria-describedly="basic-addon1">
				</div>
				<div class="input-group input_espaciado">
					<span class="input-group-addon" id="basic-addon1">Apellidos</span>
					<input type="text" class="form-control" id="Apellidos" placeholder="Apellidos" aria-describedly="basic-addon1">
				</div>
				<div class="input-group input_espaciado">
					<span class="input-group-addon" id="basic-addon1">Email</span>
					<input type="text" class="form-control" id="Email" placeholder="Email" aria-describedly="basic-addon1">
				</div>
				<div class="input-group input_espaciado">
					<span class="input-group-addon" id="basic-addon1">Ciudad</span>
					<input type="text" class="form-control" id="Ciudad" placeholder="Ciudad" aria-describedly="basic-addon1">
				</div>
				<a href="#">Dar de baja de la aplicaci�n</a>
				<br>
				<br>
				<button type="button" class="btn btn-default">Guardar cambios</button>	
				<a href="PaginaPrincipal.jsp" class="btn btn-default">Ir a inicio</a>	
			</div>
		</div>
	</div>
	
	<footer class="container-fluid">
		<div class="row">
			<p>Wallapop, compra y vende productos</p>
			<p>CONDICIONES DE USO. POLITICA DE PRIVACIDAD Y COOKIES</p>
			<p>Copyright �  2016 - Wallapop - de sus respectivos propietarios
		</div>
	</footer>
	
	<script src="js/jquery.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
    </body>
</html>
