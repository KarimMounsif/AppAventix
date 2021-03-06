<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <link href="resources/CSS/monCSS/nav2.css" rel="stylesheet">
<style type="text/css">
<%@ page session="true" %>



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
</style>
</head>
<body>
<nav class="navbar navbar-black">
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
         <li><a href="<c:url value="/loginAdminConnexion"/>"><span class="glyphicon glyphicon-th" aria-hidden="true"></span> Dashboard</a></li>

        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Partenaires <span class="caret"></span></a>
          <ul class="dropdown-menu">
           <li><a href="<c:url value="/listerDemande"/>"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span>&nbsp &nbspDemande d'adh�sion</a></li>
            <li><a href="<c:url value="/listerPartenaire"/>"><span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>&nbsp &nbspListes des partenaires</a></li>
           
          </ul>
        </li>
      <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Gestion des transactions <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp &nbspTransaction entre partenaire</a></li>
           <li><a href="#"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp &nbspCommandes</a></li>
          </ul>
      </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp &nbsp Administration<span class="caret"></span></a>
          <ul class="dropdown-menu">
            
            <li><a href="<c:url value="/deconnexion"/>"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Deconnexion</a></li>
         </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
   
  </div><!-- /.container-fluid -->
</nav>

<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>
