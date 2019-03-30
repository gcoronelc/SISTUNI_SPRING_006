$( document ).ready(function() {
	
    console.log( "Pagina Lista!!" );
    
});


$("#BtnConsultar").click(function(){
	
	var datos = $("#FormCriterio").serialize();
	$.blockUI();
	$.get("ConsultarClientesResp1.htm", datos, function(respuesta){
		$.unblockUI();
		var arreglo = jQuery.parseJSON(respuesta);
		if( arreglo.length == 0 ){
			$("#DivMensaje").html("No hay datos.");
			$("#DivMensaje").show();
			$("#DivTablaResultado").hide();
			return;
		}
		// Limpar datos
		$("#TablaDatos").empty();
		var fila = "";
		$.each( arreglo, function( key, value ) {
			fila = "<tr>";
			fila += "<td>" + value.CODIGO + "</td>";
			fila += "<td>" + value.PATERNO + "</td>";
			fila += "<td>" + value.MATERNO + "</td>";
			fila += "<td>" + value.NOMBRE + "</td>";
			fila += "</tr>";
			$("#TablaDatos").append(fila);
		});
		$("#DivMensaje").hide();
		$("#DivTablaResultado").show();
	});
});

