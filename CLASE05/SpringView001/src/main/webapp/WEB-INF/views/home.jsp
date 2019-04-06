<!-- Autor: Gustavo Coronel -->
<!-- Blog: gcoronelc.blogspot.com -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link href="<c:url value="/resources/css/estilos.css"/>" rel="stylesheet">
<title>DATOS DEL ESTUDIANTE</title>
</head>
<body>

	<h1>DATOS DEL ESTUDIANTE</h1>

	<c:if test="${mensaje != null}">
		<p class="errorMessage">${mensaje}</p>
	</c:if>

	<form:form commandName="panchito" method="post"
		action="doProcesarEstudiante.htm">

		<fieldset style="width: 300px;">
			<legend>Formulario</legend>

			<form:label cssClass="etiqueta" path="nombre">Nombre:</form:label>
			<form:input path="nombre" />
			<br />

			<form:label cssClass="etiqueta" path="nota1">Nota 1:</form:label>
			<form:input path="nota1" />
			<br />

			<form:label cssClass="etiqueta" path="nota2">Nota 2:</form:label>
			<form:input path="nota2" />
			<br />
			
		</fieldset>
		<input type="submit" value="Procesar" />

	</form:form>

</body>
</html>
