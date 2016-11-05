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
	<div class="container">
		<article class="registro"> 
			<p><b> Email </b></p>
			<div class="input-group">
	  			<input type="text" class="form-control" placeholder="Email">
			</div>
			<br>
			<div class="input-group">
				<p><b> Contraseña </b><p>
	  			<input type="text" class="form-control" placeholder="Contraseña">
			</div>
			<br>
			<button type="button" class="btn btn-default">Iniciar sesion</button>
			<button type="button" class="btn btn-default" data-toggle="modal" data-target="#ventanaRegistro">Registrarse</button>	
			<div class="modal fade" id="ventanaRegistro">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">Registro de usuarios</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label for="InputEmail">Email</label>
								<input type="email" class="form-control" id="InputEmail" placeholder="Email">
							</div>
							<div class="form-group">
								<label for="Nombre">Nombre</label>
								<input type="nombre" class="form-control" id="Nombre" placeholder="Nombre">
							</div>
							<div class="form-group">
								<label for="Apellidos">Apellidos</label>
								<input type="apellidos" class="form-control" id="Apellidos" placeholder="Apellidos">
							</div>
							<div class="form-group">
								<label for="Contrasenya">Contrasenya</label>
								<input type="contrasenya" class="form-control" id="Contrasenya" placeholder="Contrasenya">
							</div>
							<div class="form-group">
								<label for="VerificacionContrasenya">Verificacion Contrasenya</label>
								<input type="verificacioncontrasenya" class="form-control" id="VerificacionContrasenya" placeholder="Contrasenya">
							</div>
							<div class="form-group">
								<label for="Ciudad">Ciudad</label>
								<input type="ciudad" class="form-control" id="Ciudad" placeholder="Ciudad">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cerrar</button>
							<button type="button" class="btn btn-default">Guardar cambios</button>
						</div>
					</div>
				</div>	
			</div>
			<br>
			<br>
			<a href="#">Olvide mi contrasenya</a>
		</article>
	</div>
	
	<script src="js/jquery.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
    </body>
</html>
