<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <h1>SUMAR</h1>
	
	<!-- FORMULARIO DE DATOS -->
	<h2>DATOS</h2>
	<form method="post" action="sumar.ya1">
	 <table>
	   <tr>
	     <td>Precio Producto:</td>
	     <td><input type="text" name="PrecioProd" /></td>
	   </tr>
	   <tr>
       <td>Cantidad:</td>
       <td><input type="text" name="Cantidad" /></td>
     </tr>
     <tr>
       <td colspan="2">
        <input type="submit" value="Procesar" />
       </td>
     </tr>
	 </table>
	</form>
	
	
	<!-- REPORTE -->
  <h2>REPORTE</h2>
  <table>
    <tr>
      <td>Importe de Venta:</td>
      <td>${n1}</td>
    </tr>
    <tr>
      <td>Impuesto:</td>
      <td>${n2}</td>
    </tr>
    <tr>
      <td>Total:</td>
      <td>${total}</td>
    </tr>
  </table>
</body>
</html>
