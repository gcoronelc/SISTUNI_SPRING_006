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
  <form method="post" action="sumar.ya">
   <table>
     <tr>
       <td>Nota 1:</td>
       <td><input type="text" name="num1" /></td>
     </tr>
     <tr>
       <td>Nota 2:</td>
       <td><input type="text" name="num2" /></td>
     </tr>
        <tr>
       <td>Nota 3:</td>
       <td><input type="text" name="num3" /></td>
     </tr>
        <tr>
       <td>Nota 4:</td>
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
  <h2>REPORTE DE ALUMNO</h2>
  <table>
    <tr>
      <td>NOTAS DE CICLO </td>
      <td>${notas}</td>
    </tr>
    <tr>
      <td>NOTA ELIMINADA:</td>
      <td>${notaEliminada}</td>
    </tr>
    <tr>
      <td>PROMEDIO</td>
      <td>${promedio}</td>
    </tr>
      
     <tr>
      <td>ESTADO </td>
      <td>${estado}</td>
    </tr>
      
    
  </table>
</body>
</html>






















