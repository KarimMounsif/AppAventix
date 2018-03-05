/**
 * 
 */


function commandeAjaxCall(){
	var $qte=parseInt(($('.spinner .btn').closest('.spinner').find('input')).val());
	$.ajax({
		url:"commandeQrcode",
		type:"POST",
		data: "qte="+$qte,
		beforeSend: function(xhr) {
			$("#buttonAjaxCall").removeClass('active');
	        $("#buttonAjaxCall").addClass('desactive');
	        $("#loaderDiv").removeClass('desactive');
	        $("#loaderDiv").addClass('active');
	    },
	    success: function(jsr) {
	    	var jsrO=JSON.parse(jsr);
	        if (jsrO.validated) {
	         // Tout s'est bien passé
				$("#buttonAjaxCall").removeClass('desactive');
		        $("#buttonAjaxCall").addClass('active');
		        $("#loaderDiv").removeClass('active');
		        $("#loaderDiv").addClass('desactive');
		        $("#mesgSuccess").addClass('active');
		        alert("Message ==> "+jsrO.successMessages.msg)
	        } else {
	          // il y a eu un souci
	        	alert("Bravo ==> "+jsrO.successMessages)
	        	$("#mesgError").addClass('active');
	        }
	    },
	    error: function(xhr) { 
	    	// if error occured
	        alert("Error occured.please try again ==>"+xhr.responseText);
	        
	        // Afficher msg error
	    },
	    complete: function() {
	       //Fin du traitement; 
	       //desactiver le modal
			$("#buttonAjaxCall").removeClass('desactive');
	        $("#buttonAjaxCall").addClass('active');
	        $("#loaderDiv").removeClass('active');
	        $("#loaderDiv").addClass('desactive');
	    },
		
	    dataType: "text"
		
		
	});
}