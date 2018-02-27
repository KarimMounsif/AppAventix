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
	// siret Commerce checking 
	$('#siretCommerce').keyup('input', function() {
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
	
	//nom Commerce checking
	$('#nomCommerce').keyup('input', function() {
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
	
	// Adresse Commerce checking
	$('#adresseCommerce').keyup('input', function() {
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
	
	
	// codePostalCommerce checking
	$('#codePostalCommerce').keyup('input', function() {
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
	
	
	// villeCommerce checking
	$('#villeCommerce').keyup('input', function() {
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
	
	
	// mailCommerce checking
	$('#mailCommerce').keyup('input', function() {
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
	
	
	// mailCommerceConf
	$('#mailCommerceConf').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(mailRegex.test(is_name) && is_name==$('#mailGerant').val()){
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
	
	// ribCommerce checking 
	$('#ribCommerce').keyup('input', function() {
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
	
	// telCommerce checking 
	$('#telCommerce').keyup('input', function() {
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
	$('#capitalSocialCommerce').keyup('input', function() {
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
	
	
	// effectif commerce checking 
	$('#effectifCommerce').keyup('input', function() {
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