<!-- Autor: Gustavo Coronel -->
<!-- Blog: gcoronelc.blogspot.com -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISTA DE PRODUCTOS</title>
</head>
<body>

	<h1>LISTA DE PRODUCTOS</h1>

	<h3><a href="./exportExcel">Export to Excel</a></h3>
	
	<h3><a href="./exportExcel2">Export to Excel 2</a></h3>
	
	<h3><a href="./verExcel03" target="_blank">Export to Excel 3</a></h3>

	<table border="1px" cellpadding="8px" id="DATOS">
		<tr>
			<td>ID</td>
			<td>NOMBRE</td>
			<td>PRECIO</td>
			<td>SCTOCK</td>
		</tr>

		<c:forEach items="${listaProductos}" var="r">
			<tr>
				<td>${r.id}</td>
				<td>${r.nombre}</td>
				<td>${r.precio}</td>
				<td>${r.stock}</td>
			</tr>
		</c:forEach>
		
	</table>

</body>
</html>
