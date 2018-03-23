<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
				<link href="resources/CSS/bootstrap/css_Old/bootstrap.css" rel="stylesheet">
 				
				<style>
				.error {
       				 color: red; font-weight: bold;
   				 }
   				 .error-notice {
				  margin: 5px 5px; /* Making sure to keep some distance from all side */
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
				.danger {
				  border-left-color: #d9534f; /* Left side border color */
				  background-color: rgba(217, 83, 79, 0.1); /* Same color as the left border with reduced alpha to 0.1 */
				}

				.danger strong {
				  color:  #d9534f;
				}
				</style>
<title>Administration Login</title>
</head>
<body>
<div class="col-md-12">


  <div class="error-notice">
          <div class="oaerror danger">
            <strong>Attention</strong> - Vous êtes sur la Page d'Administration de Aventix. Si vous n'êtes pas autorisé merci de fermer cette page.
      	  </div>
  </div>
 
    <div class="modal-dialog" style="margin-bottom:0; margin-top:100px">
        <div class="modal-content">
                    <div class="panel-heading">
                        <h3 class="panel-title">Aventix Administration</h3>
                    </div>
                    <div class="panel-body">
                        <form:form id="loginAdmin-form" action="loginAdminConnexion" method ="post" commandName="loginForm">
                           <strong style="color:red;">
			 				<form:errors path="login" cssClass="error"/><br>
			 				<form:errors path="mdp" cssClass="error"/>
						  </strong>
                            <fieldset>
                                <div class="form-group">
                                    <form:input path="login" type="text" class="form-control" placeholder="aventix@aventix.com" name="mailAdventix" autofocus=""/>
                                </div>
                                <div class="form-group">
                                    <form:password path="mdp" id="password" class="form-control" placeholder="mdpAventix" name="password" value=""/>
                                </div>
                                <div class="checkbox">
                                    <br>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <form:input type="submit" path="" class="btn btn-success" value="Connexion"/>
                            </fieldset>
                         </form:form>
                        
                        
                                     <form:form id="loginCommercant-form" action="loginCommercant" method ="post" commandName="loginForm" style="display: none;">
           
              <form:input path="login" type="text" id="login" class="fadeIn second" name="login" placeholder="loginComercant"/>
              <form:password path="mdp" id="password" class="fadeIn third" name="login" placeholder="passwordCommercant"/>
              <form:input type="submit" path="" class="fadeIn fourth" value="Connexion"/>
            </form:form>
                    </div>
                </div>
    </div>
</div>
</body>
</html>