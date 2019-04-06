$( document ).ready(function() {
	
    console.log( "Pagina Lista!!" );
    
});


$("#BtnIngresar").click(function(){
	
	var datos = $("#FormLogin").serialize();
//	$.blockUI({ message: '<h2>Validando....................</h2>' });
	$.post("LogonIngresar.htm", datos, function(respuesta){

//		 $.unblockUI();
		 

		 if(respuesta=='OK'){
			 
			 swal({
				  title: "Informacion!",
				  text: "Ingreso Correcto!",
				  icon: "success",
				   timer: 1900
				});
			 
			 
			 window.location ="Principal.htm";
			 
		 }else{
			 
			 swal({
				  title: "Error!",
				  text: "Valide usuario y clave",
				  icon: "error"
				});
			 

			 
		 }
	
		
	});
});



