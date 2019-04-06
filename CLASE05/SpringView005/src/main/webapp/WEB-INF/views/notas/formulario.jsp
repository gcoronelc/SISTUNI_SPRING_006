<!-- Autor: Gustavo Coronel -->
<!-- Blog: gcoronelc.blogspot.com -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link href="<c:url value="/resources/css/estilos.css"/>" rel="stylesheet">
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

	<c:if test="${mensaje != null}">
		<p style="color: red;">${mensaje}</p>
	</c:if>

	<fieldset style="width: 300px;">
		<legend>Formulario</legend>
		<form:form name="form1" commandName="estudianteBean" method="post"
			action="doProcesarEstudiante.htm">

			<form:label cssClass="etiqueta" path="nombre">Nombre:</form:label>
			<form:input path="nombre" />
			<br />

			<form:label cssClass="etiqueta" path="nota1">Nota 1:</form:label>
			<form:input path="nota1" />
			<br />

			<form:label cssClass="etiqueta" path="nota2">Nota 2:</form:label>
			<form:input path="nota2" />
			<br />

		</form:form>
	</fieldset>

	<a href="javascript: submitform()">Procesar</a>
	<a href="<c:url value="/"/>">Inicio</a>

</body>
<script type="text/javascript">
	function submitform() {
		document.form1.submit();
	}
</script>
</html>
