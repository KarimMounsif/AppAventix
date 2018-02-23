<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Login</title>
</head>
<body>
<P>  Bravo : EMPLOYE AUTHENTIFIE !!! ${user.nomEmploye} </P>
<form:form id="formname" action="deconnexion" method="post" class="form-horizontal">
						<div class="controls">
						<button type="submit" class="btn btn-primary"> deconnexion </button> <br/>
						 </div>
</form:form>
</body>
</html>