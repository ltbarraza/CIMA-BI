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



<!-- Librerias_javascript  -->
<script type="text/javascript"
	src='<c:url value="/res/js/jquery-3.3.1.min.js"></c:url>'></script>

<script type="text/javascript"
	src='<c:url value="/res/js/jquery-ui.js"></c:url>'></script>

<script type="text/javascript"
	src='<c:url value="/res/js/bootstrap.min.js.map"></c:url>'></script>

<script type="text/javascript"
	src='<c:url value="/res/js/bootstrap.bundle.min.js.map"></c:url>'></script>

<!-- <script type="text/javascript">
	$(document)
			.ready(
					function() {

						$
								.ajax({

									type : "GET",
									url : '${pageContext.request.contextPath}/Empresa/empresas',
									success : function(data) {

										var empresas = data;

										var html = '';

										empresas
												.forEach(function(empresas,
														index) {

													html += '<tr><td>'
															+ '<a href="javascript:findEmpresbyId('
															+ empresas.idEmpresa
															+ ')">'
															+ empresas.nombre
															+ '</a>'
															+ '</td><td>'
															+ '<input type="checkbox">'
															+ '</td><td>'
															+ '<input type="checkbox">'
															+ '</td></tr>'

												});

										$('#thetable tr').first().after(html);

									}
								});

						$('#registro')
								.submit(
										function(event) {

											$
													.ajax({

														url : '${pageContext.request.contextPath}/addempresa',
														type : 'POST',
														data : JSON
																.stringify({

																	nombre : $(
																			'#nombre')
																			.val(),

																	idEmpresa : $(
																			"#idEmpresa")
																			.val(),

																	activa : $(
																			"input:checkbox[name=activa]:checked")
																			.val(),

																	asignada : $(
																			"input:checkbox[name=asignada]:checked")
																			.val()

																}),
														processData : false,
														contentType : "application/json"
													})
											evento.preventDefault();
										});

					});

	function findEmpresbyId(id) {

		$.ajax({

			type : "GET",
			url : '${pageContext.request.contextPath}/empresa/' + id,
			success : function(data) {

				$("#nombre").val(data.nombre);
				$("#idEmpresa").val(data.idEmpresa);

				if (data.activa == true) {

					$('#activa').prop('checked', true);
					$('#activa').val(data.activa);

				} else {

					$('#activa').prop('checked', false);
					/* $('#activa').val(data.activa); */
				}

				if (data.asignada == true) {

					$('#asignada').prop('checked', true);
					$('#asignada').val(data.asignada);

				} else {

					$('#asignada').prop('checked', false);
					/* $('#asignada').val(data.asignada); */
				}
			}

		});

	}
</script>  -->




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
					</tr>
				</tbody>
			</table>
		</div>



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
					</div> <br><br>

					<div class="form-group">
						<button type="submit" class="btn btn-default">Guardar</button>
					</div>




				</form>
			</div>
			<div class="col-md-6"></div>
		</div>
	</div>



	<script type="text/javascript"
		src='<c:url value="/res/js/knockoutjs.js"></c:url>'></script>

	<script type="text/javascript"
		src='<c:url value="/res/js/empresaKO.js"></c:url>'></script>



</body>
</html>