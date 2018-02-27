<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <link href="resources/CSS/bootstrap/css_Old/bootstrap.css" rel="stylesheet">
  <link href="resources/CSS/bootstrap/css_Old/font-awesome.min.css" rel="stylesheet">
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
  	    <div class="jumbotron">
        <div class="text-center"><i class="fa fa-5x fa-frown-o" style="color:#d9534f;"></i></div>
        <h1 class="text-center">Votre demande a été bien soumise<p> </p><p><small class="text-center"> </small></p></h1>
        <p class="text-center">Votre dossier va être étudié par nos services. Une réponse vous sera envoyée à votre adresse mail sous 48h.
        							Aventix vous remercie pour votre confiance. 
        							A Bientôt.</p>
        <p class="text-center"><a class="btn btn-primary" href="<c:url value="/"/>"><i class="fa fa-home"></i> Revenir à l'Accueil</a></p>
    </div>
  </div>
  
      <div class="footer">
      <div class="container">
              <a href='#'><i class="fa fa-twitch fa-3x fa-fw"></i></a>
              <a href='#'><i class="fa fa-facebook fa-3x fa-fw"></i></a>
              <a href='#'><i class="fa fa-twitter fa-3x fa-fw"></i></a>
              <a href='#'><i class="fa fa-youtube-play fa-3x fa-fw"></i></a>
              <a href='#'><i class="fa fa-rss fa-3x fa-fw"></i></a>
              <a href='#'><i class="fa fa-vine fa-3x fa-fw"></i></a>
              <a href='#'><i class="fa fa-flickr fa-3x fa-fw"></i></a>
              <a href='#'><i class="fa fa-linkedin fa-3x fa-fw"></i></a>
            </span>
      </div>
    </div>
	<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
    <script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>
     
</body>
</html>