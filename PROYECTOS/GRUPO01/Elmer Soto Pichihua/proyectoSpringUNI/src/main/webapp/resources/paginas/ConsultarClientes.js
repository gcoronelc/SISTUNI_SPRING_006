$( document ).ready(function() {
	
    console.log( "Pagina Lista!!" );
    
});


$("#BtnConsultar").click(function(){
	
	var datos = $("#FormCriterio").serialize();
	
	$("#divCliente").hide();
	$.blockUI({ message: '<h2>Procesando....................</h2>' });
	$.get("ConsultarClientesResp.htm", datos, function(respuesta){
	
		
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
			fila += "<td>" + value.codigo + "</td>";
			fila += "<td>" + value.paterno + "</td>";
			fila += "<td>" + value.materno + "</td>";
			fila += "<td>" + value.nombre + "</td>";
			fila += "</tr>";
			 
			$("#TablaDatos").append(fila);
		});
		
		
		$("#DivMensaje").hide();
		$("#DivTablaResultado").show();
		
	});
});


$("#BtnProcesar").click(function(){

	var datos = $("#FormCliente").serialize();
	
	$.post("RegistrarClientes.htm", datos, function(respuesta){
		
		if(respuesta=='OK'){
			
			swal("Correcto!", "El registros fue satisfactorio!", "success");
			
			$("#codigo1").val("");
			$("#paterno").val("");
			$("#materno1").val("");
			$("#nombre1").val("");
			$("#dni1").val("");
			$("#ciudad1").val("");
			$("#direccion1").val("");
			$("#telefono1").val("");
			$("#email1").val("");
			
			$("#divCliente").hide();
		}else{
			
			swal("Error!", respuesta, "error");
		}
		
		
	});
});




$("#BtnNuevoCliente").click(function (e) {
    var $this = $(this);
    if ($this.hasClass('clicked')){
    	$("#divCliente").hide();
        //here is your code for double click
        return;
    }else{
         $this.addClass('clicked');
     	$("#divCliente").show();
     	$("#DivTablaResultado").hide();
        //your code for single click
         setTimeout(function() { 
                 $this.removeClass('clicked'); },500);
    }//end of else
});


