<!-- Autor: Gustavo Coronel -->
<!-- Blog: gcoronelc.blogspot.com -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DIVISION</title>
</head>
<body>
  <h1>DIVISION</h1>
  
  <table>
    <tr>
      <td width="50">N1:</td>
      <td>${n1}</td>
    </tr>
    <tr>
      <td>N2:</td>
      <td>${n2}</td>
    </tr>
    <tr>
      <td>División:</td>
      <td>${rpta}</td>
    </tr>               
  </table>
  
  <a href="<c:url value='/'/>">Inicio</a>
</body>
</html>