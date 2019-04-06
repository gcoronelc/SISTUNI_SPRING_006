<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="table-responsive">
			<table id="listAlumnos" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
				<thead class="thead-inverse">
					<tr>
						<th>ID</th>
						<th>NOMBRES</th>
						<th>APE. PATERNO</th>
						<th>APE. MATERNO</th>
						<th>DNI</th>
						<th>SEXO</th>
						<th>ACCIONES</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${results}" var="a">
						<tr>
							<td>${a.idAlumno}</td>
							<td>${a.nombres}</td>
							<td>${a.apePaterno}</td>
							<td>${a.apeMaterno}</td>
							<td>${a.dni}</td>
							<td>${a.sexo=='1'?'Hombre':'Mujer'}</td>
							<td><a class="btn btn-primary btn-xs" href="/intranet/edit?id=${a.idAlumno}"> <i class="fa fa-edit"></i> &nbsp;Editar</a>
							<a class="btn btn-primary btn-xs" onclick="eliminar(${a.idAlumno})"> <i class="fa fa-edit"></i> &nbsp;Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script>
	$(document).ready(function(){
		initDataTable("listAlumnos")
	})
	
	function eliminar(id){
		
		$("#messages").html("<h4>!Eliminado usuario .... !</h4>")
		
		$.get("delete", "&id="+id, function(respuesta){
			$("#messages").html("<h3>!"+respuesta+"!</h3>")
			
			setTimeout(function(){
				$("#searchBtn").click()
				$("#messages").empty()	
			},1500)
		})
	}
</script>