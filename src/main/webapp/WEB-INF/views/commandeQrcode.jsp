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

<%@include file="navbar.jsp" %>


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