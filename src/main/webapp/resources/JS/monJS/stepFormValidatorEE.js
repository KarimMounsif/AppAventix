/**
 * Step 1
 */


$(document).ready(function() {
	var $valStep1=[0,0,0,0,0,0,0,0,0,0,0,0];
	var i;
	var intRegex = /^\d+$/;
	var phoneRegex=/^\d{9}$/;
	var mailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	
	// nom Employe checking 
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

			$('.bstp2').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp2').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});
	
	//prenom Employe checking
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

			$('.bstp2').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp2').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});
	
	
	// Mail Employe checking
	$('#mailEmploye').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(mailRegex.test(is_name)){
			input.removeClass("invalid").addClass("valid");
			$valStep1[5] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep1[5] = 0;
		}
		
		for (i = 0; i < $valStep1.length; i++) {
		    res += $valStep1[i];
		}
		
		if (res < 5) {
	     
			$('.bstp2').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp2').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	
	
	// Mail Employe checking
	$('#mailEmployeConf').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(mailRegex.test(is_name) && is_name==$('#mailEmploye').val()){
			input.removeClass("invalid").addClass("valid");
			$valStep1[6] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep1[6] = 0;
		}
		
		for (i = 0; i < $valStep1.length; i++) {
		    res += $valStep1[i];
		}
		
		if (res < 5) {

			$('.bstp2').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp2').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	
	
	
	 
	
	// tel Employe checking 
	$('#telEmploye').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(phoneRegex.test(is_name)){
			input.removeClass("invalid").addClass("valid");
			$valStep1[8] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valStep1[8] = 0;
		}
		
		for (i = 0; i < $valStep1.length; i++) {
		    res += $valStep1[i];
		}
		
		if (res < 5) {

			$('.bstp2').prop('disabled',true);
	        return false;
	    }else{

	    		$('.bstp2').prop('disabled',false);
	    		return true;
	    		
	    }
	});
	 
});