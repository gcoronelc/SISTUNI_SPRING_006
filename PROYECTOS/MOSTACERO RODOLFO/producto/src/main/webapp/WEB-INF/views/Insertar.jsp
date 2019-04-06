<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROGRAMACION DE RETIRO</title>
</head>
<body>
  
  <h1>REGISTRAR PRODUCTO</h1>
  
  <div id="DivRespuesta" style="color:red;display: none;"></div>
  
  <form id="formRegistro">
  
    <table>
      <tr>
        <td>Codigo:</td>
        <td><input type="text" name="codigo" /></td>
      </tr> 
      <tr>
        <td>Descripcion:</td>
        <td><input type="text" name="descripcion" /></td>
      </tr>
      <tr>
        <td>Precio:</td>
        <td><input type="number" name="precio" /></td>
      </tr>
      <tr>
        <td>Stock:</td>
        <td><input type="number" name="stock" /></td>
      </tr>
      <tr>
        <td><input type="button" id="BtnProcesar" value="Procesar" /></td>
      </tr>
    </table>
  
  </form>
  
  <script type="text/javascript">
  
     $("#BtnProcesar").click(function(){
    	 var data = $("#formRegistro").serialize();
    	 $.blockUI({message:"Procesando registro."});
    	 $.post("InsertarProductoResp2.htm",data,function(respuesta){
    		 $.unblockUI();
    		 $("#DivRespuesta").html(respuesta);
    		 $("#DivRespuesta").show();
    	 });
    	 
    	 
     });
  
  </script>
  
</body>
</html>