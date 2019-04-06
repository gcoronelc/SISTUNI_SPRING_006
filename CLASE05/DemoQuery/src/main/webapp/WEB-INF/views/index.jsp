<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/estilos.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/menu/menu.css"/>" rel="stylesheet">
<title>EUREKA</title>
</head>
<body>
  <div class="egcc_page">
    <div class="egcc_header">
      <h1>EUREKA BANK</h1>
    </div>
    <div class="egcc_nav">
      <jsp:include page="menu.jsp"></jsp:include>    
    </div>
    <div class="egcc_content" id="PanelContent">
      <div style="width: 100%; text-align: center; padding: 20px;">
        <img alt="" src="<c:url value="/resources/img/Eureka.png"/>">
      </div>
    </div>
    <div class="egcc_footer" style="text-align: center;">
      Derechos reservados @EGCC - 2019
    </div>
  </div>
  
  <!-- Cargar los JavaScript -->
  <script type="text/javascript" src="<c:url value="/resources/jquery/jquery.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/jquery/jquery.blockUI.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
  
</body>
</html>