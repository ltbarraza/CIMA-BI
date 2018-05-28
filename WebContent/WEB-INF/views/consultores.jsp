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



<title>Consultores</title>
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
				href="<c:url value = "compañias"/>">Empresas <span
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

	<div id="div" class="container">
		<div class="row">
			<h2>Consultores</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
						<th scope="col">Telefono</th>
						<th scope="col">Correo</th>
					</tr>
				</thead>
				<tbody data-bind="foreach: consultores">
					<tr>
						<td data-bind="text: nombre"></td>
						<td data-bind="text: apellido"></td>
						<td data-bind="text: telefono"></td>
						<td data-bind="text: correo"></td>
						<td><a href="#" data-bind="click: $parent.findConsultorbyId"
							class="btn btn-secondary btn-sm"><strong>Editar</strong></a></td>
					</tr>
				</tbody>
			</table>
		</div>

		<br>


		<div class="row">
			<div class="col-md-8">
				<form class="form-horizontal" data-bind="submit: addConsultor">
					<div class="row">

						<div class="col-md-4">
							<label>Nombre</label> <input type="hidden" id="id"
								data-bind="value: newConsultor.idUsuario"> <input
								type="text" class="form-control" id="nombre"
								data-bind="value: newConsultor.nombre">
						</div>

						<div class="col-md-4">
							<label>Apellido</label> <input type="text" class="form-control"
								id="apellido" data-bind="value: newConsultor.apellido">
						</div>

						<div class="col-md-4">
							<label>Tipo de Usuario</label> <select class="form-control"
								data-bind="options:tipoUsuarios, optionsText: 'nombre', value: newConsultor.tipoUsuario"></select>
						</div>

					</div>


					<div class="row">

						<div class="col-md-4">
							<label>cedula</label> <input type="number" class="form-control"
								id="cedula" data-bind="value: newConsultor.cedula">
						</div>

						<div class="col-md-4">
							<label>Telefono</label> <input type="number" class="form-control"
								id="telefono" data-bind="value: newConsultor.telefono">
						</div>

						<div class="col-md-4">
							<label>Correo</label> <input type="text" class="form-control"
								id="correo" data-bind="value: newConsultor.correo">
						</div>

					</div>

					<div class="row">

						<div class="col-md-6">
							<label>Usuario</label> <input type="text" class="form-control"
								id="usuario" data-bind="value: newConsultor.usuario">
						</div>

						<div class="col-md-6">
							<label>clave</label> <input type="password" class="form-control"
								id="clave" data-bind="value: newConsultor.clave">
						</div>

					</div>
					<br>

					<div class="row">
						<div class="col-md-6">
							<div class="row">
								<div class="col-md-4">
									<div class="form-check form-check-inline">
										<input type="checkbox" class="form-check-input"
											data-bind="checked: newConsultor.activo" /> <label
											class="form-check-label">Activo</label>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="row">
								<div class="col-md-6"></div>
								<div class="col-md-6">
									<button type="submit" class="btn btn-default">Guardar</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-4">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Empresas</h4>
					</div>
					<table class="table table-fixed">
						<tbody data-bind="foreach: empresas">
							<tr>
								<td><input type="checkbox"
									data-bind="checkedValue: $data, checked: $parent.newConsultor.usuarioEmpresas" /><span
									data-bind="text: nombre"></span></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src='<c:url value="/res/js/knockoutjs.js"></c:url>'></script>

	<script type="text/javascript"
		src='<c:url value="/res/js/consultorKO.js"></c:url>'></script>
</body>
</html>