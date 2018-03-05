<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <link href="resources/CSS/bootstrap/css_Old/bootstrap.css" rel="stylesheet">
 <link href="resources/CSS/bootstrapLogin/login.css" rel="stylesheet">
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
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pas de Compte ? Créer le ! <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="<c:url value="/creationCompteCommercant"/>">Commerçant</a></li>
                <li><a href="<c:url value="/creationCompteEmployeur"/>">Employeur</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
  
<div class="container-fluid mainFrame">
  	<div class="row">
  		<div class="col-md-6" style="padding-top:100px;padding-left:100px;">
  		
  			<div class="jumbotron" >
		
  				 <h3>Aventix</h3>
  				<p>
  					Votre espace partenaire intuitif à portée de quelque clics<br/>
  					--> Gérer vos employés<br/>
  					--> Visibilité sur vos transactions<br/>
  					--> Recharger les comptes<br/>
  					--> Consulter votre solde en temps réel<br/>
  				</p>
  				<p>
  					<a class="btn btn-primary btn-large" href="<c:url value="/"/>">Découvrez Aventix</a>
  				</p>
  			</div>
  			
  		</div>
  		<div class="col-md-6">

        <div class="wrapper fadeInDown">
          <div id="formContent">
            <!-- Tabs Titles -->
            <a href="#"  id="loginEmp-form-link"> <h2 id="ongletEmp" class="active">Employeur </h2> </a>
    			<a href="#" id="loginCommercant-form-link"><h2 id="ongletCommercant" class="inactive underlineHover"> Commercant </h2></a>
    				
					
            <!-- Icon -->
            <div class="fadeIn first">
              <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
             
            </div>

            <!-- Login Employeur Form -->
            <form:form id="loginEmp-form" action="loginEmployeur" method="post" commandName="loginForm">
               <strong>
 				<form:errors path="*" cssClass="error"/><br>
			  </strong>
              <form:input path="login" type="text" id="login" name="login" placeholder="mailEmployeur" class="fadeIn second"/>
            
              <form:password path="mdp"  id="password" name="password" placeholder="password" class="fadeIn third" />
              
              <form:input type="submit" path="" class="fadeIn fourth" value="Connexion"/>
              
            </form:form>
            
            <!-- Login Commercant Form -->
             <form:form id="loginCommercant-form" action="loginCommercant" method ="post" commandName="loginForm" style="display: none;">
              <strong style="color:red;">
 				<form:errors path="login" cssClass="error"/><br>
 				<form:errors path="mdp" cssClass="error"/>
			  </strong>
              <form:input path="login" type="text" id="login" class="fadeIn second" name="login" placeholder="loginComercant"/>
              <form:password path="mdp" id="password" class="fadeIn third" name="login" placeholder="passwordCommercant"/>
              <form:input type="submit" path="" class="fadeIn fourth" value="Connexion"/>
            </form:form>

            <!-- Remind Password -->
            <div id="formFooter">
              <a class="underlineHover" href="#">Mot de Passe oublié?</a>
            </div>

          </div>
        </div>




  		</div>
  	</div>
  </div>
	<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
    <script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>
    <script type="text/javascript">
    $(function() {

        $('#loginEmp-form-link').click(function(e) {
    		$("#loginEmp-form").delay(100).fadeIn(100);
     	$("#loginCommercant-form").fadeOut(100);
    		$('#loginCommercant-form-link').removeClass('active');
    		
    		$('#ongletEmp').removeClass('inactive');
    		$('#ongletEmp').removeClass('underlineHover');
    		$('#ongletEmp').addClass('active');
    		
    		$('#ongletCommercant').addClass('inactive');
    		$('#ongletCommercant').addClass('underlineHover');
    		$('#ongletCommercant').removeClass('active');
    		
    		$(this).addClass('active');
    		e.preventDefault();
    	});
        
    	$('#loginCommercant-form-link').click(function(e) {
    		$("#loginCommercant-form").delay(100).fadeIn(100);
     	$("#loginEmp-form").fadeOut(100);
    		$('#loginEmp-form-link').removeClass('active');
    		
    		$('#ongletCommercant').removeClass('inactive');
    		$('#ongletCommercant').removeClass('underlineHover');
    		$('#ongletCommercant').addClass('active');
    		
    		$('#ongletEmp').addClass('inactive');
    		$('#ongletEmp').addClass('underlineHover');
    		$('#ongletEmp').removeClass('active');
    		
    		e.preventDefault();
    	});

    });

    </script>
     
</body>
</html>