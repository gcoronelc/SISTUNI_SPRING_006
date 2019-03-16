<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <h1>PROMEDIO</h1>
  
  <!-- FORMULARIO DE DATOS -->
  <h2>DATOS</h2>
  <form method="post" action="sumar.ya">
   <table>
     <tr>
       <td>NOTA 1:</td>
       <td><input type="text" name="num1" /></td>
     </tr>
     <tr>
       <td>NOTA 2:</td>
       <td><input type="text" name="num2" /></td>
     </tr>
     <tr>
       <td>NOTA 3:</td>
       <td><input type="text" name="num3" /></td>
     </tr>
     <tr>
       <td>NOTA 4:</td>
       <td><input type="text" name="num4" /></td>
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
      <td>NOTA 1:</td>
      <td>${n1}</td>
    </tr>
    <tr>
      <td>NOTA 2:</td>
      <td>${n2}</td>
    </tr>
    <tr>
      <td>NOTA 3:</td>
      <td>${n3}</td>
    </tr>
    <tr>
      <td>NOTA 4:</td>
      <td>${n4}</td>
    </tr>
    <tr>
      <td>PROMEDIO:</td>
      <td>${prom}</td>
    </tr>
    <tr>
      <td>SITUACIÓN:</td>
      <td>${situa}</td>
    </tr>
  </table>
</body>
</html>
