<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript"
	src='<c:url value="/res/js/jquery.js"></c:url>'></script>
<script type="text/javascript"
	src='<c:url value="/res/js/bootstrap.min.js.map"></c:url>'></script>
<script type="text/javascript"
	src='<c:url value="/res/js/bootstrap.bundle.min.js.map"></c:url>'></script>

<link rel="stylesheet"
	href='<c:url value="/res/css/bootstrap-grid.min.css"></c:url>' />
<link rel="stylesheet"
	href='<c:url value="/res/css/bootstrap.min.css"></c:url>' />

<title>Compañias</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">Navbar</a>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href='<c:url value="/"></c:url>'>Home</a></li>
			<li class="nav-item"><a class="nav-link" href='<c:url value="/Empresa/empresas/"></c:url>'>Compañias</a></li>
			<li class="nav-item"><a class="nav-link" href='<c:url value="/Usuario/consultores/"></c:url>'>Consultores</a></li>
			<li class="nav-item"><a class="nav-link" href='<c:url value="/Usuario/usuarios/"></c:url>'>Usuarios</a></li>
		</ul>
	</div>
	</nav>


	<div class="container">
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
						<th scope="col">Telefono</th>
						<th scope="col">Activo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarios}" var="usuario">
						<tr>
							<td><c:out value="${usuario.nombre}"></c:out></td>
							<td><c:out value="${usuario.apellido}"></c:out></td>
							<td><c:out value="${usuario.telefono}"></c:out></td>
							<td><input type="checkbox" name="activa" value="${usuario.activo}"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>






</body>
</html>