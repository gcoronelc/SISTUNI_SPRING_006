<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h2>CONSULTAR Producto</h2>
  <form id="FormCriterio">
	  <table>
	    <tr>
	      <td>Código:</td>
	      <td><input type="text" name="codigo" /></td>
	      <td>Descripcion:</td>
	      <td><input type="text" name="descripcion" /></td>
	      <td><input type="button" id="BtnConsultar" value="Consultar"/></td>
	    </tr>
			
	  </table>
  </form>
  
  <div id="DivMensaje" style="color: red; padding: 20px; display: none;">
  </div>
  
  <div id="DivTablaResultado" style="display: none;">
    <h2>RESULTADO</h2>
    <table class="egcc_table">
      <thead>
        <tr>
          <th>CODIGO</th>
          <th>DESCRIPCIÓN</th>
          <th>PRECIO</th>
          <th>STOCK</th>
        </tr>
      </thead>
      <tbody id="TablaDatos">
      </tbody>
    </table>
  </div>
  
  
  <script type="text/javascript" src="<c:url value="/resources/paginas/ConsultarProducto.js"/>"></script>
  
</body>
</html>
