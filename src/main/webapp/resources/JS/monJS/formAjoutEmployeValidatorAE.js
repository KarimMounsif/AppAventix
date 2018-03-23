/**
 * Step 1
 */


$(document).ready(function() {
	var $valStep1=[0,0,0,0,0,0,0,0,0,0,0,0];
	var i;
	var intRegex = /^\d+$/;
	var phoneRegex=/^\d{9}$/;
	var mailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	$('.bVal').prop('disabled',true);
	
	// nom Gerant checking 
	$('#nomEmploye').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(is_name){
			input.removeClass("invalid").addClass("valid");
			$valStep1[0] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep1[0] = 0;
		}
		
		for (i = 0; i < $valStep1.length; i++) {
		    res += $valStep1[i];
		}
		
		if (res < 5) {

			$('.bVal').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bVal').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});
	
	//prenom Gerant checking
	$('#prenomEmploye').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(is_name){
			input.removeClass("invalid").addClass("valid");
			$valStep1[1] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep1[1] = 0;
		}
		
		for (i = 0; i < $valStep1.length; i++) {
		    res += $valStep1[i];
		}
		
		if (res < 5) {

			$('.bVal').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bVal').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});
	
		
	// Mail Gerant checking
	$('#mailEmploye').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(mailRegex.test(is_name)){
			input.removeClass("invalid").addClass("valid");
			$valStep1[2] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep1[2] = 0;
		}
		
		for (i = 0; i < $valStep1.length; i++) {
		    res += $valStep1[i];
		}
		
		if (res < 5) {
	     
			$('.bVal').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bVal').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	
	
	// Mail Gerant checking
	$('#mailEmployeConf').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(mailRegex.test(is_name) && is_name==$('#mailEmploye').val()){
			input.removeClass("invalid").addClass("valid");
			$valStep1[3] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep1[3] = 0;
		}
		
		for (i = 0; i < $valStep1.length; i++) {
		    res += $valStep1[i];
		}
		
		if (res < 5) {

			$('.bVal').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bVal').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	
	
	
	 
	
	// tel Gerant checking 
	$('#telEmploye').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(phoneRegex.test(is_name)){
			input.removeClass("invalid").addClass("valid");
			$valStep1[4] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep1[4] = 0;
		}
		
		for (i = 0; i < $valStep1.length; i++) {
		    res += $valStep1[i];
		}
		
		if (res < 5) {

			$('.bVal').prop('disabled',true);
	        return false;
	    }else{

	    		$('.bVal').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	 
});