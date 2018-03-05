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
   <link href="resources/CSS/monCSS/numberSpinner.css" rel="stylesheet">
  <style type="text/css">
  
 .spaceUnder {
  padding-bottom: 3em;
}
.active{
	display: block;
}
.desactive{
	display: none;
}
  
  </style>
<title>Passer commande de QRCode</title>
</head>
<body>

<div class="modal"><!-- Place at bottom of page --></div>
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


<div class="container">
  <h2>Commande QR Code</h2>
  <form id="validerCommandeQrcode-form" action="validerCommandeQrcode" method ="post">
  <table class="table">
    <thead>
      <tr>
        <th>Quantité</th>
        <th>Prix Unitaire (€)</th>
        <th>Prix Total (€)</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>
    <div class="row">
  <div class="col-md-4">
  <div class="input-group spinner">
    <input type="text" id="inputSpinner" class="form-control" value="1" min="1" max="250">
    <div class="input-group-btn-vertical">
      <button class="btn btn-default" type="button"><i class="glyphicon glyphicon-plus"></i></button>
      <button class="btn btn-default" type="button"><i class="glyphicon glyphicon-minus"></i></button>
    </div>
  </div>
  </div>
	</div>
        </td>
        <td>
        		9,99 
        </td>
        <td id="prixCommande1">
        
        </td>
      </tr>
      <tr>
        <td>
        <strong>Total à payer (€)</strong>
        </td>
        <td></td>
        
        <td id="prixCommande2"></td>
      </tr>
       <tr class="spaceUnder">
        <td>
        <strong>Réduction (%)</strong>
        </td>
        
        <td></td>
        <td id="prctReduc"></td>
      </tr>
        	<tr >
  		<td><strong>Prix Commande (€)</strong></td>
  		<td></td>
  		<td id="prixFinalCommande"></td>
  	
  	</tr>
    </tbody>
  </table>
  <ul class="list-inline pull-right">

  <input type="button" id="buttonAjaxCall" onclick="commandeAjaxCall()" class="btn btn-primary btn-lg" value="Passer la Commande"/>
  
  <div id="loaderDiv" class="desactive"> 
  	<img src="resources/Images/ajax-loader.gif" alt="">
  </div>
  <div id="mesgSuccess" class="desactive"> Commande effectuée et livrée</div>
  <div id="mesgError" class="desactive"> Une erreur est intervenue durant le traitement de la commande ...</div>
  </ul>
  </form>
</div>


<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>
<script src="resources/JS/monJS/commandeHandler.js"></script>
<script src="resources/JS/monJS/numberSpinner.js"></script>

</body>
</html>