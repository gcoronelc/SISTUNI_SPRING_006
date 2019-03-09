<%-- 
    Document   : index
    Created on : Mar 9, 2019, 10:30:37 AM
    Author     : Gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib   prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>SUMAR</title>
   </head>
   <body>
      <h1>SUMAR</h1>
       <form method="post" action="MateSumar">
          <table>
             <tr>
                <td>Número 1: </td>
                <td><input type="text" name="num1"/></td>
             </tr>
             <tr>
                <td>Número 2: </td>
                <td><input type="text" name="num2"/></td>
             </tr>
             <tr>
                <td colspan="2"><input type="submit" value="Procesar"/></td>
             </tr>
          </table>
       </form>
       <c:if test="${suma != null}">
         <h1>REPORTE</h1>
         <table>
             <tr>
                <td>Número 1: </td>
                <td>${num1}</td>
             </tr>
             <tr>
                <td>Número 2: </td>
                <td>${num2}</td>
             </tr>
             <tr>
                <td>Suma: </td>
                <td>${suma}</td>
             </tr>
          </table>
      </c:if>
   </body>
</html>
