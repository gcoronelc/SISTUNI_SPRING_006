var _URL = window.URL || window.webkitURL;

$(document).ready(function() {
	
	changePageAndSize();
	
	$("input.digits").keypress(function(e){
		return onlyNumbers(e)
	})
	
	initUploadLogo()
	
	customizeErrorMessagesValidation()
	
	// fire change events for flat checkboxes and radios
	$('.flat').on('ifChanged', function(event){
	    $(event.target).change()
	});
});

function resetUploadFile(){
	$("#fileUpload").val(null)
	$("#file-preview-zone").find("img").attr("src", "/images/image.png")
}

function validateUploadLogo(e, callback){
	
	$("#uploadLogoError").empty()
	$("#uploadLogoError").hide()
    
	var file, img;
	var isValid = true
    
	if(e.target.files.length==0){
		callback(isValid)
		return
	}
	
	if ((file = e.target.files[0])) {
		
    	var extesionsAllowed = $(e.target).attr("accept")
    	
    	if(extesionsAllowed){
    	
    		var extesionList = extesionsAllowed.split(",")
    		var extensionIsAllowed = false
    		$.each(extesionList, function(key, valueExtension){
    			if(file.type=="image/"+valueExtension.replace(".","")){
    				extensionIsAllowed = true
    				return false
    			}
    		})
    		if(!extensionIsAllowed){
    			$("#uploadLogoError").append('<label class="error col-md-12">Extension no permitida : '+file.type+'</label>')
    			isValid = false
    		}
    		
    	}
    	
    	// validate size kb:
    	
    	var totalBytes = file.size
    	var totalInKB = Math.floor(totalBytes/1000)
    	var sizeKBAllowed = $(e.target).attr("sizekb")
    	
    	if(sizeKBAllowed){
    		sizeKBAllowed = parseFloat(sizeKBAllowed)
    		if(totalInKB>sizeKBAllowed){
    			$("#uploadLogoError").append('<label class="error col-md-12">Solo se permiten subir imagenes que no excedan de '+sizeKBAllowed+' kb</label>')
    			isValid = false
    		}	    		
    	}
    	
    	if(file.type.includes("image/")){
    		img = new Image();
            img.onload = function () {
                
            	var imageHeight = img.height
                var imageWidth = img.width
                
                var width = $(e.target).attr("width")
                var height = $(e.target).attr("height")
                
                if(width){
                	width = parseInt(width)
                	if(imageWidth>width){
                		$("#uploadLogoError").append('<label class="error col-md-12">El ancho de la imagen, excede del permitido ('+imageWidth+' px) </label>')
                		isValid = false
                	}	            	
                }
            	if(height){
            		height = parseInt(height)
            		if(imageHeight>height){
                		$("#uploadLogoError").append('<label class="error col-md-12">El alto de la imagen excede del permitido ('+imageHeight+' px)</label>')
                		isValid = false
                	}
            	}
            	$("#uploadLogoError").show()
            	callback(isValid)
        		return
            
            }
            img.src = _URL.createObjectURL(file)    		
    	}else{
    		$("#uploadLogoError").show()
        	callback(isValid)
    		return
    	}
    }
}

function initUploadLogo(){	
	
	$("#fileUpload").click(readFile)
	
	$("#fileUpload").change(function (e) {
		validateUploadLogo(e, function(isValid){
			if(isValid){				
				readFile(e.target);
			}else{
				// reset value
				resetUploadFile()
			}
		})
	});
}

function customizeErrorMessagesValidation(){
	jQuery.extend(jQuery.validator.messages, {
	    required: "Este campo es requerido",
	    email: "Por favor ingresar un email valido",
	    digits: "Por favor ingresar solo digitos"	    
	});
}

function changePageAndSize() {
	$('#pageSizeSelect').change(function(evt) {		
		
		var form = $($(this).closest("div.right_col").find("form"))
		var url = $(this).attr("url") + "?pageSize=" + this.value + "&page=1"
		var dataForm = getFormData(form)
		ajaxSearchForm(dataForm, url)
	});
}

function showSpinner(idDiv){
	$("#"+idDiv).html('<div class="sk-spinner sk-spinner-three-bounce">'+
        '<div class="sk-bounce1"></div>'+
        '<div class="sk-bounce2"></div>'+
        '<div class="sk-bounce3"></div>'+
    '</div>')
}

function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

function initSearchForm(idForm, callback){
	
	// implement onclick event in submit button
	
	$("#"+idForm).find(":input[type=submit]").click(function(e){
		
		// prepare parameters to run ajax function
		
		var form = $($(this).closest("form"))
		var url = form.attr("action")
		var dataForm = getFormData(form)
		
		if(typeof callback == 'function'){
			callback(dataForm, url)
		}else{
			ajaxSearchForm(dataForm, url)
		}		
		e.preventDefault();
	})
	
	initPageLinks()
	changePageAndSize()
	
}

function ajaxSearchForm(dataForm, url){
	
	showSpinner("listSearch")
	
	$.ajax({
		url : url,
		type : "POST",		
		headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json'
	    },
		data : JSON.stringify(dataForm),
		success:function(responseText){
			$("#listSearch").html(responseText)
			initPageLinks()
			changePageAndSize()
		},
		error: function (e) {
			console.log("ERROR IN ajaxSearchForm: ", e);
	    }
	});
}

function initPageLinks(){
	$("a.pageLink").click(function(e){
		var url = $(this).attr("href")
		var form = $($(this).closest("div.right_col").find("form"))
		var dataForm = getFormData(form)
		ajaxSearchForm(dataForm, url)
		e.preventDefault();
	})
}

function convertToCSV(objArray) {
	
    var array = typeof objArray != 'object' ? JSON.parse(objArray) : objArray;
    var str = '';

    for (var i = 0; i < array.length; i++) {
        var line = '';
        for (var index in array[i]) {
            if (line != '') line += ','

            line += array[i][index];
        }

        str += line + '\r\n';
    }

    return str;
}

function exportCSVFile(headers, items, fileTitle) {
    
	if (headers) {
        items.unshift(headers);
    }

    // Convert Object to JSON
    var jsonObject = JSON.stringify(items);
    
    var csv = this.convertToCSV(jsonObject);

    var exportedFilenmae = fileTitle + '.csv' || 'export.csv';

    var blob = new Blob(["\ufeff", csv], { type: 'text/csv;charset=utf-8;'});
    if (navigator.msSaveBlob) { // IE 10+
        navigator.msSaveBlob(blob, exportedFilenmae);
    } else {
        var link = document.createElement("a");
        if (link.download !== undefined) { // feature detection
            // Browsers that support HTML5 download attribute
            var url = URL.createObjectURL(blob);
            link.setAttribute("href", url);
            link.setAttribute("download", exportedFilenmae);
            link.style.visibility = 'hidden';
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
        }
    }
}

function initDataTable(id){
	console.log('Initializing table with id ' + id);
	
	$("#"+id).DataTable({
        "searching": false,
        "paging": false,
        "pagingType": "simple",
        "info":     false,
        "lengthChange": false,
        "language": {
            "search": "Buscar:",
            "lengthMenu": "Visualizar _MENU_ por pag.",
            "zeroRecords": "No hay registros para mostrar",
            "info": "Pag _PAGE_ de _PAGES_",
            "infoEmpty": "No Disponible",
            "infoFiltered": "(Filtrado de _MAX_ registros)"
        },
        "order": [],
        "bSort": true,
        responsive: true
    });
}

function onlyNumbers(e){ // e = event
    try{
        //var key = window.Event ? e.which : e.keyCode
        var key = e.charCode || e.keyCode;
        if((key >= 48 && key <= 57) || (key==8)){
            return true;
        }
        return false;

    }catch(err){
        alert(err);
    }
}

function initValidateForm(id){
	
	// apply plugin in form
	 $("#"+id).validate()
	
	 // email format
	$("input.emailformat").each(function(){
		$(this).rules("add", { 
			email:true
		})
	}) 
	 
	 // digits only
	$("input.digits").each(function(){
		$(this).rules("add", { 
			digits:true
		})
	})
	
	// validate tabs
	$("#"+id).find("div.tabs-container").each(function(){
		$(this).find("ul.nav-tabs").find("a[data-toggle=tab]").each(function(){
			$(this).click(function(){
				return validateTab(this)
			})
		})
	})	
	 
}

function readFile(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            var filePreview = document.createElement('img');
            filePreview.id = 'file-preview';
            $(filePreview).addClass("img-preview")
//            filePreview.class ="img-preview";
            //e.target.result contents the base64 data from the image uploaded
            filePreview.src = e.target.result;
            console.log(e.target.result);

            var previewZone = document.getElementById('file-preview-zone');
            $(previewZone).html(filePreview)//appendChild(filePreview);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

function validateTab(element){
	
	var validate = true
	
	var tabActive = $(element).closest("ul.nav-tabs").find("li.active").find("a")	
	
	var id = $(tabActive).attr("href")
	
	$(id).find(":input").each(function(){		
		validate = $(this).valid()		
		if(!validate){
			$(this).focus()
			return false
		}		
	})
	
	return validate	
}
