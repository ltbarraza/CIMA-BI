<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href='<c:url value="/res/css/bootstrap.min.css"></c:url>' />

<script type="text/javascript"
	src='<c:url value="/res/js/jquery.js"></c:url>'></script>

<script type="text/javascript"
	src='<c:url value="/res/js/bootstrap.min.js"></c:url>'></script>

<title>Compañias</title>
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
	<br>

	<div class="container">

		<div class="row">
			<div class="col-md-6">
				<form class="form-horizontal" data-bind="submit: addEmpresa">

					<div class="form-group">
						<label>Nombre</label> <input type="hidden" id="id"
							data-bind="value: newEmpresa.idEmpresa"> <input
							type="text" class="form-control" id="nombre"
							data-bind="value: newEmpresa.nombre">
					</div>

					<div class="form-check form-check-label">
						<input type="checkbox" class="form-check-input"
							data-bind="checked: newEmpresa.activa" /> <label
							class="form-check-label">Activa</label>
					</div>

					<div class="form-check form-check-label">
						<input type="checkbox" class="form-check-input"
							data-bind="checked: newEmpresa.asignada" /> <label
							class="form-check-label">Asignada</label>
					</div>
					<br> <br>

					<div class="form-group">
						<button type="submit" class="btn btn-default">Guardar</button>
					</div>
				</form>
			</div>
			<div class="col-md-6"></div>
		</div>


		<div class="row">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Nombre</th>
						<th scope="col">Activa</th>
						<th scope="col">Asignada</th>
					</tr>
				</thead>
				<tbody data-bind="foreach: empresas">
					<tr>
						<td data-bind="text: nombre"></td>
						<td><input type='checkbox' data-bind="checked: activa"
							, disabled /></td>
						<td><input type='checkbox' data-bind="checked: asignada"
							, disabled /></td>
						<td><a href="#" data-bind="click: $parent.findEmpresaId"
							class="btn btn-secondary btn-sm"><strong>Editar</strong></a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>



	<script type="text/javascript"
		src='<c:url value="/res/js/knockoutjs.js"></c:url>'></script>

	<script type="text/javascript"
		src='<c:url value="/res/js/empresaKO.js"></c:url>'></script>



</body>
</html>