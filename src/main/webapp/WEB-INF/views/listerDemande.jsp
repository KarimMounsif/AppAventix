<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="viewport" content="width=device-width" />

 <link href="resources/CSS/bootstrap/css_Old/bootstrap.css" rel="stylesheet">
 <!--  Material Dashboard CSS   -->
<link href="resources/CSS/bootstrapDashboard/css/material-dashboard.css?v=1.2.0" rel="stylesheet" />

<!--     Fonts and icons    -->
<link href="resources/FONT/css/font-awesome.min.css" rel="stylesheet">
 
 <style>
            html, body {
                height: 100%;
            }

            body {
                margin: 0;
                padding: 0;
                width: 100%;
                color: #000000;
                display: table;
                font-weight: 100;
                font-family: 'Lato';
            }
			
			.show-on-hover:hover > ul.dropdown-menu {
			    display: block;    
			}
        </style>
<title>Liste des Partenaires</title>
</head>
<body>

<%@include file="navbarAdmin.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <ul id="nav-tabs-wrapper" class="nav nav-tabs nav-tabs-horizontal">
              <li class="active"><a href="#htab1" data-toggle="tab">Commerce <span class="badge">${nbCom}</span></a></li>
              <li><a href="#htab2" data-toggle="tab">Entreprise <span class="badge">${nbEnt}</span></a></li>
            </ul>
            
			<div class="col-lg-12">
           	 <input type="search" class="form-control" id="input-search" placeholder="Rechercher commerce ou entreprise ... " >
       		</div>
			
			<br>
            <div class="searchable-container">
            	<div class="tab-content">
                	<div role="tabpanel" class="tab-pane fade in active" id="htab1">
                	    <div class="row">
                            <div class="card">
                                <div class="card-header" data-background-color="">
                                    <h4 class="title">Commerces</h4>
                                    <p class="category">Liste demandes adhésions</p>
                                </div>
                                <div class="card-content table-responsive">
                                    <table class="table table-hover">
                                        <thead class="text-warning">
                                        
                                        	   <th>Siret Commerce</th>
                                            <th>Nom Commerce</th>
                                            <th>type Commerce </th>
                                            <th>Adresse Commerce</th>
                                            <th>Contact Commerce</th>
                                            <th>Information Gérant</th>
                                            <th></th>
                                
                                        </thead>
                                        
                                        <tbody>
                	<c:forEach var="ComGer" items="${listCommerce}">
               
		      		 <tr class="items">
                             <td><c:out value="${ComGer.c.siretCommerce}"/></td>
                             <td><c:out value="${ComGer.c.nomCommerce}"/></td>
                              <td><c:out value="${ComGer.c.typeCommerce}"/></td>
                             <td><c:out value="${ComGer.c.adresseCommerce}"/>&nbsp&nbsp <c:out value="${ComGer.c.villeCommerce}"/> &nbsp&nbsp <c:out value="${ComGer.c.codePostalCommerce}"/> </td>
                             <td><c:out value="${ComGer.c.mailCommerce}"/><br><c:out value="0${ComGer.c.telCommerce}"/></td>
                             <td><c:out value="${ComGer.g.nomGerant}"/>&nbsp&nbsp<c:out value="${ComGer.g.prenomGerant}"/><br/>
                             	<c:out value="${ComGer.g.mailGerant}"/> &nbsp&nbsp <c:out value="0${ComGer.g.telGerant}"/></td>
                             	<td>
          <div class="btn-group show-on-hover">
          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
            Actions <span class="caret"></span>
          </button>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Traiter Dossier</a></li>
            <li><a href="#">Valider Demande</a></li>
          </ul>
        </div>
        
        </td>
                             
                     </tr>
              	
                	
                	
                	
                	</c:forEach>

                                        
                                            
                                          
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            </div>
                        
                </div>
                
                <div role="tabpanel" class="tab-pane fade" id="htab2">
                	                	    <div class="row">
                            <div class="card">
                                <div class="card-header" data-background-color="">
                                    <h4 class="title">Entreprises</h4>
                                    <p class="category">Liste demandes adhésions</p>
                                </div>
                                <div class="card-content table-responsive">
                                    <table class="table table-hover">
                                        <thead class="text-warning">
                                        
                                        	   <th>Siret Entreprise</th>
                                            <th>Nom Entreprise</th>
                                            <th>Nom Service</th>
                                            <th>Adresse Entreprise</th>
                                            <th>Contact Entreprise</th>
                                            <th>Information Employeur</th>
                                            <th></th>
                                
                                        </thead>
                                        
                                        <tbody>
                	<c:forEach var="EntEmp" items="${listEnteprise}">
               
		      		 <tr class="items">
                             <td><c:out value="${EntEmp.en.siretEntreprise}"/></td>
                             <td><c:out value="${EntEmp.en.nomEntreprise}"/></td>
                              <td><c:out value="${EntEmp.en.nomService}"/></td>
                             <td><c:out value="${EntEmp.en.adresseEntreprise}"/>&nbsp&nbsp <c:out value="${EntEmp.en.villeEntreprise}"/> &nbsp&nbsp <c:out value="${EntEmp.en.codePostalEntreprise}"/> </td>
                             <td><c:out value="${EntEmp.en.mailEntreprise}"/><br><c:out value="0${EntEmp.en.telEntreprise}"/></td>
                             <td><c:out value="${EntEmp.emp.nomEmploye}"/>&nbsp&nbsp<c:out value="${EntEmp.emp.prenomEmploye}"/><br/>
                             	<c:out value="${EntEmp.emp.mailEmploye}"/> &nbsp&nbsp <c:out value="0${EntEmp.emp.telEmploye}"/></td>
                             	<td>
          <div class="btn-group show-on-hover">
          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
            Actions <span class="caret"></span>
          </button>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Traiter Dossier</a></li>
            <li><a href="#">Valider Demande</a></li>
          </ul>
        </div>
        
        </td>
                             
                     </tr>
              	
                	
                	
                	
                	</c:forEach>

                                        
                                            
                                          
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            </div>
                </div>
             </div>
                </div>        
               </div>
               </div>
     </div>
     
     <script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
	<script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>
		<script src="<c:url value="/resources/JS/monJS/RechercheEmp.js" />"></script>
	<script type="text/javascript">
		$("#msgShow").show().delay(5000).fadeOut();
	</script>
</body>
</html>