<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROGRAMACION DE DEPOSITO</title>
</head>
<body>
  
  <h1>REGISTRAR DEPOSITO</h1>
  
  <div id="DivRespuesta" style="color:red;display: none;"></div>
  
  <form id="formRetiro">
  
    <table>
      <tr>
        <td>Cuenta:</td>
        <td><input type="text" name="cuenta" /></td>
      </tr> 
      <tr>
        <td>Importe:</td>
        <td><input type="text" name="importe" /></td>
      </tr>
      <tr>
        <td>Clave:</td>
        <td><input type="password" name="clave" /></td>
      </tr>
      <tr>
        <td><input type="button" id="BtnProcesar" value="Procesar" /></td>
      </tr>
    </table>
  
  </form>
  
  <script type="text/javascript">
  
     $("#BtnProcesar").click(function(){
    	 var data = $("#formRetiro").serialize();
    	 $.blockUI({message:"Procesando deposito."});
    	 $.post("DepositoProc.htm",data,function(respuesta){
    		 $.unblockUI();
    		 $("#DivRespuesta").html(respuesta);
    		 $("#DivRespuesta").show();
    	 });
    	 
    	 
     });
  
  </script>
  
</body>
</html>