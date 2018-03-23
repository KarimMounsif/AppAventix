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


 </style>
</head>
<body>

<%@include file="navbar.jsp" %>

<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title" align="middle">Création employé</h3>
			 			</div>
		 				<div class="panel-body">
							<form:form id="modifierEmploye-form" action="modifierEmploye" method ="post" commandName="emp" enctype="multipart/form-data">
							
							<form:errors path="*" cssClass="error"/><br>
							
								<div class="form-group">
                     				<form:select name="civiliteEmploye" id="civiliteEmploye"  class="form-control"  path="civiliteEmploye" items="${civilite}" required="required"/>
        						</div>
							    
							    <div class="form-group">
							    	<label for="ddn">Date de Naissance :<span class="req">* </span></label>
							        	<form:input size="16" type="text" path="ddnEmploye" name="ddnEmploye" id="ddnEmploye"  class="form-control form_datetime" readonly="readonly" required="required" value="${emp.ddnEmploye}"/>    
							    </div> 
							    
							    <div class="form-group">
							    	<label for="nom">Nom :<span class="req">* </span></label>
							        	<form:input size="16" type="text" path="nomEmploye" name="nomEmploye" id="nomEmploye"  class="form-control form_datetime" readonly="readonly" required="required" value="${emp.nomEmploye}"/>    
							    </div> 
							    
							    <div class="form-group">
							    	<label for="prenom">Prénom :<span class="req">* </span></label>
							        	<form:input size="16" type="text" path="prenomEmploye" name="prenomEmploye" id="prenomEmploye"  class="form-control form_datetime" readonly="readonly" required="required" value="${emp.prenomEmploye}"/>    
							    </div> 
							    
							    <div class="form-group">
							    	<label for="mailEmploye">Email :<span class="req">* </span></label>
							        	<form:input size="16" type="text" path="mailEmploye" name="mailEmploye" id="mailEmploye"  class="form-control form_datetime" readonly="readonly" required="required" value="${emp.mailEmploye}"/>    
							    </div> 
							    
							    <div class="input-group">
							    	<label for="telEmploye">Tel : <span class="req">* </span></label>
							    	</div>
							    	<div class="input-group">
										<span class="input-group-addon">(+33)</span>
									<form:input size="20" type="text" class="form-control" path="telEmploye" name="telEmploye" id="telEmploye" placeholder="76473829" aria-describedby="inputGroupSuccess1Status" value="${emp.telEmploye}"/>
							  	</div>
							  	<br>
							  	
							  	<br>
							  	<br>
							    <input type="hidden" name="idEmploye" value="${emp.idEmploye}"/>
							    <form:input type="submit" path="" class="btn btn-primary btn-lg" value="Soumettre" disabled="disabled"/>
							</form:form>
					</div>
	    		</div>
    		</div>
    	</div>
    </div>
<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>

</body>
</html>