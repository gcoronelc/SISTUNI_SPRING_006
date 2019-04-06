<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style type="text/css">
#LOGON {
	width: 300px;
	padding-top:200px;
	background-color: white;
	color: #04284C;
	margin: 5px auto;
	 
}
</style>
<title>INGRESO AL SISTEMA</title>
</head>
 <body>
<div class="headerLogin" style="background: black;height:80px;vertical-align: middle;" >
    <br>
    <p style="color: white; font-family: sans-serif; font-style: oblique;font-weight: bold;font-size:30px;margin-left: 20px ">EUREKA BANK</p> 
</div> 
	<div id="LOGON">
		<form id="FormLogin" >
		 <div style="text-align: center;">	<h4>INGRESO AL SISTEMA</h4></div>
			<div class="form-group">
				<i class="fa fa-user"></i> <input type="text" class="form-control" name="usuario" placeholder="Username" required="required">
			</div>
			<div class="form-group">
				<i class="fa fa-lock"></i> <input type="password" class="form-control" name="clave" placeholder="Password" required="required">
			</div>
			<div class="form-group"><input type="button" id="BtnIngresar" class="btn btn-primary btn-block btn-lg"value="Ingresar">
			</div>
			
		</form>

	</div>
	
	<script type="text/javascript"src="<c:url value="/resources/paginas/Empleado.js"/>"></script>
	  <script type="text/javascript" src="<c:url value="/resources/jquery/jquery.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/jquery/jquery.blockUI.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
</body>
</html>