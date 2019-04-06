<!-- Autor: Gustavo Coronel -->
<!-- Blog: gcoronelc.blogspot.com -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/estilos.css"/>" rel="stylesheet">
<title>GESTION DE ERRORES</title>
</head>
<body>
  
  <h1>GESTION DE ERRORES</h1>
  
  <a href="formulario.htm">Formulario</a>
  <a href="pagina.htm" >Error 404</a>
  <a href="otroError.htm" >Exception</a>
  <a href="division.htm?n1=15&n2=0" >División</a>
  
</body>
</html>