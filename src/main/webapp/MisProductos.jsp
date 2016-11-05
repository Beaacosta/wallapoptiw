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
			<div class="col-xs-3">
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation"> <a href="#ventanaAnyadirProd" data-toggle="modal"><b>AÑADIR PRODUCTO</b></a></li>
					<div class="modal fade" id="ventanaAnyadirProd">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title">Añade tu producto</h4>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label for="NombreProducto">Nombre del producto</label>
										<input type="NombreProducto" class="form-control" id="NombreProducto" placeholder="NombreProducto">
									</div>
									<div class="form-group">
										<label for="Categoria">Categoria</label>
										<input type="Categoria" class="form-control" id="Categoria" placeholder="Categoria">
									</div>
									<div class="form-group">
										<label for="Descripcion">Descripcion</label>
										<input type="Descripcion" class="form-control" id="Descripcion" placeholder="Descripcion">
									</div>
									<div class="form-group">
										<label for="Precio">Precio</label>
										<input type="Precio" class="form-control" id="Precio" placeholder="Precio">
									</div>
									<div class="form-group">
										<label for="Estado">Estado</label>
										<input type="Estado" class="form-control" id="Estado" placeholder="Disponible/Reservado/Vendido">
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cerrar</button>
									<button type="button" class="btn btn-default">Guardar cambios</button>
								</div>
							</div>
						</div>	
					</div>
				</ul>
			</div>
			<div class="col-xs-9">
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
						<div class="row col-xs-12 col-md-4">
							<h2 class="precio">Precio</h2>
							<div class="centrarbotones">
							<button type="button" class="btn btn-default" data-toggle="modal" data-target="#ventanaEliminarProd">Eliminar</button>
								<div class="modal fade" id="ventanaEliminarProd">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-body black">
													<span>¿Estás seguro de que quieres eliminar el producto?
													<button type="button" class="btn btn-default">Si</button>
													<button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">No</button>		
											</div>
										</div>
									</div>
								</div>	
							<button type="button" class="btn btn-default" data-toggle="modal" data-target="#ventanaModificarProd">Modificar</button>	
							<div class="modal fade" id="ventanaModificarProd">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
											<h4 class="modal-title">Modifica tu producto</h4>
										</div>
										<div class="modal-body">
											<div class="form-group">
												<label for="NombreProducto">Nombre del producto</label>
												<input type="NombreProducto" class="form-control" id="NombreProducto" placeholder="NombreProducto">
											</div>
											<div class="form-group">
												<label for="Categoria">Categoria</label>
												<input type="Categoria" class="form-control" id="Categoria" placeholder="Categoria">
											</div>
											<div class="form-group">
												<label for="Descripcion">Descripcion</label>
												<input type="Descripcion" class="form-control" id="Descripcion" placeholder="Descripcion">
											</div>
											<div class="form-group">
												<label for="Precio">Precio</label>
												<input type="Precio" class="form-control" id="Precio" placeholder="Precio">
											</div>
											<div class="form-group">
												<label for="Estado">Estado</label>
												<input type="Estado" class="form-control" id="Estado" placeholder="Disponible/Reservado/Vendido">
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cerrar</button>
											<button type="button" class="btn btn-default">Guardar cambios</button>
										</div>
									</div>
								</div>	
							</div>
							</div>
						</div>
					</div>
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
