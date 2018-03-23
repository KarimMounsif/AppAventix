<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


<link href="resources/CSS/monCSS/nav.css" rel="stylesheet">


<!--     Fonts and icons    -->
<link href="resources/Font/fontawesome-all.css" rel="stylesheet">


 


<title>home</title>
        <style>
            html, body {
                height: 100%;
                font-family: 'Lato', sans-serif;
            }
            
            

        </style>
        
        
</head>
<body>
<%@include file="navbar.jsp" %>

<!-- DEBUT -->




   
       
        
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-4 col-sm-4">
                            <div class="card card-stats">
                                <div class="card-header" data-background-color="orange">
                                    <i class="fas fa-qrcode"></i>
                                </div>
                                <div class="card-content">
                                    <p class="category">Crédit QR Code</p>
                                    <h3 class="title">${nbAvailableQR}/${nbTotalQR}
                                        <small>Qrc</small>
                                    </h3>
                                </div>
                                <div class="card-footer">
                                    <div class="stats">
                                        <i class="fas fa-cart-plus"></i>
                                        <a href="<c:url value="/commandeQrcode"/>">Commander Qr Code</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class=" col-md-4 col-sm-4">
                            <div class="card card-stats">
                                <div class="card-header" data-background-color="green">
                                    <i class="fas fa-users"></i>
                                </div>
                                <div class="card-content">
                                    <p class="category">Employe</p>
                                    <h3 class="title">${nbEmployeNonAssigned}/${totalEmploye}</h3>
                                </div>
                                <div class="card-footer">
                                    <div class="stats">
                                        <i class="fas fa-user-plus"></i> 
                                         <a href="<c:url value="/ListerEmploye"/>">Lister Employe</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-4">
                            <div class="card card-stats">
                                <div class="card-header" data-background-color="red">
                                    <i class="fas fa-euro-sign"></i>
                                </div>
                                <div class="card-content">
                                    <p class="category">En cours</p>
                                    <h3 class="title">€ ${montantEnCours}</h3>
                                </div>
                                <div class="card-footer">
                                    <div class="stats">
                                        <i class="far fa-credit-card"></i> 
                                        <a href="<c:url value="/ListerTransactions"/>">Transactions</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                      <div class="col-md-4"></div>
                       
                        <div class="col-md-4">
                           
                        </div>
                    </div>
                    <div class="row">
                    <!--  
            				 <div class="col-lg-6 col-md-12">
                            <div class="card">
                                <div class="card-header card-chart" data-background-color="orange">
                                    <div class="ct-chart" id="emailsSubscriptionChart"></div>
                                </div>
                                <div class="card-content">
                                    <h4 class="title">Cumul de Compensation</h4>
                                    <p class="category">Montant Mensuel au retour de Compensation</p>
                                </div>
                                <div class="card-footer">
                                    <div class="stats">
                                        <i class="material-icons">access_time</i> Mise à jour instantanée
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        -->
                        <div class="col-lg-6 col-md-12">
                            <div class="card">
                                <div class="card-header" data-background-color="blue">
                                    <h4 class="title">Employés</h4>
                                    <p class="category">10 derniers Employés ajoutés</p>
                                </div>
                                <div class="card-content table-responsive">
                                    <table class="table table-hover">
                                        <thead class="text-warning">
                                            
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>mail</th>
                                            <th>téléphone</th>
                                            <th>date d'ajout </th>
                                            <th>Status</th>
                                            
                                        </thead>
                                        <tbody>
                                        <c:forEach var="tenEmploye" items="${listTenEmploye}">
                                            <tr>
                                                <td><c:out value="${tenEmploye.nomEmploye}"/></td>
                                                <td><c:out value="${tenEmploye.prenomEmploye}"/></td>
                                                <td><c:out value="${tenEmploye.mailEmploye}"/></td>
                                                <td><c:out value="${tenEmploye.telEmploye}"/></td>
                                                <td><c:out value="${tenEmploye.dateCreationCompteEmploye}"/></td>
                                                <c:if test="${tenEmploye.statusCompteEmploye==1}">
                                                <td><span class="label label-success">Assigné</span></td>
                                                </c:if>
                                                 <c:if test="${tenEmploye.statusCompteEmploye==0}">
                                                <td><span class="label label-danger">Non Assigné</span></td>
                                                </c:if>
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
            <footer class="footer">
                <div class="container-fluid">
                    <nav class="pull-left">
                        <ul>
                            <li>
                                <a href="#">
                                    Home
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Company
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Portfolio
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Blog
                                </a>
                            </li>
                        </ul>
                    </nav>
                    <p class="copyright pull-right">
                        &copy;
                        <script>
                            document.write(new Date().getFullYear())
                        </script>
                        
                    </p>
                </div>
            </footer>
        
    

<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>


<script src="resources/CSS/bootstrapDashboard/js/material.min.js" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="resources/CSS/bootstrapDashboard/js/chartist.min.js"></script>

<!--  Dynamic Elements plugin -->
<script src="resources/CSS/bootstrapDashboard/js/arrive.min.js"></script>

<!--  PerfectScrollbar Library 
<script src="resources/CSS/bootstrapDashboard/js/perfect-scrollbar.jquery.min.js"></script>
-->
<!-- Material Dashboard javascript methods -->
<script src="resources/CSS/bootstrapDashboard/js/material-dashboard.js?v=1.2.0"></script>
<!-- Material Dashboard DEMO methods, don't include it in your project! -->
<script src="resources/CSS/bootstrapDashboard/js/demo.js"></script>
<script type="text/javascript">
    $(document).ready(function() {

        // Javascript method's body can be found in assets/js/demos.js
        demo.initDashboardPageCharts();

    });
</script>


<!-- FIN -->


</body>
</html>