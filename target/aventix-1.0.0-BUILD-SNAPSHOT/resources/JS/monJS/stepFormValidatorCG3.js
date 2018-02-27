/**
 * Step 3
 */


$(document).ready(function() {
	var $valStep3=[0,0,0,0,0,0,0,0,0,0,0,0];
	var i;
	
	// file input 1
	$('#uploadFile1').change('input', function() {
		var input=$(this);
		var res=0;
		$valStep3[0] = 1;
		
		for (i = 0; i < $valStep3.length; i++) {
		    res += $valStep3[i];
		}
		
		if (res < 2) {

			$('.bstp4').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp4').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});
	// file input 2
	$('#uploadFile2').change('input', function() {
		var input=$(this);
		var res=0;
		$valStep3[1] = 1;
		
		for (i = 0; i < $valStep3.length; i++) {
		    res += $valStep3[i];
		}
		
		if (res < 2) {

			$('.bstp4').prop('disabled',true);
	        return false;
	    }else{
	    		
	    		$('.bstp4').prop('disabled',false);
	    		//alert('We good !!!');
	    		return true;
	    		
	    }
	});

});