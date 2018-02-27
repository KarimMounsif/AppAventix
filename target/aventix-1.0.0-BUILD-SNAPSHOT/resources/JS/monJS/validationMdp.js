/**
 * SCRIPT DE VALIDATION DE MOT PASSE (PREMIERE CONNEXION)
 */

$(document).ready(function() {
	var $valMdp=[0,0];
	var i;
	var intRegex = /^\d+$/;
	var mdpRegex = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$}/;
	var mdpRegex1 =/^[A-Za-z0-9\d=!\-@._*]*$/;
	var mdpRegex2= /[a-z]/;
	var mdpRegex3= /\d/;
	// nouveau mdp checking 
	$('#mdp').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(mdpRegex1.test(is_name) && mdpRegex2.test(is_name) && mdpRegex3.test(is_name)){
			input.removeClass("invalid").addClass("valid");
			
			$valMdp[0] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valMdp[0] = 0;
		}
		
		for (i = 0; i < $valMdp.length; i++) {
		    res += $valMdp[i];
		}
		
		if (res < 2) {
			//alert(is_name)
			$('.bMdp').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bMdp').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});
	
	
	// nouveau mdp conf checking 
	$('#mdpConf').keyup('input', function() {
		var input=$(this);
		var is_name=input.val();
		var res=0;
		if(is_name==$('#mdp').val()){
			input.removeClass("invalid").addClass("valid");
			$valMdp[1] = 1;
		}else{
			input.removeClass("valid").addClass("invalid");
			$valMdp[1] = 0;
		}
		
		for (i = 0; i < $valMdp.length; i++) {
		    res += $valMdp[i];
		}
		
		if (res < 2) {

			$('.bMdp').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bMdp').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});
});