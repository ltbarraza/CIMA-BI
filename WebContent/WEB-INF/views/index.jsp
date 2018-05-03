<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href='<c:url value="/res/css/bootstrap-grid.min.css"></c:url>' />
<link rel="stylesheet"
	href='<c:url value="/res/css/bootstrap.min.css"></c:url>' />

<script type="text/javascript"
	src='<c:url value="/res/js/jquery.js"></c:url>'></script>
<script type="text/javascript"
	src='<c:url value="/res/js/bootstrap.min.js.map"></c:url>'></script>
<script type="text/javascript"
	src='<c:url value="/res/js/bootstrap.bundle.min.js.map"></c:url>'></script>

<!-- dependencies (jquery, handlebars and bootstrap) -->
<script type="text/javascript"
	src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.5/handlebars.min.js"></script>
<link type="text/css"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<!-- alpaca -->
<link type="text/css"
	href="//code.cloudcms.com/alpaca/1.5.24/bootstrap/alpaca.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="//code.cloudcms.com/alpaca/1.5.24/bootstrap/alpaca.min.js"></script>


<script type="text/javascript">
	$(document)
			.ready(

					function() {

						$
								.ajax({

									type : "GET",
									url : '${pageContext.request.contextPath}/usuarios',
									success : function(data) {

										var usuarios = data;

										var html = '';

										usuarios
												.forEach(function(usuario,
														index) {

													html += '<tr><td>'
															+ '<a href="javascript:findUsuarioById('
															+ usuario.idUsuario
															+ ')">'
															+ usuario.nombre
															+ '</a>'
															+ '</td><td>'
															+ usuario.apellido
															+ '</td><td>'
															+ '<button onClick="deleteUsuario('
															+ usuario.idUsuario
															+ ')" class = "btn btn-danger" type = "button"> Eliminar </ button>'
															+ '</td></tr>';

												});

										$('#thetable tr').first().after(html);

									}
								});

						$('#registro')
								.submit(
										function(event) {

											$
													.ajax({

														url : '${pageContext.request.contextPath}/addusuario',
														type : 'POST',
														data : JSON
																.stringify({

																	idUsuario : $(
																			'#idUsuario')
																			.val(),

																	nombre : $(
																			'#nombre')
																			.val(),
																	apellido : $(
																			'#apellido')
																			.val(),
																	usuario : $(
																			'#usuario')
																			.val(),
																	clave : $(
																			'#clave')
																			.val(),
																	correo : $(
																			'#correo')
																			.val(),
																	groupid : $(
																			'#groupid')
																			.val(),
																	cedula : $(
																			'#cedula')
																			.val(),
																	telefono : $(
																			'#telefono')
																			.val(),
																	activo : $(
																			'#activo')
																			.val(),

																	usuario : $(
																			"#usuario")
																			.val(),

																	tipoUsuario : {

																		idTipo_Usuario : $(
																				'#tipoUsuario')
																				.val(),
																	},

																}),
														processData : false,
														contentType : "application/json"
													})
											evento.preventDefault();
										});

						$
								.ajax({

									type : "GET",
									url : '${pageContext.request.contextPath}/Empresa/empresas',
									success : function(data) {

										var empresas = data;

										var html = '';

										empresas
												.forEach(function(empresa,
														index) {

													html += '<tr><td>'
															+ '<input type="checkbox" class="song" id="empresas" name="'+empresa.nombre+'" value="'+ empresa.idEmpresa +'">'
															+ empresa.nombre
															+ '</td></tr>';

												});

										$('#tablaEmp tr').first().after(html);

									}
								});

					});

	function findUsuarioById(id) {

		$.ajax({

			type : "GET",
			url : '${pageContext.request.contextPath}/usuario/' + id,
			success : function(data) {

				$('#nombre').val(data.nombre), $('#idUsuario').val(
						data.idUsuario), $('#apellido').val(data.apellido), $(
						'#usuario').val(data.usuario), $('#clave').val(
						data.clave), $('#correo').val(data.correo), $(
						'#groupid').val(data.groupid), $('#cedula').val(
						data.cedula), $('#telefono').val(data.telefono);

				if (data.activo == true) {

					$('#activo').prop('checked', true);

				} else {

					$('#activo').prop('checked', false);
				}

			}

		});

	}

	function deleteUsuario(id) {

		$.ajax({

			type : "DELETE",
			url : '${pageContext.request.contextPath}/delete/' + id,
			success : function(data) {

			}

		});

	}
</script>

<title>Panel</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a
		class="navbar-brand" href="#"><img
		src="res/img/Logo_CIMA-BI_V.03.jpg" width="40" height="40" alt=""></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value = "/"/>">Usuarios <span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value = "empresas"/>">Empresas <span
					class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value = "consultor"/>">Consultores <span
					class="sr-only">(current)</span>
			</a></li>

		</ul>

	</div>
	</nav>

	<br>
	<br>

	<div id="div" class="container">

		<div class="row">
			<table id="thetable" class="table table-striped table-sm">
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Eliminar</th>
				</tr>
				<tr>

				</tr>
			</table>
		</div>

		<br> <br>


		<sf:form id="registro" commandName="usuario">

			<sf:input path="idUsuario" id="idUsuario" type="hidden" />

			<sf:input path="tipoUsuario" id="tipoUsuario" type="hidden"
				value="${tipoUsuario.idTipo_Usuario}" />

			<div class="row">
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-4">
							<sf:label path="nombre">Nombre</sf:label>
							<sf:input path="nombre" id="nombre" class="form-control"
								type="text" />
						</div>

						<div class="col-md-4">
							<sf:label path="apellido">Apellido</sf:label>
							<sf:input path="apellido" id="apellido" class="form-control"
								type="text" />
						</div>

						<div class="col-md-4">
							<sf:label path="cedula">Cedula</sf:label>
							<sf:input path="cedula" id="cedula" class="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<sf:label path="telefono">Telefono</sf:label>
							<sf:input path="telefono" id="telefono" class="form-control" />
						</div>

						<div class="col-md-6">
							<sf:label path="correo">Correo</sf:label>
							<sf:input path="correo" id="correo" class="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-md-4">
							<sf:label path="clave">Clave</sf:label>
							<sf:input path="clave" id="clave" class="form-control" />
						</div>

						<div class="col-md-4">
							<sf:label path="usuario">Usuario</sf:label>
							<sf:input path="usuario" id="usuario" class="form-control" />
						</div>

						<div class="col-md-4">
							<sf:label path="groupid">Groupid</sf:label>
							<sf:input path="groupid" id="groupid" class="form-control" />
						</div>
					</div>
				</div>

				<div class="col-md-6">
					<table id="tablaEmp" class="table table-striped table-sm">
						<tr>
							<th>Empresas</th>
						</tr>
						<tr></tr>
					</table>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-4">
							<div class="form-check form-check-inline">
								<sf:checkbox path="activo" id="activo" class="form-check-input" />
								<sf:label path="activo" class="form-check-label" for="activo">Activo</sf:label>
							</div>
						</div>
					</div>
				</div>
			</div>

			<br>

			<div class="row">
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<sf:button class="btn btn-primary">Guardar</sf:button>
						</div>
						<div class="col-md-4"></div>
					</div>
				</div>
			</div>

		</sf:form>
	</div>









</body>
</html>