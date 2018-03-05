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

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">CORE</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
         <li><a href="#"><span class="glyphicon glyphicon-th" aria-hidden="true"></span> Dashboard</a></li>
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Gestion du Personnel <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="/ajouterEmploye"/>"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp&nbspAjouter Employé</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-console" aria-hidden="true"></span>&nbsp Modifier Employé </a></li>
            <li><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>&nbsp Supprimer Employé</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>&nbsp Lister Employés</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#"><span class="glyphicon glyphicon-eur" aria-hidden="true"></span> Recharger Employé</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Gestion des QR codes <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#"><span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>&nbspCommander QR code</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> Assigner QR Code</a></li>
          </ul>
        </li>
      <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Gestion des transactions <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp &nbspLister les transactions</a></li>
          </ul>
      </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-link" aria-hidden="true"></span> Links<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="http://www.google.ch" target="_blank">My Webmail</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="http://www.google.ch" target="_blank">Timelogger</a></li>
            <li><a href="http://www.cubetech.ch" target="_blank">cubetech.ch</a></li>
         </ul>
        </li>
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Jack Bass<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="http://www.fgruber.ch/" target="_blank"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> User Settings</a></li>
            <li><a href="/logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Logout</a></li>
         </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title" align="middle">Création employé</h3>
			 			</div>
		 				<div class="panel-body">
							<form:form id="ajouterEmploye-form" action="ajouterEmploye" method ="post" commandName="employeForm" enctype="multipart/form-data">
							
							<form:errors path="*" cssClass="error"/><br>
							
								<div class="form-group">
									<label for="civilite">Civilité :<span class="req">* </span></label>
									<form:input size="16" type="text" path="civiliteEmploye" name="civiliteEmploye" id="civiliteEmploye"  class="form-control form_datetime" readonly="readonly" required="required"/>    
							    </div> 
							    
							    <div class="form-group">
							    	<label for="ddn">Date de Naissance :<span class="req">* </span></label>
							        	<form:input size="16" type="text" path="ddnEmploye" name="ddnEmploye" id="ddnEmploye"  class="form-control form_datetime" readonly="readonly" required="required"/>    
							    </div> 
							    
							    <div class="form-group">
							    	<label for="nom">Nom :<span class="req">* </span></label>
							        	<form:input size="16" type="text" path="nomEmploye" name="nomEmploye" id="nomEmploye"  class="form-control form_datetime" readonly="readonly" required="required"/>    
							    </div> 
							    
							    <div class="form-group">
							    	<label for="prenom">Prénom :<span class="req">* </span></label>
							        	<form:input size="16" type="text" path="prenomEmploye" name="prenomEmploye" id="prenomEmploye"  class="form-control form_datetime" readonly="readonly" required="required"/>    
							    </div> 
							    
							    <div class="form-group">
							    	<label for="mailEmploye">Email :<span class="req">* </span></label>
							        	<form:input size="16" type="text" path="mailEmploye" name="mailEmploye" id="mailEmploye"  class="form-control form_datetime" readonly="readonly" required="required"/>    
							    </div> 
							    
							    <div class="input-group">
							    	<label for="telEmploye">Tel : <span class="req">* </span></label>
							    	</div>
							    	<div class="input-group">
										<span class="input-group-addon">(+33)</span>
									<form:input size="20" type="text" class="form-control" path="telEmploye" name="telEmploye" id="telEmploye" placeholder="76473829" aria-describedby="inputGroupSuccess1Status"/>
							  	</div>
							  	<br>
							  	
							  	<c:if test="${i>0}">
							  		<label class="btn btn-info">
										<input type="radio" name="options" id="option2" autocomplete="off">
										<span class="glyphicon glyphicon-ok"></span>
									</label>
							  	</c:if>
							  	
							    <!-- 
							    TODO
							    Ajouter un bouton si il y a des QR codes dispos pour proposer d'assigner un QR code directement
							     -->
							    
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