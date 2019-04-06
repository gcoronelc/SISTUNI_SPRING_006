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
<title>ERROR EN NOTAS</title>
</head>
<body>

<h1>ERROR EN NOTAS</h1>

<p>Se ha producico error en las notas.</p>
<p>El rango valido es de 0 a 20: [0,20].</p>

<div class="errorMessage">
<ul>
    <li>Exception: <c:out value="${requestScope['javax.servlet.error.exception']}" /></li>
    <li>Exception type: <c:out value="${requestScope['javax.servlet.error.exception_type']}" /></li>
    <li>Exception message: <c:out value="${requestScope['javax.servlet.error.message']}" /></li>
    <li>Request URI: <c:out value="${requestScope['javax.servlet.error.request_uri']}" /></li>
    <li>Servlet name: <c:out value="${requestScope['javax.servlet.error.servlet_name']}" /></li>
    <li>Status code: <c:out value="${requestScope['javax.servlet.error.status_code']}" /></li>
</ul>
</div>

<a href="<c:url value="/"/>">Inicio</a>

</body>
</html>