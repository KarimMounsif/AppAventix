/**
 * Step 2
 */


$(document).ready(function() {
	var $valStep2=[0,0,0,0,0,0,0,0,0,0,0,0];
	var i;
	var intRegex = /^\d+$/;
	var siretRegex=/^\d{14}$/;
	var mailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	var phoneRegex=/^\d{9}$/;
	var ribRegex=/^\d{22}$/;
	// siret Entreprise checking 
	$('#siretEntreprise').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(siretRegex.test(is_name)){
			input.removeClass("invalid").addClass("valid");
			$valStep2[0] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep2[0] = 0;
		}
		
		for (i = 0; i < $valStep2.length; i++) {
		    res += $valStep2[i];
		}
		
		if (res < 10) {

			$('.bstp3').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp3').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});
	
	//nom Entreprise checking
	$('#nomEntreprise').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(is_name){
			input.removeClass("invalid").addClass("valid");
			$valStep2[1] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep2[1] = 0;
		}
		
		for (i = 0; i < $valStep2.length; i++) {
		    res += $valStep2[i];
		}
		
		if (res < 10) {

			$('.bstp3').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp3').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});
	
	//nom Entreprise checking
	$('#nomService').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(is_name){
			input.removeClass("invalid").addClass("valid");
			$valStep2[1] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep2[1] = 0;
		}
		
		for (i = 0; i < $valStep2.length; i++) {
		    res += $valStep2[i];
		}
		
		if (res < 10) {

			//$('.bstp3').prop('disabled',true);
	       return false;
	    }else{
	    		
	    		//$('.bstp3').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});
	
	// Adresse Entreprise checking
	$('#adresseEntreprise').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(is_name){
			input.removeClass("invalid").addClass("valid");
			$valStep2[2] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep2[2] = 0;
		}
		
		for (i = 0; i < $valStep2.length; i++) {
		    res += $valStep2[i];
		}
		
		if (res < 10) {

			$('.bstp3').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp3').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});
	
	
	// codePostalEntreprise checking
	$('#codePostalEntreprise').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(intRegex.test(is_name)){
			input.removeClass("invalid").addClass("valid");
			$valStep2[3] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep2[3] = 0;
		}
		
		for (i = 0; i < $valStep2.length; i++) {
		    res += $valStep2[i];
		}
		
		if (res < 10) {

			$('.bstp3').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp3').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});
	
	
	// villeEntreprise checking
	$('#villeEntreprise').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(is_name){
			input.removeClass("invalid").addClass("valid");
			$valStep2[4] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep2[4] = 0;
		}
		
		for (i = 0; i < $valStep2.length; i++) {
		    res += $valStep2[i];
		}
		
		if (res < 10) {
	      
			$('.bstp3').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp3').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	
	
	// mailEntreprise checking
	$('#mailEntreprise').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(mailRegex.test(is_name)){
			input.removeClass("invalid").addClass("valid");
			$valStep2[5] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep2[5] = 0;
		}
		
		for (i = 0; i < $valStep2.length; i++) {
		    res += $valStep2[i];
		}
		
		if (res < 10) {
	     
			$('.bstp3').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp3').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	
	
	// mailEntrepriseConf
	$('#mailEntrepriseConf').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(mailRegex.test(is_name) && is_name==$('#mailEntreprise').val()){
			input.removeClass("invalid").addClass("valid");
			$valStep2[6] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep2[6] = 0;
		}
		
		for (i = 0; i < $valStep2.length; i++) {
		    res += $valStep2[i];
		}
		
		if (res < 10) {

			$('.bstp3').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp3').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	
	// ribEntreprise checking 
	$('#ribEntreprise').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(ribRegex.test(is_name)){
			input.removeClass("invalid").addClass("valid");
			$valStep2[7] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep2[7] = 0;
		}
		
		for (i = 0; i < $valStep2.length; i++) {
		    res += $valStep2[i];
		}
		
		if (res < 10) {

			$('.bstp3').prop('disabled',true);
	        return false;
	    }else{

	    		$('.bstp3').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	
	// telEntreprise checking 
	$('#telEntreprise').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(phoneRegex.test(is_name)){
			input.removeClass("invalid").addClass("valid");
			$valStep2[8] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep2[8] = 0;
		}
		
		for (i = 0; i < $valStep2.length; i++) {
		    res += $valStep2[i];
		}
		
		if (res < 10) {

			$('.bstp3').prop('disabled',true);
	        return false;
	    }else{

	    		$('.bstp3').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	
	// capitalSocial checking 
	$('#capitalSocialEntreprise').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(intRegex.test(is_name)){
			input.removeClass("invalid").addClass("valid");
			$valStep2[9] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep2[9] = 0;
		}
		
		for (i = 0; i < $valStep2.length; i++) {
		    res += $valStep2[i];
		}
		
		if (res < 10) {

			$('.bstp3').prop('disabled',true);
	        return false;
	    }else{

	    		$('.bstp3').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	
	
	// effectif Entreprise checking 
	$('#effectifEntreprise').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(intRegex.test(is_name)){
			input.removeClass("invalid").addClass("valid");
			$valStep2[10] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep2[10] = 0;
		}
		
		for (i = 0; i < $valStep2.length; i++) {
		    res += $valStep2[i];
		}
		
		if (res < 10) {

			$('.bstp3').prop('disabled',true);
	        return false;
	    }else{

	    		$('.bstp3').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	 
});