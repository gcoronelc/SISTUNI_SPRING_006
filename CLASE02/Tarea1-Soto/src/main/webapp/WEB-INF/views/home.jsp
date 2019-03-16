<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  
	<!-- FORMULARIO DE DATOS -->
	<h2>VENTAS</h2>
	<form method="post" action="calcular.htm">
	 <table>
	   <tr>
	     <td>Precio producto:</td>
	     <td><input type="text" name="num1" /></td>
	   </tr>
	   <tr>
       <td>cantidad:</td>
       <td><input type="text" name="num2" /></td>
     </tr>
     <tr>
       <td colspan="2">
        <input type="submit" value="Procesar" />
       </td>
     </tr>
	 </table>
	</form>
	
	
	<!-- REPORTE -->
  <h2>Detalle de compra</h2>
  <table>
    <tr>
      <td>Importe:</td>
      <td>${importe}</td>
    </tr>
    <tr>
      <td>Impuesto:</td>
      <td>${impuesto}</td>
    </tr>
    <tr>
      <td>Total:</td>
      <td>${total}</td>
    </tr>
  </table>
</body>
</html>
