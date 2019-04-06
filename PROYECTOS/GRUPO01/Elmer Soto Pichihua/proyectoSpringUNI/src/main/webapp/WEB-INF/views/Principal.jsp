<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link href="<c:url value="/resources/css/estilos.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/menu/menu.css"/>" rel="stylesheet">
<title>EUREKA</title>
</head>
<body>
  <div class="egcc_page">
    <div class="egcc_header">
  <table>
    <tr >   
        <td>&nbsp&nbsp<img src="<c:url value="/resources/img/usuario.png"/>" >&nbsp</td>
        <td ><p class="class_usuario" style=" margin-top:4px;font-size: 16px;font-weight: bold"">${usuario.nombre} ${usuario.paterno} ${usuario.materno}</p></td>
    </tr>
</table> 
  
    </div>
        
    <div class="egcc_nav">
      <jsp:include page="menu.jsp"></jsp:include>    
    </div>
    <div class="egcc_content" id="PanelContent">
      <div style="width: 100%; text-align: center; padding: 20px;">
        <img alt="" src="<c:url value="/resources/img/Eureka.png"/>">
      </div>
    </div>
<!--     <div class="egcc_footer" style="text-align: center;"> -->
<!-- <!--       Derechos reservados @EGCC - 2020 --> -->
<!--     </div> -->
  </div>
  
  <!-- Cargar los JavaScript -->
  <script type="text/javascript" src="<c:url value="/resources/jquery/jquery.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/jquery/jquery.blockUI.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
  <script type="text/javascript"
		src="<c:url value="/resources/paginas/ConsultarClientes.js"/>"></script>
  
</body>
</html>