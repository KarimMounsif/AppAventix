<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="resources/CSS/bootstrap/css_Old/bootstrap.css" rel="stylesheet">
 <link href="resources/CSS/monCSS/nav.css" rel="stylesheet">
 
 <!--  Material Dashboard CSS   -->
<link href="resources/CSS/bootstrapDashboard/css/material-dashboard.css?v=1.2.0" rel="stylesheet" />

<!--     Fonts and icons    -->
<link href="resources/Font/fontawesome-all.css" rel="stylesheet">


<title>home</title>
<style type="text/css">

.panel.panel-horizontal {
    display:table;
    width:100%;
}

.glyphicon-lg
{
    font-size:4em
}
.info-block
{
    border-right:5px solid #E6E6E6;margin-bottom:25px
}
.info-block .square-box
{
    width:100px;min-height:110px;margin-right:22px;text-align:center!important;background-color:#676767;padding:20px 0
}
.info-block.block-info
{
    border-color:#20819e
}
.info-block.block-info .square-box
{
    background-color:#20819e;color:#FFF
}

</style>

</head>
<body>

 <%@include file="navbar.jsp" %>





<div class="container">
	<div class="row">
		<h2>Assigner QR Code</h2>
        <div class="col-lg-12">
                 
                 <div class="row">
  					<div class="col-12 col-md-8">.</div>
  						<div class="col-6 col-md-4">
					  	   <div class="card card-stats">
                                <div class="card-header" data-background-color="orange">
                                    <i class="fas fa-qrcode"></i>
                                </div>
                                <div class="card-content">
                                    <p class="category">Crédit QR Code Disponible</p>
                                    <h3 class="title"><c:out value='${nombreQRdispo}' />
                                        <small>Qrc</small>
                                    </h3>
                                </div>
                                <div class="card-footer">
                                    <div class="stats">
                                        <i class="fas fa-cart-plus"></i>
                                        <a href="#pablo">Commander Qr Code</a>
                                    </div>
                                </div>
                            </div>
					  
					  </div>
				</div>
        
            <input type="search" class="form-control" id="input-search" placeholder="Rechercher un employé..." ><br><br><br>
        </div>
        <br>
        <div class="searchable-container">
        <c:forEach var="employe" items="${liste}">
            <div class="items col-xs-12 col-sm-12 col-md-6 col-lg-6">
                
               <div class="info-block block-info clearfix">
                    <div class="square-box pull-left">
                        <span class="glyphicon glyphicon-user glyphicon-lg"></span>
                    </div>
                    <h4>Nom : <c:out value="${employe.prenomEmploye}"/> <c:out value="${employe.nomEmploye}"/></h4>
                    <h5>Mail : <c:out value="${employe.mailEmploye}"/> </h5>
                    <p>Solde : <c:out value="${employe.soldeEmploye}"/></p>
                    <span>Telephone : <c:out value="${employe.telEmploye}"/></span>
                    <form:form action="AssignerQR" method ="post">
					    <div class="panel-footer">
					    	<input type="hidden" name="idEmploye" value="${employe.idEmploye}"/>
					    	<input type="submit" path="" class="btn btn-primary btn-sm" value="Assigner QR code"/> 
					    </div>
					</form:form>
                </div>
            </div>
        </c:forEach>
        </div>
	</div>
</div>

<script src="<c:url value="/resources/JS/monJS/RechercheEmp.js" />"></script>
<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>
</body>
</html>