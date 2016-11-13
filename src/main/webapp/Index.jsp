<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	<%  
					HttpSession sesion = (HttpSession) request.getSession(false);
					String mensaje = (String)sesion.getAttribute("mensajeRegistro");
					if(mensaje!=null){
				%>
					<h2 style="background-color:red; width:95%; margin:10px 20px;" class="alert">${mensaje}</h2>
				<%} %>
	<!--  Formulario para enviar los datos al SesionServlet -->		
	
	<div class="container">
		<article class="registro">

			<form action="inicio" method="post">
				<p>
					<b> Email </b>
				</p>
				<div class="input-inicio">
					<input type="email" name="email" id="email" class="form-control"
						placeholder="Email">
				</div>
				<br>
				<div class="input-sesion">
					<p>
						<b> Contrasena </b>
					<p>
						<input type="password" name="password" id="password"
							class="form-control" placeholder="Contrasena">
				</div>
				<br>
				<button type="submit" name="accion" value="IniciarSesion"
					class="btn btn-default">Iniciar sesion</button>

			

			<!--  En caso de que el inico de sesión no sea correcto 
			<form method="post" action="inicio">
				<input name="accion" value="invalidar" type="hidden">
				<button> Invalidar sesion </button>			
			</form>-->

			<!--  Formulario para Registrarse en la aplicación -->

			<button type="button" class="btn btn-default" data-toggle="modal"
				data-target="#ventanaRegistro" style="margin-left:15px;">Registrarse</button>
			<div class="modal fade" id="ventanaRegistro">
				<div class="modal-dialog">
					<div class="modal-content">


						<form action="inicio" method="post">

							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Registro de usuarios</h4>
							</div>
							<div class="modal-body">


								<div class="form-group">
									<label for="InputEmail">Email</label> <input type="email"
										name="InputEmail" class="form-control" id="InputEmail" 
										placeholder="Email">
								</div>
								<div class="form-group">
									<label for="Nombre">Nombre</label> <input type="text" name="Nombre" class="form-control" id="Nombre" 
										placeholder="Nombre">
								</div>
								<div class="form-group">
									<label for="Apellidos">Apellidos</label> <input
										type="apellidos" class="form-control" id="Apellidos"
										name="Apellidos"
										placeholder="Apellidos">
								</div>
								<div class="form-group">
									<label for="Contrasenya">Contrasenya</label> <input
										type="contrasenya" class="form-control" id="Contrasenya"
										name="Contrasenya"
										placeholder="Contrasenya">
								</div>
								<div class="form-group">
									<label for="VerificacionContrasenya">Verificacion
										Contrasenya</label> <input type="Verificacioncontrasenya"
										class="form-control" id="VerificacionContrasenya"
										name="VerificacionContrasenya"
										placeholder="Contrasenya">
								</div>
								<div class="form-group">
									<label for="Ciudad">Ciudad</label> <input type="ciudad"
										name="Ciudad" 
										class="form-control" id="Ciudad" placeholder="Ciudad">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal" aria-hidden="true">Cerrar</button>
								<button type="hidden" name="accion" value="registro"
									class="btn btn-default">Guardar cambios</button>
							</div>

						</form>

					</div>
				</div>
			</div>
			<br> <br> <a href="#">Olvide mi contrasenya</a>
			</form>
		</article>
	</div>

	<script src="js/jquery.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>

</body>
</html>
