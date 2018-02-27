/**
 * 
 */


function commandeAjaxCall(){
	var $qte=parseInt(($('.spinner .btn').closest('.spinner').find('input')).val());
	$.ajax({
		url:"commandeQrcode",
		type:"POST",
		data: "qte="+$qte,
		//data: "qte="+$qte,
		beforeSend: function(xhr) {
	        // disable button passer commande,
			// Faire apparaitre le spinner dans un modal
	       
	        $("#buttonAjaxCall").addClass('desactive');
	        $("#loaderDiv").addClass('active');


	    },
	    success: function(jsr) {
	        if (jsr.validated) {
	         // Tout s'est bien passé
	        	$("#buttonAjaxCall").addClass('active');
	        	$("#loaderDiv").addClass('desactive');
	        	$("#mesgSuccess").addClass('active');
	        } else {
	          // il y a eu un souci
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
	    		
	    },
		
	    dataType: "text"
		
		
	});
}