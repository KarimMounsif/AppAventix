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
 
 <link href="https://fonts.googleapis.com/css?family=Lato:100" rel="stylesheet" type="text/css">

<title>home</title>
        <style>
            html, body {
                height: 100%;
            }

            body {
                margin: 0;
                padding: 0;
                width: 100%;
                color: #B0BEC5;
                display: table;
                font-weight: 100;
                font-family: 'Lato';
            }

            .pContainer {
                text-align: center;
                
                vertical-align: middle;
            }

            .content {
                text-align: center;
                display: inline-block;
            }

            .title {
                font-size: 72px;
                padding-top: 300px;
                margin-bottom: 40px;
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
      <a class="navbar-brand" href="#">Aventix</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
         <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-th" aria-hidden="true"></span> Dashboard</a></li>
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Gestion du Personnel <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="/ajouterEmploye"/>"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp&nbspAjouter Employé</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-console" aria-hidden="true"></span>&nbsp Modifier Employé </a></li>
            <li><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>&nbsp Supprimer Employé</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>&nbsp Lister Employés</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#"><span class="glyphicon glyphicon-eur" aria-hidden="true"></span> &nbsp Recharger Employé</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Gestion des QR codes <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="/commandeQrcode"/>"><span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>&nbspCommander QR code</a></li>
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
      <!-- 
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-link" aria-hidden="true"></span> Links<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="http://www.google.ch" target="_blank">My Webmail</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="http://www.google.ch" target="_blank">Timelogger</a></li>
            <li><a href="http://www.cubetech.ch" target="_blank">cubetech.ch</a></li>
         </ul>
        </li>
         -->
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Casino Villeurbanne<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="http://www.fgruber.ch/" target="_blank"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Informations Personnelles</a></li>
            <li><a href="<c:url value="/deconnexion"/>"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Deconnexion</a></li>
         </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
   
  </div><!-- /.container-fluid -->
</nav>
<div class="pContainer">
 <div class="content">
            <div class="title">Page en construction ...</div>
 </div>
 </div>
  
<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>

</body>
</html>