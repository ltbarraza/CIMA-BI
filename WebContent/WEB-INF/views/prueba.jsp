<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

<title>Pruebas</title>
</head>
<body>






	<label><input type="checkbox"
		data-bind="checked: displayMessage" /> Display message</label>

	<div data-bind="if: displayMessage">Here is a message.
		Astonishing.</div>

	<ul data-bind="foreach: { data: myItems, afterAdd: yellowFadeIn }">
		<li data-bind="text: $data"></li>
	</ul>

	<button data-bind="click: addItem">Add</button>

	<br>

	<ul data-bind="foreach: categories">
		<li>
			<ul>
				<span data-bind="text: name"></span>
			</ul>
			<ul data-bind="foreach: items">
				<li><span data-bind="text: $data"></span></li>
			</ul>
		</li>
	</ul>


	<ul data-bind="foreach: planets">
		<li>Planet: <b data-bind="text: name"> </b>
			<div data-bind="if: capital">
				Capital: <b data-bind="text: capital.cityName"> </b>
			</div>
		</li>
	</ul>


	<div>
		First name: <span data-bind="text: firstName"></span>
	</div>
	<div>
		Last name: <span data-bind="text: lastName"></span>
	</div>
	<div class="heading">
		Hello, <input data-bind="textInput: fullName" />
	</div>




	<div class="heading">
		<input type="checkbox" data-bind="checked: selectedAllProduce"
			title="Select all/none" /> Produce
	</div>
	<div data-bind="foreach: produce">
		<label> <input type="checkbox"
			data-bind="checkedValue: $data, checked: $parent.selectedProduce" />
			<span data-bind="text: $data"></span>
		</label>
	</div>



	<script type="text/javascript"
		src='<c:url value="/res/js/knockoutjs.js"></c:url>'></script>

	<script type="text/javascript"
		src='<c:url value="/res/js/Prueba_app.js"></c:url>'></script>




</body>
</html>