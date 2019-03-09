<%-- 
    Document   : index
    Created on : Mar 9, 2019, 10:30:37 AM
    Author     : Gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>SUMAR</title>
   </head>
   <body>
      <h1>SUMAR</h1>
      <form id="form1">
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
                <td colspan="2"><input type="button" id="btnProcesar" value="Procesar"/></td>
             </tr>
          </table>
       </form>
      <div id="divReporte" style="display: none;">
         <h1>REPORTE</h1>
         <table>
             <tr>
                <td>Número 1: </td>
                <td><span id="rptaNum1"></span></td>
             </tr>
             <tr>
                <td>Número 2: </td>
                <td><span id="rptaNum2"></span></td>
             </tr>
             <tr>
                <td>Suma: </td>
                <td><span id="rptaSuma"></span></td>
             </tr>
         </table>
      </div>
      
      <script src="jquery/jquery-3.3.1.min.js" type="text/javascript"></script>
      
      <script>
         
         $("#btnProcesar").click(function(){
            
            var data = $("#form1").serialize();
            $.post("MateSumar", data, function(objeto){
               
               $("#rptaNum1").html(objeto.num1);
               $("#rptaNum2").html(objeto.num2);
               $("#rptaSuma").html(objeto.suma);
               
               $("#divReporte").show();
            });
            
         });
         
      </script>
   </body>
</html>
