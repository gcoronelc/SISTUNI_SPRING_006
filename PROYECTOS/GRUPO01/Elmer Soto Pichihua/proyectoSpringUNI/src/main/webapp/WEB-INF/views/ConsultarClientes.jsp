<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>CONSULTAR CLIENTES</h2>
	<br>
	<form id="FormCriterio">

		<table>
			<tr>
				<td>Código:</td>
				<td><input type="text" name="codigo" class="form-control" /></td>
				<td>Paterno:</td>
				<td><input type="text" name="paterno" class="form-control" /></td>
				<td>Materno:</td>
				<td><input type="text" name="materno" class="form-control" /></td>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" class="form-control" /></td>

				<td><input type="button" id="BtnConsultar" value="Consultar"
					class="btn btn-primary" /></td>

				<td><input type="button" id="BtnNuevoCliente" value="Nuevo" class="btn btn-warning" /></td>
			</tr>
		</table>
	</form>

	<div id="DivMensaje" style="color: red; padding: 20px; display: none;">
	</div>
	<br>
	<div id="DivTablaResultado" style="display: none; width: 900px">
		<h2>RESULTADO</h2>
		<br>
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>CODIGO</th>
					<th>PATERNO</th>
					<th>MATERNO</th>
					<th>NOMBRE</th>
				</tr>
			</thead>
			<tbody id="TablaDatos">
			</tbody>
		</table>
	</div>

	<br>

	<p>==================================================================</p>
	<div id="divCliente" style="display: none">

		<form id="FormCliente">
			<div style="text-align: left;">
				<h4>DATOS CLIENTES</h4>
			</div>

			<table style="width: 400px">
				<tr>
					<td><label>Paterno</label></td>
					<td><input type="text" class="form-control" name="paterno1"   id="paterno1"     required="required" /></td>
				</tr>
				<tr>
					<td><label>Materno</label></td>
					<td><input type="text" class="form-control" name="materno1"  id="materno1"   required="required"/></td>
				</tr>
				<tr>
					<td><label>Nombre</label></td>
					<td><input type="text" class="form-control" name="nombre1"  id="nombre1"   required="required"/></td>
				</tr>
				<tr>
					<td><label>DNI</label></td>
					<td><input type="text" class="form-control" name="dni1"  id="dni1"   required="required"/></td>
				</tr>
				<tr>
					<td><label>Ciudad</label></td>
					<td><input type="text" class="form-control" name="ciudad1"  id="ciudad1"   required="required"/></td>
				</tr>
				<tr>
					<td><label>Dirección</label></td>
					<td><input type="text" class="form-control" name="direccion1"   id="direccion1"  required="required"/></td>
				</tr>
				<tr>
					<td><label>Telefono</label></td>
					<td><input type="text" class="form-control" name="telefono1"   id="telefono1"  required="required"/></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><input type="text" class="form-control" name="email1"  id="email1"  required="required" /></td>
					<td><input type="button" id="BtnProcesar" class="btn btn-success" value="Procesar"></td>
				</tr>

			</table>


		</form>

	</div>


	<script type="text/javascript"
		src="<c:url value="/resources/paginas/ConsultarClientes.js"/>"></script>

</body>
</html>
