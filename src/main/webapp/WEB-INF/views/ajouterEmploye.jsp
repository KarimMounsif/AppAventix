<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="resources/CSS/bootstrap/css_Old/bootstrap.css" rel="stylesheet">
 <link href="resources/CSS/monCSS/nav.css" rel="stylesheet">
 <link href="resources/CSS/monCSS/checkboxes.css" rel="stylesheet">
<!--     Fonts and icons    -->
<link href="resources/FONT/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/CSS/bootstrap/css_Old/bootstrap-datepicker.css" rel="stylesheet">


<title>home</title>

 <style type="text/css">

.centered-form{
	margin-top: 10px;
}

.centered-form .panel{
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}

.btn span.glyphicon {    			
	opacity: 0;				
}
.btn.active span.glyphicon {				
	opacity: 1;				
}

input.invalid, textarea.invalid{
	border: 2px solid red;
}

input.valid, textarea.valid{
	border: 2px solid green;
}

.error{
color:red;
}

 </style>
</head>
<body>

<%@include file="navbar.jsp" %>

<div class="container">
        <div class="row centered-form">
        <div class="col-sm-8 col-md-offset-2">
        	<div class="panel panel-danger">
        	<strong style="color:red;">
			<form:errors path="*" cssClass="error"/><br>
			
	  	</strong>
        		<div class="panel-heading">
			    		<h3 class="panel-title" align="middle">Fiche d'ajout d'un Employé</h3>
			 			</div>
		 				<div class="panel-body">
							<form:form id="ajouterEmploye-form" action="ajouterEmploye" method ="post" commandName="employeForm" enctype="multipart/form-data">
							
							<form:errors path="*" cssClass="error"/><br>
							
								<div class="form-group">
									<label for="civilite">Civilité :<span class="req">* </span></label>
									<form:select name="civiliteEmploye" id="civiliteEmploye"  class="form-control"  path="e.civiliteEmploye" items="${civiliteList}" required="required"/>
									   
							    </div> 
							    
							    <div class="form-group">
							    	<label for="ddn">Date de Naissance :<span class="req">* </span></label>
							       <form:input size="16" type="text" path="e.ddnEmploye" name="ddnEmploye" id="ddnEmploye"  class="form-control form_datetime" readonly="readonly" required="required"/>    
							    </div> 
							    
							    <div class="form-group">
							    	<label for="nom">Nom :<span class="req">* </span></label>
							        	   
							    		 <form:input type="text" class="form-control" path="e.nomEmploye" name="nomEmploye" id="nomEmploye" placeholder="OUHALIMA" required="required"/>
							    </div> 
							    
							    <div class="form-group">
							    	<label for="prenom">Prénom :<span class="req">* </span></label>
							        	    
							    		 <form:input type="text" class="form-control" path="e.prenomEmploye" name="prenomEmploye" id="prenomEmploye" placeholder="Mohamed" required="required"/>
							    </div> 
							    
							    <div class="form-group">
							    	<label for="mailEmploye">Email :<span class="req">* </span></label>
							    	
							        	<form:input type="text" path="e.mailEmploye" name="mailEmploye" id="mailEmploye"  class="form-control" placeholder="Mohamed.ouhalima@insa-lyon.fr" required="required"/>    
							    </div> 
							    <div class="form-group">
							    	<label for="mailEmployeConf">Confirmation Email :<span class="req">* </span></label>
							    	
							        	<input type="text" path="" name="mailEmployeConf" id="mailEmployeConf"  class="form-control" placeholder="Mohamed.ouhalima@insa-lyon.fr" required="required"/>    
							    </div> 
							    <div class="input-group">
							    
							    	<label for="telEmploye">Tel : <span class="req">* </span></label>
							    	</div>
							    	<div class="input-group">
										<span class="input-group-addon">(+33)</span>
									<form:input size="20" type="text" class="form-control" path="e.telEmploye" name="telEmploye" id="telEmploye" placeholder="76473829" aria-describedby="inputGroupSuccess1Status"/>
							  	</div>
							  	<br>
							  	
							  	<c:if test="${QRdisponible>0}">
							  	

                            
                            
							  		<label class="btn btn-danger"> Assigner QRCode 
										<form:checkbox path="assignQR" name="assignQR" id="assignQR" autocomplete="off"/>
									</label>
							  	</c:if>
							  	<br>
							  	<br>
							    <!-- 
							    TODO
							    Ajouter un bouton si il y a des QR codes dispos pour proposer d'assigner un QR code directement
							     -->
							    <ul class="list-inline pull-right">
							    <form:input type="submit" path="" class="btn btn-primary btn-lg bVal" value="Soumettre" disabled="disabled"/>
							    </ul>
							</form:form>
					</div>
	    		</div>
    		</div>
    	</div>
    </div>

<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>


<script src="resources/JS/monJS/datepicker.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap-datepicker.js"></script>
<script src="resources/JS/monJS/formAjoutEmployeValidatorAE.js"></script>

<script type="text/javascript">
$(".form_datetime").datepicker({
    format: "yyyy-mm-dd"
});
</script>
</body>
</html>