<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="resources/CSS/bootstrap/css_Old/bootstrap.css" rel="stylesheet">
<style type="text/css">
 .mainFrame{

    padding-top: 100px;
 
 }
 .navbar-custom {
    color: #FFFFFF;
    background-color: #0277BD;
}
 .nav > li > a:hover,
 .nav > li > a:focus{
    text-decoration: white;
    background-color: none; /*Change rollover cell color here*/
  }
  
 </style>
 
<title>Création de Compte Commercant</title>
</head>
<body>
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
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pas de Compte ? Créer le ! <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Commerçant</a></li>
                <li><a href="#">Employeur</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
  
<div class="container-fluid mainFrame">
<div class="container">
<div class="row form-group">
        <div class="col-xs-12">
            <ul class="nav nav-pills nav-justified thumbnail setup-panel">
                <li class="active"><a href="#step-1">
                    <h4 class="list-group-item-heading">Personal</h4>
                    <p class="list-group-item-text">First step description</p>
                </a></li>
                <li class="disabled"><a href="#step-2">
                    <h4 class="list-group-item-heading">Address</h4>
                    <p class="list-group-item-text">Second step description</p>
                </a></li>
                <li class="disabled"><a href="#step-3">
                    <h4 class="list-group-item-heading">Fianance</h4>
                    <p class="list-group-item-text">Third step description</p>
                </a></li>
                <li class="disabled"><a href="#step-4">
                    <h4 class="list-group-item-heading">Confirmation</h4>
                    <p class="list-group-item-text">Third step description</p>
                </a></li>
            </ul>
        </div>
	</div>
	
	 
    <form role="form">
   	 <!-- Step 1 -->
    <div class="row setup-content" id="step-1">
                <div class="tab-content">
                      <div class="tab-pane active" role="tabpanel" id="step1">
                        <div class="step1">
                            <div class="row">
                            <div class="col-md-6">
                                <label for="exampleInputEmail1">First Name</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="First Name">
                            </div>
                            <div class="col-md-6">
                                <label for="exampleInputEmail1">Last Name</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Last Name">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label for="exampleInputEmail1">Email address</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                            </div>
                            <div class="col-md-6">
                                <label for="exampleInputEmail1">Confirm Email address</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label for="exampleInputEmail1">Mobile Number</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                            </div>
                            <div class="col-md-6">
                            <label for="exampleInputEmail1">Email address</label>
                                <div class="row">
                                    <div class="col-md-3 col-xs-3">
                                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                    </div>
                                    <div class="col-md-9 col-xs-9">
                                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                    </div>
                                </div>
                            </div>
                        </div>
                        </div>
                        <ul class="list-inline pull-right">
                            <li><button type="button" class="btn btn-primary next-step">Save and continue</button></li>
                        </ul>
                    </div>
                    
                    <!-- Step 2 -->
                     <div class="row setup-content" id="step-2">
			            <div class="col-md-12">
			                <h1 class="text-center"> STEP 2</h1>
			                <ul class="list-inline pull-right">
			                <button id="activate:step-1" class="btn btn-primary btn-lg">back to Personal</button>
			                <button id="activate:step-3" class="btn btn-primary btn-lg">go to Fainance</button>
			                </ul>
			            </div>
       				 </div>
    
                    <!-- Step 3 -->
                    
                    <!-- Step 4 -->
      </div>
      </div>
  </form>
  
  
</div>
</div>
<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>
<script src="resources/JS/monJS/stepForm.js"></script>
</body>
</html>