<!-- Autor: Gustavo Coronel -->
<!-- Blog: gcoronelc.blogspot.com -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link href="<c:url value="/resources/css/estilos.css"/>"
	rel="stylesheet">
<title>DATOS DEL ESTUDIANTE</title>
<style type="text/css">
.etiqueta {
	width: 100px;
	display: inline-block;
}
</style>
</head>
<body>

	<h1>DATOS DEL ESTUDIANTE</h1>

	<form:form name="form1" commandName="estudianteBean" method="post"
		action="doProcesarEstudiante.htm">

		<form:errors path="*" element="div" cssClass="errorMessage" />

    <div class="contenido">
    <table>
      <tr>
        <td align="left"><form:label cssClass="etiqueta" path="nombre">Nombre:</form:label></td>
        <td align="left"><form:input path="nombre" /></td>
        <td align="left"><form:errors path="nombre" cssStyle="color:red;" /></td>
      </tr>
      <tr>
        <td align="left"><form:label cssClass="etiqueta" path="nota1">Nota 1:</form:label></td>
        <td align="left"><form:input path="nota1" /></td>
        <td align="left"><form:errors path="nota1" cssStyle="color:red;" /></td>
      </tr>
      <tr>
        <td align="left"><form:label cssClass="etiqueta" path="nota2">Nota 2:</form:label></td>
        <td align="left"><form:input path="nota2" /></td>
        <td align="left"><form:errors path="nota2" cssStyle="color:red;" /></td>
      </tr>          
    </table>
    </div>

	</form:form>

	<a href="javascript: submitform()">Procesar</a>
	<a href="<c:url value="/"/>">Inicio</a>

</body>
<script type="text/javascript">
	function submitform() {
		document.form1.submit();
	}
</script>
</html>
