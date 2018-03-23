<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>
<html>
<head>
<link href="<c:url value="/resources/CSS/monCSS/ListerEmp.css" />" rel="stylesheet">


<style type="text/css">

.panel.panel-horizontal {
    display:table;
    width:100%;
}
.panel.panel-horizontal > .panel-heading, .panel.panel-horizontal > .panel-body, .panel.panel-horizontal > .panel-footer {
    display:table-cell;
}
.panel.panel-horizontal > .panel-heading, .panel.panel-horizontal > .panel-footer {
    width: 25%;
    border:0;
    vertical-align: middle;
}
.panel.panel-horizontal > .panel-heading {
    border-right: 1px solid #ddd;
    border-top-right-radius: 0;
    border-bottom-left-radius: 4px;
}
.panel.panel-horizontal > .panel-footer {
    border-left: 1px solid #ddd;
    border-top-left-radius: 0;
    border-bottom-right-radius: 4px;
}


/* TABS HORIZONTAL */
.nav-tabs-dropdown {
  display: none;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}

.nav-tabs-dropdown:before {
  content: "\e114";
  font-family: 'Glyphicons Halflings';
  position: absolute;
  right: 30px;
}

@media screen and (min-width: 769px) {
  #nav-tabs-wrapper {
    display: block!important;
  }
}
@media screen and (max-width: 768px) {
    .nav-tabs-dropdown {
        display: block;
    }
    #nav-tabs-wrapper {
        display: none;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
        text-align: center;
    }
   .nav-tabs-horizontal {
        min-height: 20px;
        padding: 19px;
        margin-bottom: 20px;
        background-color: #f5f5f5;
        border: 1px solid #e3e3e3;
        border-radius: 4px;
        -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
        box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
   }
    .nav-tabs-horizontal  > li {
        float: none;
    }
    .nav-tabs-horizontal  > li + li {
        margin-left: 2px;
    }
    .nav-tabs-horizontal > li,
    .nav-tabs-horizontal > li > a {
        background: transparent;
        width: 100%;
    } 
    .nav-tabs-horizontal  > li > a {
        border-radius: 4px;
    }
    .nav-tabs-horizontal  > li.active > a,
    .nav-tabs-horizontal  > li.active > a:hover,
    .nav-tabs-horizontal  > li.active > a:focus {
        color: #ffffff;
        background-color: #428bca;
    }
}
.oaerror {
  width: 90%; /* Configure it fit in your design  */
  margin: 0 auto; /* Centering Stuff */
  background-color: #FFFFFF; /* Default background */
  padding: 20px;
  border: 1px solid #eee;
  border-left-width: 5px;
  border-radius: 3px;
  margin: 0 auto;
  font-family: 'Open Sans', sans-serif;
  font-size: 16px;
}

.success {
  border-left-color: #2b542c;
  background-color: rgba(43, 84, 44, 0.1);
}

.success strong {
  color: #2b542c;
}

.danger {
  border-left-color: #d9534f; /* Left side border color */
  background-color: rgba(217, 83, 79, 0.1); /* Same color as the left border with reduced alpha to 0.1 */
}

.danger strong {
  color:  #d9534f;
}

</style>


</head>
<body>

 <%@include file="navbar.jsp" %>

<div class="container">
	<div class="row">
	<c:if test="${not empty param.msg}" >
		<c:if test="${param.msg == 1}" >
		<div class="oaerror success" id="msgShow">
            <strong>Success</strong> - Employe a été bien ajouté.
          </div>
	 </c:if>
	</c:if>
		<h2>&nbsp&nbspMes Employés</h2>
        <div class="col-lg-12">
            <input type="search" class="form-control" id="input-search" placeholder="Rechercher Employés... " >
        </div>
    </div>
    <br>
        
       <!-- TABS --> 
    <div class="row">
        <div class="col-sm-12">
            <ul id="nav-tabs-wrapper" class="nav nav-tabs nav-tabs-horizontal">
              <li class="active"><a href="#htab1" data-toggle="tab">Avec QR code <span class="badge">${nbAssigned}</span></a></li>
              <li><a href="#htab2" data-toggle="tab">Sans QR code <span class="badge">${nbNonAssigned}</span></a></li>
            </ul>
            <br>
            <div class="searchable-container">
            	<div class="tab-content">
                	<div role="tabpanel" class="tab-pane fade in active" id="htab1">
                
                <!-- PEOPLE WITH QR-->
                
						<c:forEach var="employe" items="${empavecqr}">
	            			<div class="items col-xs-12 col-sm-6 col-md-6 col-lg-6 clearfix">
	               				<div class="info-block block-info clearfix">
	                    			<div class="square-box pull-left">
	                        			<span class="glyphicon glyphicon-user glyphicon-lg"></span>
	                    			</div>
				                    <h4>Nom : <c:out value="${employe.prenomEmploye}"/> <c:out value="${employe.nomEmploye}"/></h4>
				                    <h5>Mail : <c:out value="${employe.mailEmploye}"/> </h5>
				                    <p>Solde : <c:out value="${employe.soldeEmploye}"/></p>
				                    <span>Telephone : <c:out value="${employe.telEmploye}"/></span>
				                    <br>
				                    <form:form action="modifierEmploye" method ="get" cssStyle="display:inline-block">
								    	<input type="hidden" name="idEmploye" value="${employe.idEmploye}"/>
								    	<input type="submit" path="" class="btn btn-primary btn-xs" value="Modifier"/> 
							    	</form:form>
							    	<form:form action="supprimerEmploye" method ="post" cssStyle="display:inline-block">
								    	<input type="hidden" name="idEmploye" value="${employe.idEmploye}"/>
								    	<input type="submit" path="" class="btn btn-danger btn-xs" value="Supprimer"/>
							    	</form:form>
							    	<br>
							    	<form:form action="rechargerEmploye" method ="post" cssStyle="display:inline-block">
								    	<input type="hidden" name="idEmploye" value="${employe.idEmploye}"/>
								    	<input type="text" name="prix"/>
								    	<input type="submit" path="" class="btn btn-info btn-xs" value="Recharger"/> 
							    	</form:form>
				                </div>
				            </div>
				         </c:forEach>
			          </div>
            
		     <!-- PEOPLE WITHOUT QR -->   
		              
		            <div role="tabpanel" class="tab-pane fade" id="htab2">
		               
		               <c:forEach var="employe" items="${empsansqr}">
            			<div class="items col-xs-12 col-sm-6 col-md-6 col-lg-6 clearfix">
               				<div class="info-block block-info clearfix">
                    			<div class="square-box pull-left">
                        			<span class="glyphicon glyphicon-user glyphicon-lg"></span>
                    			</div>
			                    <h4>Nom : <c:out value="${employe.prenomEmploye}"/> <c:out value="${employe.nomEmploye}"/></h4>
			                    <h5>Mail : <c:out value="${employe.mailEmploye}"/> </h5>
			                    <p>Solde : <c:out value="${employe.soldeEmploye}"/></p>
			                    <span>Telephone : <c:out value="${employe.telEmploye}"/></span>
			                   
			                    <br>
				                    <form:form action="modifierEmploye" method ="get" cssStyle="display:inline-block">
								    	<input type="hidden" name="idEmploye" value="${employe.idEmploye}"/>
								    	<input type="submit" path="" class="btn btn-primary btn-xs" value="Modifier"/> 
							    	</form:form>
							    	<form:form action="supprimerEmploye" method ="post" cssStyle="display:inline-block">
								    	<input type="hidden" name="idEmploye" value="${employe.idEmploye}"/>
								    	<input type="submit" path="" class="btn btn-danger btn-xs" value="Supprimer"/> 
							    	</form:form>
							    	<br>
							    	<form:form action="rechargerEmploye" method ="post" cssStyle="display:inline-block">
								    	<input type="hidden" name="idEmploye" value="${employe.idEmploye}"/>
								    	<input type="text" name="prix"/>
								    	<input type="submit" path="" class="btn btn-info btn-xs" value="Recharger"/> 
							    	</form:form>
			                </div>
			            </div>
			         </c:forEach>
		            </div>
		        </div>
    		</div>
  		</div>
	</div>
</div>

<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>
<script src="<c:url value="/resources/JS/monJS/listEmploye.js" />"></script>
<script src="<c:url value="/resources/JS/monJS/RechercheEmp.js" />"></script>
<script type="text/javascript">
$("#msgShow").show().delay(5000).fadeOut();
</script>
</body>
</html>
