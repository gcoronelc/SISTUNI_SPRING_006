<%@page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <h1>FANCY BANK</h1>
  <h3>Ven que quiero tu plata</h3>
  
  <p>Cantidad de cuentas: ${CantCuentas}</p>
  <p>Saldo Dolares: ${SaldoDolares}</p>
  <p>Saldo Soles: ${SaldoSoles}</p>
 	<p>Cliente: ${Cliente.codigo} ${Cliente.paterno} ${Cliente.materno}</p>

  <%  
  Map<String,Object> rec = (Map<String,Object>)request.getAttribute("Cliente");
  %>
  <%= rec.get("paterno") %>
  
  <p>--------------------</p>
  <ul>
  <c:forEach items="${ListaClientes}" var="r">
    <li>${r.codigo} ${r.paterno} ${r.materno}</li>  
  </c:forEach>
  </ul>
</body>
</html>
