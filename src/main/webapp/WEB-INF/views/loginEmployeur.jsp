<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
				<link rel="stylesheet" href="resources/CSS/bootstrap/css/bootstrap.css">
				<link rel="stylesheet" href="resources/CSS/bootstrap/css/bootstrap.min.css">
				<link rel="stylesheet" href="resources/CSS/bootstrap/css/bootstrap-theme.css">
				<link rel="stylesheet" href="resources/CSS/bootstrap/css/bootstrap-theme.min.css">
				<link rel="stylesheet" type="text/css" href="resources/CSS/monCSS/login.css">
				<style>
.error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body background="resources/Images/background.jpg">
<div class="container-fluid">
	<div class="row">
		<div class="col-md-9">
			<div id = "logo" >
		<img src="resources/Images/Logo_Aventix.png" style="width:100px;height:75px">
			</div>
		</div>
		<div id="texte_bienvenue" class="col-md-3" align="right" style="font-size:20px" color="#005CB9">
			Bienvenue sur Aventix
		</div>
	</div>
	<div class="row">
		<div id="filler" class="col-md-3">
		</div>
		<div id="loginform" class="col-md-6" align="center">
			<div class="container-fluid">
			  <fieldset>
				<div id="legend" align="center">
				  <legend style="font-size:50px">Connexion</legend>
				</div>
				<br/><br/>
				
				<form:form id="formname" action="login" method="post" commandName="loginForm" class="form-horizontal">
				<!--<form id="formname" class="form-horizontal" action='' method="POST">-->
					<div class="control-group" align="center">
				<br/><br/><br/>
					  <!-- Username -->
					  <label class="control-label" for="username" >Username</label>
					  <div class="controls">
					  <form:input path="login" type="text" id="username" name="username" placeholder="" class="input-xlarge"/>
					  <form:errors path="login" cssClass="error"/>
					<!-- 	<input type="text" id="username" name="username" placeholder="" class="input-xlarge">  -->
					  </div>
					</div>
					<div class="control-group" align="center">
					  <!-- Password-->
					  <label class="control-label" for="password">Password</label>
					  <div class="controls">
					  <form:password path="mdp" id="password" name="password" placeholder="" class="input-xlarge" />
					  <form:errors path="mdp" cssClass="error"/>
						<!-- <input type="password" id="password" name="password" placeholder="" class="input-xlarge">  -->
					  </div>
					</div>
					<div class="control-group" align="center">
					  <!-- Button -->
					  <br/> <br/>
					  <div class="controls">
						<button type="submit" class="btn btn-primary"> Connexion </button> <br/>
					  </div>
					</div>
					<br/><br/>
				<a href="create_compte_commercant.html"> Créez votre compte employeur </a> <br/>
				<a href="create_compte_employeur.html"> Créez votre compte commerçant </a>
				  </fieldset>
			<!-- </form>  -->
			</form:form>
			</div>
		</div>
		<div id="filler" class="col-md-3">
		</div>
	</div>
</body>
</html>