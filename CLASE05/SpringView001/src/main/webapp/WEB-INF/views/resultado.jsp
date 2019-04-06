<!-- Autor: Gustavo Coronel -->
<!-- Blog: gcoronelc.blogspot.com -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/estilos.css"/>" rel="stylesheet">
<title>RESULTADO DEL PROCESO</title>
</head>
<body>

  <h1>RESULTADO DEL PROCESO</h1>
  
  <table>
    <tr>
      <td width="100">Nombre:</td>
      <td>${estudianteBean.nombre}</td>
    </tr>
    <tr>
      <td>Nota 1:</td>
      <td>${estudianteBean.nota1}</td>
    </tr>
    <tr>
      <td>Nota 2:</td>
      <td>${estudianteBean.nota2}</td>
    </tr>
    <tr>
      <td>Promedio:</td>
      <td>${estudianteBean.prom}</td>
    </tr>
    <tr>
      <td>Condición:</td>
      <td>${estudianteBean.condicion}</td>
    </tr>                 
  </table>
  
  <a href="<c:url value='/'/>">Nuevo Proceso</a>
  
</body>
</html>