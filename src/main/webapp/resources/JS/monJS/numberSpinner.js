/**
 * 
 */

$(function(){

    $('.spinner .btn:first-of-type').on('click', function() {
      var btn = $(this);
      var reduc;
      var p;
      var input = btn.closest('.spinner').find('input');
      if (input.attr('max') == undefined || parseInt(input.val()) < parseInt(input.attr('max'))) {    
        input.val(parseInt(input.val(), 10) + 1);
        p=parseFloat(parseFloat(input.val()).toFixed(2)*parseFloat((9.99).toFixed(2))).toFixed(2);
        $('#prixCommande1').html(p);
        $('#prixCommande2').html(p);
        if(parseInt(input.val())< 10){
	    	   $('#prctReduc').html(parseInt(0));
	    	   reduc=parseFloat(0).toFixed(2);
	    	   $('#prixFinalCommande').html(parseFloat(p-((p*reduc)/100)).toFixed(2));
	       }else if(parseInt(input.val())< 50){
	    	   $('#prctReduc').html(parseInt(10));
	    	   reduc=parseInt(10);
	    	   $('#prixFinalCommande').html(parseFloat(p-((p*reduc)/100)).toFixed(2));
	       }else if(parseInt(input.val())< 100){
	    	   $('#prctReduc').html(parseInt(20));
	    	   reduc=parseInt(20);
	    	   $('#prixFinalCommande').html(parseFloat(p-((p*reduc)/100)).toFixed(2));
	       }else{
	    	   $('#prctReduc').html(parseInt(30));
	    	   reduc=parseInt(30);
	    	   $('#prixFinalCommande').html(parseFloat(p-((p*reduc)/100)).toFixed(2));
	       }
   
      } else {
        btn.next("disabled", true);
      }
    });
    
    $('.spinner .btn:last-of-type').on('click', function() {
      var btn = $(this);
      var reduc;
      var p;
      var input = btn.closest('.spinner').find('input');
      if (input.attr('min') == undefined || parseInt(input.val()) > parseInt(input.attr('min'))) {    
        input.val(parseInt(input.val(), 10) - 1);
        p=parseFloat(parseFloat(input.val()).toFixed(2)*parseFloat((9.99).toFixed(2))).toFixed(2);
        $('#prixCommande1').html(p);
        $('#prixCommande2').html(p);
        if(parseInt(input.val())< 10){
	    	   $('#prctReduc').html(parseInt(0));
	    	   reduc=parseFloat(0).toFixed(2);
	    	   $('#prixFinalCommande').html(parseFloat(p-((p*reduc)/100)).toFixed(2));
	       }else if(parseInt(input.val())< 50){
	    	   $('#prctReduc').html(parseInt(10));
	    	   reduc=parseInt(10);
	    	   $('#prixFinalCommande').html(parseFloat(p-((p*reduc)/100)).toFixed(2));
	       }else if(parseInt(input.val())< 100){
	    	   $('#prctReduc').html(parseInt(20));
	    	   reduc=parseInt(20);
	    	   $('#prixFinalCommande').html(parseFloat(p-((p*reduc)/100)).toFixed(2));
	       }else{
	    	   $('#prctReduc').html(parseInt(30));
	    	   reduc=parseInt(30);
	    	   $('#prixFinalCommande').html(parseFloat(p-((p*reduc)/100)).toFixed(2));
	       }
      } else {
        btn.prev("disabled", true);
      }
    });
    
    

});


$(document).ready(function() {
	$($('.spinner .btn').closest('.spinner').find('input')).on('input',function(){
		   
	       var input =$(this);
	       var reduc;
	       var p;
	       
	      /* if(parseInt(input.val())< 10){
	    	   $('#prctReduc').html(parseInt(0));
	       }else if(parseInt(input.val())< 50){
	    	   $('#prctReduc').html(parseInt(10));
	       }else if(parseInt(input.val())< 100){
	    	   $('#prctReduc').html(parseInt(20));
	       }else{
	    	   $('#prctReduc').html(parseInt(30));
	       }*/
	       
	       p=parseFloat(parseFloat(input.val()).toFixed(2)*parseFloat((9.99).toFixed(2))).toFixed(2);
	        $('#prixCommande1').html(p);
	        $('#prixCommande2').html(p);
	        if(parseInt(input.val())< 10){
		    	   $('#prctReduc').html(parseInt(0));
		    	   reduc=parseFloat(0).toFixed(2);
		    	   $('#prixFinalCommande').html(parseFloat(p-((p*reduc)/100)).toFixed(2));
		       }else if(parseInt(input.val())< 50){
		    	   $('#prctReduc').html(parseInt(10));
		    	   reduc=parseInt(10);
		    	   $('#prixFinalCommande').html(parseFloat(p-((p*reduc)/100)).toFixed(2));
		       }else if(parseInt(input.val())< 100){
		    	   $('#prctReduc').html(parseInt(20));
		    	   reduc=parseInt(20);
		    	   $('#prixFinalCommande').html(parseFloat(p-((p*reduc)/100)).toFixed(2));
		       }else{
		    	   $('#prctReduc').html(parseInt(30));
		    	   reduc=parseInt(30);
		    	   $('#prixFinalCommande').html(parseFloat(p-((p*reduc)/100)).toFixed(2));
		       }
	     
	    });
});

