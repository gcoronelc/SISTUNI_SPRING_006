


$("#BtnConsultar").click(function(){
	
	var datos = $("#FormCriterio").serialize();
	$.blockUI();
	$.get("ConsultarClientesResp3.htm", datos, function(respuesta){
		$.unblockUI();
		
		if( respuesta.length == 0 ){
			$("#DivMensaje").html("no existen datos!");
			$("#DivMensaje").show();
			$("#DivTablaResultado").hide();
			return;
		}
		
		// Limpar datos
		var arreglo = respuesta.split("¬");
		$("#TablaDatos").empty();
		var fila = "";
		for(var i = 1; i < arreglo.length; i++) {
			rec = arreglo[i].split("|");
			fila = "<tr>";
			fila += "<td>" + rec[0] + "</td>";
			fila += "<td>" + rec[1] + "</td>";
			fila += "<td>" + rec[2] + "</td>";
			fila += "<td>" + rec[3] + "</td>";
			fila += "</tr>";
			$("#TablaDatos").append(fila);
		};
		$("#DivMensaje").hide();
		$("#DivTablaResultado").show();
		
	});
});

$( document ).ready(function() {
	
    console.log( "Page Ready!!" );
    
});

