<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


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
		<h2>&nbsp&nbspMes Transactions</h2>
        <div class="col-lg-12">
            <input type="search" class="form-control" id="input-search" placeholder="Rechercher une transaction " >
        </div>
    
    <br>
    
		<div class="span5">
		<div class="searchable-container">
		
            <table class="table table-striped table-condensed">
            
                  <thead>
                  <tr>
                      <th>Date Achat</th>
                      <th>Commerce</th>
                      <th>Montant Achat</th>
                      <th>Status Transactions</th>                                          
                  </tr>
             	 </thead>
           
              <tbody> 
              	<c:forEach var="listeTransacs" items="${listeachat}">
              	
              	
              	<tr class="items">
              		<td><c:out value="${listeTransacs.a.dateAchat}"/></td>
			        <td><c:out value="${listeTransacs.c.nomCommerce}"/></td>
			        <td><c:out value="${listeTransacs.a.montantAchat}"/></td>
			        <td>
			        	<c:if test="${listeTransacs.a.statusCompensation==1}">
			        		<span class="label label-success"><c:out value="Transaction complétée"/></span>
			        	</c:if>
			        	<c:if test="${listeTransacs.a.statusCompensation==0}">
			        		<span class="label label-warning"><c:out value="Transaction en cours"/></span>
			        	</c:if>
			   	 	</td>
			    	</tr>
			   
			    </c:forEach>
			    
			    
				</tbody>
				
				
            </table>
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