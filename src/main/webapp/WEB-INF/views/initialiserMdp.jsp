<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <link href="resources/CSS/bootstrap/css_Old/bootstrap.css" rel="stylesheet">
 
 <style type="text/css">
 .mainFrame{

    padding-top: 100px;
 
 }


.navbar,.navbar-brand,.navbar-collapse,.dropdown-toggle{
    color: #FFFFFF;
    background-color: #0277BD;
}

.nav > li > a:hover, .nav > li > a:focus{
	text-decoration: none;
}
.alert-message
{
    margin: 20px 0;
    padding: 20px;
    border-left: 3px solid #eee;
}
.alert-message h4
{
    margin-top: 0;
    margin-bottom: 5px;
}
.alert-message p:last-child
{
    margin-bottom: 0;
}

.alert-message-info
{
    background-color: #f4f8fa;
    border-color: #5bc0de;
}
.alert-message-info h4
{
    color: #5bc0de;
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
 


<title>Authentification</title>
</head>
<body>
  
   <!-- Fixed navbar -->
    <nav class="navbar navbar-fixed-top navbar-custom">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Aventix</a>
        </div>
       
      </div>
    </nav>
  
<div class="container-fluid mainFrame">
<form:form id="" action="" method ="post" commandName="initMdpForm">

  	<div class="row">
  	<div class="col-md-3"></div>
  	<div class="col-md-6">
  	
			<div class="alert-message alert-message-info">
                <h4>Informations : </h4>
                <p>
                		C'est votre première connexion à votre espace et vous êtes sur le point de choisir un mot de passe.
                		Pour des raisons de sécurité, votre mot de passe doit contenir :
                		<ul>
                			<li>Au moins 8 caractères</li>
                			<li>Des caractères alphanumériques majuscule <strong>et</strong> minuscule()</li>
             			<li>Au moins 1 caractère Spécial de type : @#$%^&+=</li>
                			
                		</ul>
                		<Strong>Toutes ses contraintes sont à respecter pour passer cette étape.</Strong>
                    
               </p>
            </div>
            
            		<div class="panel panel-primary">
            		
				<div class="panel-heading"><strong>Changement de Mot de Passe</strong></div>
				<div class="panel-body">
				<form:errors path="*" cssClass="error"/><br>
				<div class="form-group">
                <label for="newMdp">Nouveau Mot de passe :<span class="req">* </span></label> 
                <form:password class="form-control" path="mdp" name="mdp" id="mdp" required="required"/>
                </div>
                <div class="form-group">
                <label for="newMdp">Nouveau Mot de passe  confirmation:<span class="req">* </span></label> 
               	<form:password class="form-control" path="" name="mdpConf" id="mdpConf" required="required"/>
               	</div>
               	<div class="form-group">
                <label for="newMdp">Champ idUser:<span class="req">* </span></label> 
               	<form:input type="text" disabled="disabled" class="form-control" path="idUser" name="idUser"/>
               	</div>
               	
               	<form:input type="submit" path="" class="btn btn-primary btn-lg bMdp" value="Valider" disabled="disabled"/>
					          
            		</div>
				
				
				
				
				</div>
				
            
            </div>
         </div>
         <div class="col-md-3"></div>
  	</div>
  	</form:form>
  </div>
  
	<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
    <script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>
    <script src="resources/JS/monJS/validationMdp.js"></script>
     
</body>
</html>