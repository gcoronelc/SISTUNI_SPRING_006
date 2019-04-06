$( document ).ready(function() {
	
    console.log( "Pagina Lista!!" );
    
});



$("#BtnConsultar").click(function(){
	
	var datos = $("#FormCriterio").serialize();
	$.blockUI();
	$.get("ConsultarProductosResp1.htm", datos, function(respuesta){
		$.unblockUI();
		
		if( respuesta.length == 0 ){
			$("#DivMensaje").html("No hay datos.");
			$("#DivMensaje").show();
			$("#DivTablaResultado").hide();
			return;
		}
		
		// Limpar datos
		var arreglo = $.parseJSON (respuesta);
		$("#TablaDatos").empty();
		var fila = "";
		for(var i = 0; i < arreglo.length; i++) {
			rec = arreglo[i];
			fila = "<tr>";
			fila += "<td>" + rec.codigo + "</td>";
			fila += "<td>" + rec.descripcion+ "</td>";
			fila += "<td>" + rec.precio + "</td>";
			fila += "<td>" + rec.stock + "</td>";
			fila += "</tr>";
			$("#TablaDatos").append(fila);
		};
		$("#DivMensaje").hide();
		$("#DivTablaResultado").show();
		
	});
});
