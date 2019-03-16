<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>CALCULAR IMPORTE</title>
</head>
<body>
  <h1>CALCULAR IMPORTE</h1>
	
	<!-- FORMULARIO DE DATOS -->
	<h2>INGRESAR DATOS</h2>
	<form method="post" action="promedio">
	 <table>
	   <tr>
	     <td>N1:</td>
	     <td><input type="text" name="n1" /></td>
	   </tr>
	   <tr>
       <td>N2:</td>
       <td><input type="text" name="n2" /></td>
     </tr>
     <tr>
       <td>N3:</td>
       <td><input type="text" name="n3" /></td>
     </tr>
     <tr>
       <td>N4:</td>
       <td><input type="text" name="n4" /></td>
     </tr>
     <tr>
       <td colspan="2">
        <input type="submit" value="Procesar" />
       </td>
     </tr>
	 </table>
	</form>
	
	
	<!-- REPORTE -->
	<c:if test="${promedio!=null}">
	  <h2>REPORTE</h2>
	  <table>
	    <tr>
	      <td>N1:</td>
	      <td>${n1}</td>
	    </tr>
	    <tr>
	      <td>N2:</td>
	      <td>${n2}</td>
	    </tr>
	    <tr>
	      <td>N3:</td>
	      <td>${n3}</td>
	    </tr>
	    <tr>
	      <td>N4:</td>
	      <td>${n4}</td>
	    </tr>
	    <tr>
	      <td>Nota eliminada:</td>
	      <td>${menorNota}</td>
	    </tr>
	    <tr>
	      <td>Promedio:</td>
	      <td>${promedio}</td>
	    </tr>
	  </table>
  	</c:if>
</body>
</html>
