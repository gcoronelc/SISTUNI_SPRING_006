<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <h1>EUREKA BANK</h1>
  <h3>Ven que quiero tu plata</h3>
  
  <p>Cantidad de cuentas: ${CantCuentas}</p>
  <p>Saldo Soles: ${SaldoSoles}</p>
  <p>Saldo Dolares: ${SaldoDolares}</p>
  <p>Cliente: ${Cliente.codigo} ${Cliente.paterno}</p>

</body>
</html>
