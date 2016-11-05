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
	
	<div class="row">
		<div class="col-xs-12">
			<div class="input-group" id="buscador">
				<input type="text" class="form-control" placeholder="Buscar...">					<span class="input-group-btn">
				<button class="btn btn-default" type="button">Buscar</button>
				<button class="btn btn-default" type="button">Busqueda avanzada</button>
			</div>
		</div>
	</div>

	<div class="row" id="listaproductos">
		<div class="col-xs-12 col-md-4 cajaproducto">
			<div class="container">
				<div class="row">
					<div class="col-xs-3 col-md-1">
						<img src="images/carrito.png" width="100" alt="imagenprod1">
					</div>
					<div class="col-xs-9 col-md-3 datos">
						<h3>Nombre del producto</h3>
						<h4>Categoria del producto</h4>
					</div>
				</div>
				<div class="row col-xs-12 col-md-4 precio">
					<h2>Precio</h2>
				</div>
			</div>
		</div>	
		<div class="clearfix visible-sm-block"></div>				
		<div class="col-xs-12 col-md-4 cajaproducto">
			<div class="container">					<div class="row">
				<div class="col-xs-3 col-md-1">
					<img src="images/carrito.png" width="100" alt="imagenprod2">
				</div>
				<div class="col-xs-9 col-md-3 datos">
					<h3>Nombre del producto</h3>
					<h4>Categoria del producto</h4>
				</div>
			</div>
			<div class="row col-xs-12 col-md-4 precio">
				<h2>Precio</h2>
			</div>
		</div>
				
		</div>	

		<div class="clearfix visible-sm-block"></div>				
			<div class="col-xs-12 col-md-4 cajaproducto">
				<div class="container">
					<div class="row">
						<div class="col-xs-3 col-md-1">
							<img src="images/carrito.png" width="100" alt="imagenprod3">
						</div>
						<div class="col-xs-9 col-md-3 datos">
							<h3>Nombre del producto</h3>
							<h4>Categoria del producto</h4>
						</div>
					</div>
					<div class="row col-xs-12 col-md-4 precio">
						<h2>Precio</h2>
					</div>
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
