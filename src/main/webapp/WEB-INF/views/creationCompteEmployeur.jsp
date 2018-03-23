<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="resources/CSS/bootstrap/css_Old/bootstrap.css" rel="stylesheet">
  <link href="resources/CSS/bootstrap/css_Old/bootstrap-datepicker.css" rel="stylesheet">
  
  <style type="text/css">
 .mainFrame{
    padding-top: 100px;
 }
 .navbar,.navbar-brand,.navbar-collapse,.dropdown-toggle{
    color: #FFFFFF;
    background-color: #0277BD;
}

.nav > li > a:hover, .nav > li > a:focus{
	text-decoration: none;
}

.req {
    color: red;
}
.dropselectsec1 {
    width: 74%;
    padding: 6px 5px;
    border: 1px solid #ccc;
    border-radius: 3px;
    color: #333;
    margin-left: 10px;
    outline: none;
    font-weight: normal;
}
.mar_ned {
    margin-bottom:10px;
}
.wdth {
    width:50%;
}
.birthdrop {
    padding: 6px 5px;
    border: 1px solid #ccc;
    border-radius: 3px;
    color: #333;
    margin-left: 10px;
    width: 16%;
    outline: 0;
    font-weight: normal;
}
  
input.invalid, textarea.invalid{
	border: 2px solid red;
}

input.valid, textarea.valid{
	border: 2px solid green;
} 

</style>
<title>Création de Compte Entreprise/Employeur</title>

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
                <li><a href="<c:url value="/creationCompteCommercant"/>">Commerçant</a></li>
                <li><a href="<c:url value="/creationCompteEmployeur"/>">Employeur</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
 
<div class="container-fluid mainFrame">
<div class="container">
<form:form id="creerCompteEmployeurEntreprise-form" action="creationCompteEmployeur" method ="post" commandName="entrepriseEmployeForm" enctype="multipart/form-data">
	<form:errors path = "*" cssClass = "errorblock" element = "div" />
	<div class="row form-group">
        <div class="col-xs-12">
            <ul class="nav nav-pills nav-justified thumbnail setup-panel">
                <li class="active"><a href="#step-1">
                    <h4 class="list-group-item-heading">Responsable de Service</h4>
                    <p class="list-group-item-text">Informations Personnelles sur le Responsable</p>
                </a></li>
                <li class="disabled"><a href="#step-2">
                    <h4 class="list-group-item-heading">Entreprise</h4>
                    <p class="list-group-item-text">Informations sur l'entreprise</p>
                </a></li>
                <li class="disabled"><a href="#step-3">
                    <h4 class="list-group-item-heading">Justificatifs</h4>
                    <p class="list-group-item-text">Constitution d'un dossier partenaire</p>
                </a></li>
                <li class="disabled"><a href="#step-4">
                    <h4 class="list-group-item-heading">Confirmation</h4>
                    <p class="list-group-item-text">Contrat et validation d'accord</p>
                </a></li>
            </ul>
        </div>
	</div>
	
	
	<!-- Step 1 -->
    <div class="row setup-content" id="step-1">
        
           <div class="row">
           <div class="col-md-3"></div>
           <div class="col-md-6">
           	<!-- Debut de la page -->
           	
           	    <div class="panel panel-primary">
				<div class="panel-heading"><strong></strong></div>
				<div class="panel-body">
				<form:errors path="*" cssClass="error"/><br>
           	        	<label for="civilite">Civilité :<span class="req">* </span></label>
        				<div class="form-group">
                     <form:select name="civiliteEmploye" id="civiliteEmploye"  class="form-control"  path="em.civiliteEmploye" items="${civiliteList}" required="required"/>
        				</div>
                      <div class="form-group">
              		  <label for="Nom">Nom :<span class="req">* </span></label> 
              		  <form:input type="text" class="form-control" path="em.nomEmploye" name="nomEmploye" id="nomEmploye" placeholder="MOUNSIF" required="required"/>
            			</div> 
            			<div class="form-group">
               		 <label for="validate-text">Prenom :<span class="req">* </span></label> 
              		 <form:input type="text" class="form-control" path="em.prenomEmploye" name="prenomEmploye" id="prenomEmploye" placeholder="Karim" required="required"/>
            			</div>
            			 <div class="form-group">
        				 <label for="ddn">Date de Naissance :<span class="req">* </span></label>
        				<form:input size="16" type="text" path="em.ddnEmploye" name="ddnEmploye" id="ddnEmploye"  class="form-control form_datetime" readonly="readonly" required="required"/>    
                      </div>
            			<div class="form-group">
               		 <label for="validate-text">Email :<span class="req">* </span></label> 
               		 <form:input type="text" class="form-control" path="em.mailEmploye" name="mailEmploye" id="mailEmploye" placeholder="karim.mounsif@insa-lyon.fr" required="required"/>
            			</div>
            			<div class="form-group">
              	  	<label for="validate-text">Confirmation Email :<span class="req">* </span></label> 
               		<input type="text" class="form-control" name="mailEmployeConf" id="mailEmployeConf" placeholder="karim.mounsif@insa-lyon.fr" required="required">
           			</div>
           			<label for="validate-text">Téléphone :<span class="req">* </span></label>
			  		<div class="input-group">
			   		<span class="input-group-addon">(+33)</span>
			  		<form:input type="text" class="form-control" path="em.telEmploye" name="telEmploye" id="telEmploye" placeholder="756473829" aria-describedby="inputGroupSuccess1Status"/>
  					</div>
  					<div class="row" style="padding-right:20px;padding-top:12px">
				            
             <ul class="list-inline pull-right" >
             <button id="activate:step-2" type="button" class="btn btn-primary btn-lg bstp2" disabled="disabled" >
             Suivant 
             </button>
             </ul>
            </div>
            			
        			</div>
        			</div>
        				
           	<!-- Fin de la page -->
           
           </div>
           <div class="col-md-3"></div>
			
        		
					<!-- Panel End -->
				
				
				</div>
		     </div>
				<!--</div>
				-->
			
				

			
        
    		
    		
			
       
    
    
    
 
    <!-- Step 2 -->
    <div class="row setup-content" id="step-2">
          <div class="row">
			<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading"><strong></strong> <small> </small></div>
				<div class="panel-body">
				<!--  -->
				<div class="row">
        			<div class="col-md-6">
        			
        			<div class="form-group">
                <label for="Nom">SIRET :<span class="req">* </span></label> 
                <form:input type="text" class="form-control" path="en.siretEntreprise" name="siretEntreprise" id="siretEntreprise" placeholder="48834299900023" required="required"/>
            		</div>
            		
        			</div>
        			<div class="col-md-6">
                      
        			</div>
        			
        			</div>
        		
        		
        		<div class="row">
        		<div class="col-md-6">
            <div class="form-group">
                <label for="Nom">Nom du Entreprise :<span class="req">* </span></label> 
                <form:input type="text" class="form-control" path="en.nomEntreprise" name="nomEntreprise" id="nomEntreprise" placeholder="SPIE" required="required"/>
            </div>
            </div>
            <div class="col-md-6">
            <div class="form-group">
                <label for="validate-text">Nom du service :<span class="req">* </span></label> 
                 <form:input type ="text" name="nomService" id="nomService"  class="form-control"  path="en.nomService" required="required"/>
        		</div>            
            </div>
        		</div>
        		
        		
        		
        		<div class="row">
        		<div class="col-md-6">
        		 <div class="form-group">
                <label for="validate-text">Adresse :<span class="req">* </span></label> 
                <form:input type="text" class="form-control" path="en.adresseEntreprise" name="adresseEntreprise" id="adresseEntreprise" placeholder="20 Avenue Albert Einstein" required="required"/>
            </div>
            </div>
        		<div class="col-md-6">
        		 <div class="form-group">
                <label for="validate-text">Date immatriculation :<span class="req">* </span></label> 
                <form:input size="16" type="text" path="en.dateImmatriculationEntreprise" name="dateImmatricualtionEntreprise" id="dateImmatricualtionEntreprise"  class="form-control form_datetime" readonly="readonly" required="required"/>    
            </div>
        		</div>
        		</div>
        		
        		
        		
        		<div class="row">
        		
        		 <div class="col-md-2 col-xs-2">
        		 <div class="form-group">
                <label for="validate-text">Boite Postale :<span class="req">* </span></label> 
                <form:input type="text" class="form-control" path="en.codePostalEntreprise" name="codePostalEntreprise" id="codePostalEntreprise" placeholder="ex. 69100" required="required"/>
            </div>
            </div>
            <div class="col-md-4 col-xs-4">
            <div class="form-group">
                <label for="validate-text">Ville :<span class="req">* </span></label> 
                <form:input type="text" path="en.villeEntreprise" class="form-control" name="villeEntreprise" id="villeEntreprise" placeholder="Villeurbanne" required="required"/>
            </div>
        		</div>
        		
        		<div class="col-md-3">
        			<div class="form-group">
                <label for="validate-text">Capital Social :<span class="req">* </span></label> 
                <form:input type="text" class="form-control" path="en.capitalSocialEntreprise" name="capitalSocialEntreprise" id="capitalSocialEntreprise" placeholder="1000000" required="required"/>
           		</div>
        		</div>
        		<div class="col-md-3">
        			<div class="form-group">
                <label for="validate-text">Effectif :<span class="req">* </span></label> 
                <form:input type="text" class="form-control" path="en.effectifEntreprise" name="effectifEntreprise" id="effectifEntreprise" placeholder="ex. 3000" required="required"/>
           		</div>
        		</div>
        		
        		</div>
        		<div class="row">
        		<div class="col-md-6">
        		 <label for="validate-text">Téléphone :<span class="req">* </span></label>
			  <div class="input-group">
			   <span class="input-group-addon">(+33)</span>
			  <form:input type="text" class="form-control" path="en.telEntreprise" name="telCommmerce" id="telEntreprise" placeholder="756473829" aria-describedby="inputGroupSuccess1Status"/>
  			</div>
        			
        		</div>
        		<div class="col-md-6">
				<div class="form-group">
                <label for="validate-text">Relevé d'Identité Bancaire (RIB) :<span class="req">* </span></label> 
                <form:input type="text" class="form-control" path="en.ribEntreprise" name="ribEntreprise" id="ribEntreprise" placeholder="0756473829393939393939" required="required"/>
           		</div>
        		</div>
        		</div>
        
        <div class="row">
		<div class="col-md-6">
        		 <div class="form-group">
                <label for="validate-text">Email :<span class="req">* </span></label> 
                <form:input type="text" class="form-control" path="en.mailEntreprise" name="mailEntreprise" id="mailEntreprise" placeholder="carrefourVenisseiux@insa-lyon.fr" required="required"/>
            </div>
        			<div class="form-group">
                <label for="validate-text">Confirmation Email :<span class="req">* </span></label> 
                <input type="text" class="form-control" name="en.mailEntrepriseConf" id="mailEntrepriseConf" placeholder="karim.mounsif@insa-lyon.fr" required="required">
           		</div>
        		
        		</div>
        		<div class="col-md-6">
				<!-- Pas de description pour l'entreprise -->
        		</div>
        		</div>
        
        
        
        <!-- Button -->
            <ul class="list-inline pull-right">
                <button id="activate:step-1" type="button" class="btn btn-primary btn-lg backbstp1">Précédent</button>
                <button id="activate:step-3" type="button" class="btn btn-primary btn-lg bstp3" disabled="disabled">Suivant</button>
            </ul>
        
    </div>
				
				<!--  -->
				
				</div>
				</div>
				</div>
				</div>
               	
     
    
    <!-- Step 3 -->
    <div class="row setup-content" id="step-3">
    <div class="row">
	<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading"><strong>Papier au format PDF ou JPEG (à définir avec le client)</strong> <small> </small></div>
				<div class="panel-body">
				
				<div class="row">
				<div class="col-md-6" style="position:relative;">
				
				<div class="form-group">
  				<label for="validate-text">1. Pièce d'identité :<span class="req">* </span></label> </br>
  				<input type="file" name="file" id="uploadFile1"><br/>
  				</div>
  				
				</div>
				
				<div class="col-md-6" style="position:relative;">
				
				<div class="form-group">
  				<label for="validate-text">2. Document 2 :<span class="req">* </span></label> </br>
  				<input type="file" name="file" id="uploadFile2"><br/>
  				</div>
  				
				</div>
				</div>
		
				</div>
				</div>

	</div>
	</div>
    <!--  
      		
		<input type="submit" value="Upload"/> Press here to upload the file!
                	
     -->
         
          <ul class="list-inline pull-right">
                <button id="activate:step-2" type="button" class="btn btn-primary btn-lg backbstp2">Précédent</button>
                <button id="activate:step-4" type="button" class="btn btn-primary btn-lg bstp4" disabled="disabled">Suivant</button>
             	</ul>
    </div>
    
   
    
     
    <div class="row setup-content" id="step-4">
        <div class="row">
			<div class="col-md-12">
				<div class="panel panel-warning">
					<div class="panel-heading"><strong>Contrat de Partenariat</strong> <small> </small></div>
						<div class="panel-body">
							<div class="row" style="margin: auto;">
								<textarea  class="form-control" rows="25" cols="175" id="contratText" style="resize: none;" disabled="disabled">
Il n’y a personne qui n’aime la souffrance pour elle-même, qui ne la recherche et qui ne la veuille pour elle-même…

Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, mauris nec varius facilisis, mi neque rutrum enim, sed condimentum dolor felis vitae neque. Maecenas aliquam felis ipsum, non ultricies erat congue aliquet. Nullam ornare eros a eros sodales, et pellentesque velit venenatis. Donec arcu odio, viverra vel egestas nec, pellentesque quis sem. Curabitur tincidunt, tortor vel eleifend hendrerit, justo urna vestibulum neque, quis pellentesque mauris arcu semper ligula. Pellentesque tempor, orci non porta pharetra, dui mauris pulvinar turpis, at rhoncus magna enim sed tortor. Suspendisse eleifend eros vel auctor rutrum. Vivamus vehicula dapibus dolor id facilisis. Aliquam ullamcorper faucibus rutrum. Ut eget magna tempus, mollis nulla quis, congue felis.

Vivamus commodo non magna mollis maximus. Donec vel bibendum felis. Nulla euismod sem interdum enim viverra finibus. Aliquam fermentum enim mi, in dignissim lectus efficitur a. Quisque vel sem varius, euismod tortor at, tincidunt neque. Cras feugiat sapien at aliquam pretium. Pellentesque tincidunt erat at odio semper, ut iaculis lectus cursus. Sed at gravida tellus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vestibulum eros justo, viverra in purus vel, volutpat pulvinar arcu. Sed volutpat eu purus vitae egestas. Integer hendrerit mattis gravida. Cras vel aliquam dolor. Suspendisse diam elit, sagittis in eros eget, condimentum faucibus est.

Vivamus sapien nisi, varius nec lectus vel, dignissim fermentum sapien. Nullam eget risus tortor. Integer et pharetra metus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Ut tristique dolor eget magna vulputate, egestas sagittis felis condimentum. Maecenas rutrum dignissim lectus, vulputate aliquam nibh vulputate eu. Aliquam fringilla ligula ut dui facilisis, at pretium augue ultricies. Nulla eget nisi ut odio lacinia semper non nec massa. Curabitur et dolor enim. Fusce eu quam non leo tempor ullamcorper.

Quisque eleifend, felis sit amet pharetra luctus, mauris velit tincidunt lectus, vel suscipit erat libero at ex. Suspendisse urna eros, varius eu augue eget, eleifend commodo ex. Sed venenatis arcu ac massa porta, eget maximus risus egestas. Quisque ac mi leo. Ut tincidunt vestibulum aliquam. Pellentesque arcu odio, commodo venenatis placerat sit amet, congue nec quam. Proin vel augue ut ipsum tristique condimentum vel eget ligula. Curabitur tellus turpis, aliquam vitae auctor quis, gravida id turpis. Vivamus varius sed lacus eget dignissim. Phasellus eget sapien tortor. Suspendisse scelerisque diam urna, ut fringilla mauris elementum non. Aliquam erat volutpat. Etiam tincidunt sed turpis in faucibus. Aenean est massa, tincidunt vitae lorem at, finibus mollis magna. Pellentesque dictum ante lacus, id accumsan est venenatis non. Curabitur risus tellus, aliquet ut odio sit amet, dictum sollicitudin quam.

Quisque neque orci, porta vitae hendrerit ornare, porttitor quis augue. Quisque metus lorem, ullamcorper vitae magna eget, tempus lacinia mauris. Sed pellentesque est nec dolor dictum condimentum. Duis ut mauris pretium, laoreet felis sed, dignissim lectus. Maecenas elementum tortor nibh, ac mattis lorem hendrerit vel. Proin id turpis dolor. Integer luctus venenatis blandit. Sed sit amet massa condimentum lorem viverra euismod. Donec ut placerat quam.

Morbi eleifend elementum vehicula. Fusce nisl lacus, ornare nec massa id, ullamcorper sodales ex. Aliquam tempor dapibus erat, in commodo tortor pellentesque non. Morbi id ligula eget dui varius ultricies. Donec rutrum, nisl non interdum pharetra, erat ipsum gravida sem, in pulvinar sapien ex vel augue. Maecenas et lacus eu ipsum sollicitudin suscipit eget a diam. Quisque neque nisl, tempor a rhoncus et, condimentum eu enim. Aliquam eget molestie justo. Suspendisse potenti. Fusce scelerisque lectus quam, in cursus dui pellentesque et. Mauris quis tempus quam. Curabitur ac eros eget nisi dignissim sodales sit amet non dolor. Nullam ut condimentum leo. Sed posuere quam eu urna laoreet, et aliquet risus feugiat. Sed molestie magna orci. Ut ut ligula lacus.

Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec ut luctus nibh. Nullam posuere suscipit dignissim. Integer tristique risus at velit dictum, suscipit vestibulum quam placerat. Donec eu risus hendrerit massa pulvinar aliquet. Fusce vitae dolor ac tortor eleifend porta sed id lorem. Donec volutpat tortor eu sapien maximus luctus. Aenean tempus aliquet velit. Vestibulum porttitor tristique lacus at vehicula.

Nulla facilisi. Cras nec facilisis ante. Suspendisse convallis, erat non fringilla hendrerit, nulla augue molestie enim, faucibus aliquet nulla nibh sit amet sem. Proin ultricies dolor a risus scelerisque, eget elementum neque euismod. Mauris eu lacus a ligula porttitor finibus. Donec accumsan congue risus, id imperdiet est venenatis eget. Integer quis nisi elit. Etiam neque velit, faucibus eu laoreet tincidunt, scelerisque non magna. Duis quis ornare risus, non lacinia erat.

Nunc vitae lorem ut turpis finibus mattis a ac lectus. Aliquam non congue quam, et tempus ante. Proin et mattis enim. Pellentesque commodo commodo pellentesque. Suspendisse vehicula fermentum lorem ac viverra. Vestibulum laoreet nec tellus vel auctor. Nullam in augue id mauris pharetra aliquet eget vitae nisi. Donec finibus pulvinar sapien et ullamcorper. Fusce quis ex libero. Sed vitae ipsum at dui sodales hendrerit. Vivamus nunc diam, sodales nec sagittis pellentesque, ullamcorper sit amet arcu.

Cras vehicula diam at ultricies consequat. Nunc sem neque, accumsan id iaculis vel, consectetur ut nibh. Nunc pharetra posuere convallis. Aenean quis convallis nisl, eu auctor odio. Aliquam eget velit et libero aliquet consectetur. Sed quis sapien a elit vulputate eleifend nec eu metus. Nulla quis est dapibus, feugiat sem non, cursus mauris. Ut nec urna pharetra, pharetra sem nec, lobortis nibh. Donec non libero consectetur metus molestie convallis sed sed risus. In eu leo bibendum mauris gravida bibendum. Maecenas aliquet convallis venenatis. Aliquam blandit nulla eget interdum sollicitudin. Curabitur pellentesque vulputate odio, in pharetra augue volutpat at. Sed commodo, augue sit amet facilisis mattis, sem mi malesuada mi, at vehicula urna lectus eget justo. Pellentesque sagittis turpis a maximus finibus.

Aenean quis tristique est. Morbi luctus mattis justo, a iaculis sapien. Praesent hendrerit sapien eu tempor laoreet. Nunc pretium maximus lorem, eu cursus arcu molestie non. Fusce libero felis, commodo ac pharetra nec, sagittis in tortor. Donec egestas sit amet turpis in facilisis. In volutpat elit a ante sagittis facilisis. Ut nec mi massa. Suspendisse sed nibh arcu. Nulla varius ultricies nibh, vitae egestas mauris dapibus eget. Ut luctus arcu quam, id venenatis lorem laoreet aen. Curabitur eget mi in libero ornare luctus eu nec felis. Etiam porttitor ullamcorper quam.

Sed aliquam nunc eu arcu molestie, ut aliquet mauris volutpat. Pellentesque et iaculis ex. Vestibulum blandit tortor sed odio porta commodo. Ut sed sapien fringilla, tincidunt tellus sed, fringilla nisi. Proin aliquam nisi libero, pretium facilisis leo auctor eu. Quisque semper euismod tincidunt. Nullam lacinia vitae odio id efficitur. Donec tincidunt metus eget orci condimentum, eget efficitur est dapibus.

Fusce malesuada nisl vitae nisl laoreet, non tristique lorem fermentum. Donec luctus libero et nulla cursus, eu pharetra ipsum gravida. Aenean sodales aliquet dignissim. Phasellus maximus, augue ac volutpat vulputate, erat massa molestie dolor, a pulvinar ipsum augue ac massa. Cras molestie tortor sit amet molestie iaculis. Etiam eget mattis sem. Etiam porta augue id lectus venenatis tincidunt. Nulla facilisi. Aenean ornare pulvinar volutpat. Nam eu tortor in ligula porttitor commodo. Integer nec mi ut turpis rutrum aliquet sed a nibh. Sed aliquam ex vitae rhoncus lobortis. Etiam lacinia, libero in viverra tincidunt, nulla risus sodales ipsum, a luctus nulla diam sit amet nibh.

Donec elementum, libero eu maximus congue, est lectus faucibus lorem, nec vulputate arcu nunc ut turpis. Phasellus volutpat euismod dignissim. Aenean ornare lorem in massa suscipit vulputate. Curabitur blandit orci sed augue pretium luctus. Maecenas lacus arcu, scelerisque id leo at, ornare aliquet sapien. Vivamus ullamcorper dignissim enim sed sollicitudin. Nullam velit nibh, venenatis quis hendrerit nec, commodo non magna. Morbi efficitur nunc ac elit ornare, non ullamcorper odio tristique. Proin sit amet gravida nisi, ac dapibus justo. Maecenas id tellus quam. Suspendisse eget lacus ac turpis imperdiet sollicitudin auctor sed magna.

Nunc mauris orci, venenatis aliquet tellus ut, auctor pharetra lorem. Etiam ullamcorper felis ut ligula pulvinar, vitae lacinia sapien dignissim. Nunc vitae efficitur justo. Sed congue id nulla efficitur imperdiet. Aliquam ut facilisis massa. Vivamus viverra felis a nisl scelerisque, et pharetra purus luctus. Sed maximus nulla mi, ut auctor elit interdum sit amet. Ut faucibus feugiat odio eget blandit. Fusce tempor justo vitae neque vulputate, quis sodales neque molestie. Praesent in ligula ac tellus fermentum gravida et nec urna. Nulla facilisi.

Ut dignissim tellus vitae augue tincidunt, quis aliquam est iaculis. Aenean venenatis est convallis auctor malesuada. Maecenas velit magna, aliquam at magna vitae, laoreet aliquam risus. Vestibulum turpis ex, pretium facilisis eros eu, vulputate hendrerit tortor. Nam lobortis libero id lacus hendrerit, ac placerat felis sodales. Etiam vitae accumsan neque, vel vehicula mi. Vivamus nec dapibus leo, hendrerit lobortis augue. Proin rhoncus velit nec rhoncus consequat. Sed ultrices porttitor turpis quis molestie. Suspendisse luctus, massa a tempus imperdiet, dolor mi laoreet massa, in rutrum nibh augue in lectus. Ut congue id justo ut condimentum. Mauris luctus scelerisque placerat. Proin tempus erat non tincidunt fermentum. Duis sed erat finibus, pretium elit bibendum, dignissim tellus. Sed a mi elit. In auctor luctus pellentesque.

Vestibulum ut urna tincidunt, iaculis ligula in, dictum metus. Vivamus lacinia est et risus rutrum mollis. Donec non pharetra enim. Sed blandit dui nulla, sed feugiat diam facilisis aen. Aliquam a neque imperdiet felis viverra varius. Aliquam sodales auctor dui et imperdiet. Nulla imperdiet enim ex, ac pharetra enim consectetur eu. Maecenas et porttitor lectus. Pellentesque laoreet est et dapibus dignissim. Vivamus a arcu nunen.

Ut vitae purus sit amet leo accumsan rutrum. Fusce cursus congue lacus, viverra feugiat turpis vulputate aen. Nunc placerat tortor nec mauris pulvinar, ac rhoncus lorem convallis. Donec posuere, mi ac molestie porta, nisl mauris pulvinar lectus, at feugiat ante orci at augue. Vivamus vel risus nec leo faucibus vehicula. Phasellus at pulvinar quam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce dui ante, elementum vitae nulla dapibus, sollicitudin varius lorem. Quisque ligula justo, placerat imperdiet sapien ut, laoreet blandit sem. Sed vulputate bibendum sagittis. Cras lacinia massa sed egestas finibus. Nunc condimentum ornare euismod. Vestibulum sed cursus ex.

Nullam mauris erat, maximus eu accumsan sit amet, feugiat et magna. Donec urna sapien, ultricies vitae felis in, dignissim porttitor felis. Suspendisse potenti. Nulla sagittis mauris at imperdiet aliquet. Vivamus a cursus magna. Suspendisse viverra sapien et eleifend efficitur. Nunc pulvinar dolor id lorem pharetra, id efficitur est malesuada. Donec egestas erat eros, ut congue tortor elementum a. Sed tincidunt commodo egestas. Vestibulum quis sapien vestibulum, vestibulum nisi eget, consequat tortor. Donec laoreet viverra eros, eget tempor massa finibus id. Vivamus aliquet sem sem, in pellentesque enim viverra ut. Fusce non dignissim lorem.

Phasellus imperdiet condimentum ultrices. Fusce et volutpat enim, ornare vehicula velit. Proin suscipit eget mi vel hendrerit. Suspendisse sodales ipsum purus, efficitur ultrices elit sollicitudin et. Quisque ut ante vel arcu facilisis feugiat. Suspendisse potenti. Donec non dapibus tellus, et varius purus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ipsum arcu, vulputate quis urna ac, sagittis dignissim nibh. Vivamus dolor lorem, vehicula vitae ex et, varius dapibus leo. In feugiat sem id lacinia molestie. Aliquam aliquam nec est non imperdiet. Curabitur gravida sapien a elit finibus, eu sagittis arcu accumsan. Sed eros lorem, convallis vel bibendum non, pretium et elit.

Sed commodo viverra velit. Cras ultrices semper nisi sit amet vehicula. Mauris nec maximus mi, et molestie lectus. Pellentesque eleifend mi aliquam tellus elementum dignissim. Mauris tristique lectus et mauris pretium dapibus. Nullam ac nunc ex. Donec auctor eros sed nibh ornare, eget commodo orci tempor. Integer mollis mauris nisl, sed elementum lorem feugiat aen. Cras metus est, sodales at consectetur in, commodo eu mauris. Mauris cursus tellus ut justo bibendum sodales. Cras sed ullamcorper lectus, id sollicitudin risus. Nulla odio quam, posuere non mollis et, molestie a lorem. Nam vitae est vel ligula dapibus ullamcorper sed id odio. Nullam consectetur, mi ut hendrerit dictum, metus tortor pellentesque ligula, congue placerat tellus orci ut odio. Praesent facilisis neque et eros molestie, quis consequat ante ultricies.

In feugiat congue ipsum, interdum eleifend arcu. Etiam mattis tristique urna, id imperdiet est. Cras vitae convallis sem. Sed nec justo eu sem sodales mattis id sit amet neque. Aenean mauris est, tincidunt quis eleifend quis, suscipit faucibus risus. Proin tincidunt quam quis tortor vestibulum imperdiet. Duis ultricies dui ut dapibus maximus. Nullam sagittis elit a cursus pharetra. Maecenas odio lacus, egestas in risus quis, consectetur venenatis ipsum. Nunc vestibulum sagittis scelerisque. Nam pretium ullamcorper orci, vitae mollis nulla dapibus ut. Nunc eget ex sed sem finibus faucibus quis non risus. Aliquam volutpat erat ut nisi convallis, in fringilla metus viverra. Praesent vulputate nibh vestibulum odio tempor elementum. Integer non aliquam neque.

Quisque vestibulum bibendum sodales. Aliquam erat volutpat. Morbi vulputate dui ac imperdiet consectetur. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut posuere pretium massa, vitae sodales justo accumsan porta. Morbi vestibulum justo et orci elementum luctus nec in nulla. Nulla placerat, odio condimentum aliquet condimentum, urna lectus auctor nibh, quis feugiat tellus velit non arcu. Nunc rutrum, elit sit amet aliquam consectetur, nulla nulla maximus massa, vel faucibus diam libero eget ex. Nullam vel accumsan nisl, sed fringilla arcu. Nam vel risus eleifend, gravida nulla condimentum, mollis sapien. Vivamus ac nisi sed turpis dignissim tristique. Etiam finibus egestas libero ac consequat. Aenean maximus aliquam condimentum.

Praesent urna massa, rutrum vel lorem sed, lobortis porta elit. Nam ut laoreet nulla. Donec ullamcorper justo id cursus tristique. Sed tempor luctus mi, a fermentum libero imperdiet vitae. Nullam tincidunt tortor non tempor iaculis. Proin consectetur purus et eros interdum, id efficitur ligula aliquam. Suspendisse facilisis massa neque, et vehicula metus luctus rutrum. In at scelerisque lacus. Nulla aliquet, sem in sagittis convallis, massa libero gravida leo, eget lacinia purus diam a ligula. Quisque quis nunc massa. Nulla ac consectetur velit. Nunc blandit tortor vitae turpis iaculis, a molestie erat tincidunt.

Aliquam nulla orci, faucibus a iaculis a, porttitor vitae tortor. Mauris gravida quis lorem nec rutrum. Etiam lacinia sem sodales vulputate aliquam. Phasellus porta lobortis turpis, non posuere purus. Etiam eu est at nisl dictum tristique. Duis vulputate, turpis non vulputate porttitor, ipsum ligula congue elit, et maximus quam justo vel odio. Nulla pulvinar ligula at quam ultricies semper. Phasellus lacinia, neque et rutrum maximus, augue risus porta nibh, tincidunt cursus tellus lacus eu ante. Donec sit amet iaculis turpis, non laoreet arcu. Nam at justo quis eros rhoncus condimentum.

Aliquam maximus nunc ac nisl placerat ultrices. Nam suscipit pulvinar enim, sit amet dictum magna congue eu. Vestibulum porta metus quis fringilla condimentum. Fusce pharetra feugiat ligula, vel vehicula quam hendrerit vel. Maecenas eget dolor ultricies, consequat erat non, euismod arcu. Praesent porttitor ex ac leo viverra porttitor. Phasellus placerat tellus sit amet felis laoreet mattis.

Mauris ut elit nulla. In eu mi sagittis, fermentum mauris ac, placerat ipsum. Duis hendrerit sapien id auctor hendrerit. Aliquam fringilla lacus nibh, sed tempor libero cursus aen. Donec euismod elit lectus, condimentum interdum mauris cursus sit amet. Fusce erat lorem, bibendum sit amet felis sed, porta elementum nunen. Etiam dictum quis tortor nec tincidunt.

Proin sagittis faucibus arcu eu iaculis. Donec neque ante, interdum vel porta at, mattis eu massa. Vivamus non eleifend leo. Vivamus sapien orci, scelerisque eget tempor nec, placerat et libero. Nulla quis tellus nulla. Nulla eu mauris a nunc consectetur bibendum. Cras placerat est at ipsum fringilla, eu pellentesque lectus bibendum. Pellentesque erat elit, rhoncus at velit quis, pretium dapibus felis. Proin feugiat turpis sit amet venenatis faucibus. Mauris a volutpat tortor. Morbi eu dui metus.

Aenean sit amet elit tempus, consectetur enim vitae, porta sapien. Aenean vel dui et nisl pellentesque accumsan vitae sed lorem. Donec id lobortis nulla. Integer tristique ornare ante, ut tempor nibh laoreet eu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam hendrerit semper massa, quis ultricies sem vestibulum eu. Vestibulum finibus felis id faucibus molestie. Fusce vitae quam libero. Donec ac lobortis justo, non feugiat orci. Nunc sodales neque non nisl ultricies, eget feugiat metus ornare. Aenean eleifend massa vitae arcu rutrum sagittis. Integer id sem eget nunc tincidunt dignissim. Morbi elementum tellus metus, a pellentesque nunc posuere bibendum. Sed in orci placerat, blandit ex quis, scelerisque tellus. Integer ut felis vitae erat fringilla scelerisque.

Nulla faucibus tincidunt augue, sit amet interdum elit iaculis vel. Sed et velit sit amet nunc elementum fringilla. Duis eu tempor turpis, at luctus ex. Vestibulum viverra ac turpis ut congue. Nulla facilisi. Praesent justo ante, efficitur vel commodo ut, vulputate id urna. Nullam tempor congue viverra. Suspendisse non egestas tortor, pretium tincidunt quam. Proin neque tortor, suscipit ac aliquet sed, porttitor quis ligula. Fusce ultrices, quam a pulvinar fringilla, purus ex porttitor sapien, sit amet varius velit nulla non diam. Quisque sollicitudin, mauris eu faucibus mollis, dolor felis accumsan elit, sed lacinia turpis orci et diam. Morbi tincidunt venenatis ligula, a lobortis velit tincidunt sed. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Phasellus ac magna vehicula, posuere sapien in, posuere odio. Integer sit amet volutpat sem. Donec vel fringilla magna, eu efficitur dolor.

Pellentesque finibus vehicula neque, vitae efficitur ligula pretium vitae. Fusce vestibulum lectus quis augue feugiat, quis laoreet velit maximus. Phasellus ut lectus eget orci varius suscipit nec sit amet ante. Fusce tortor enim, semper vitae massa sit amet, convallis faucibus nulla. Vivamus fermentum, lorem sit amet commodo mollis, mi velit venenatis sapien, eget eleifend sapien lorem at libero. Aenean quis arcu semper, faucibus nibh eget, vestibulum metus. Curabitur ultrices ligula nunc, in convallis erat tristique eget. In efficitur magna ut justo rutrum tincidunt. Donec sodales sit amet neque aliquet egestas. Etiam eget eros aliquet, tempus leo vel, interdum arcu. Suspendisse non est non tortor pretium tempor. Quisque eget venenatis est, at tristique felis.

Ut volutpat eros metus, vel eleifend tortor egestas et. Ut tempor mauris non nulla bibendum, ac dapibus tellus consequat. Cras quis elementum lorem. Etiam lacinia risus ut varius imperdiet. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec scelerisque aliquet dui, eget porta mi interdum ut. Maecenas sollicitudin posuere auctor. Nullam condimentum vel ipsum ac fermentum. Sed et semper quam. Proin nec suscipit eros. Curabitur ultricies efficitur tellus, in aliquet leo interdum et. Sed ut lectus tortor. Sed a mi efficitur, imperdiet enim id, euismod elit.

Donec et libero ipsum. Donec auctor, justo ac ornare cursus, felis massa vehicula odio, sed maximus turpis orci quis dui. Quisque dapibus a nisi a facilisis. Mauris accumsan placerat libero id convallis. Vestibulum quis velit et est convallis dapibus. Etiam non nisi at dui mollis feugiat. Suspendisse purus sapien, lobortis non hendrerit in, commodo consequat lectus. Nulla eu lectus ex. Vestibulum mattis mollis iaculis. Vivamus elementum odio feugiat, lacinia magna sed, elementum neque. Etiam suscipit, enim vitae consectetur molestie, dolor tellus sagittis augue, et rhoncus eros ipsum non lorem. Aliquam erat volutpat. Curabitur consectetur nulla quis lorem iaculis, non malesuada risus imperdiet. Fusce quis nisl in orci luctus egestas quis quis enim. Pellentesque aliquet, ligula ac faucibus dapibus, dolor risus pellentesque tellus, a hendrerit tortor lectus eget nunen.

Phasellus condimentum dui quis pretium feugiat. Donec efficitur odio pulvinar sollicitudin ultrices. Donec suscipit fringilla vulputate. Integer commodo efficitur ligula et sagittis. Fusce posuere semper eros quis ornare. Donec facilisis tortor sed ligula gravida hendrerit in vel felis. Curabitur vulputate auctor massa id ultricies. Sed semper vestibulum molestie. Phasellus metus ligula, blandit in placerat nec, ornare sit amet odio. Pellentesque laoreet sapien dictum massa pharetra, sed tincidunt dui vehicula. Pellentesque blandit elit nec justo fermentum, in luctus velit porta. Proin consequat libero nulla, vitae tristique nisl lobortis id. Ut at dapibus diam. Etiam venenatis lacinia facilisis.

Nam sed faucibus libero. Aliquam blandit cursus ante et lacinia. Phasellus ac imperdiet neque, sed laoreet libero. Nullam rhoncus urna sit amet egestas sodales. Nam tempus tempus ullamcorper. Phasellus lobortis erat et dolor interdum, at eleifend elit mollis. Integer luctus, lacus et faucibus vehicula, lacus urna lobortis erat, non cursus mi magna ac urna. Donec lacus massa, mollis sed pharetra in, sollicitudin vel elit. Sed nec mi eget mauris finibus aliquet.

Curabitur pellentesque felis vitae enim auctor, fringilla imperdiet sem ornare. Integer tincidunt laoreet faucibus. Duis ultricies pellentesque justo. Aliquam erat volutpat. Pellentesque lacinia neque sit amet magna convallis elementum. Praesent odio nisl, blandit efficitur urna vel, pharetra lacinia dolor. Cras at magna mattis, ornare lorem id, malesuada felis. Nunc nulla erat, convallis vitae metus non, dignissim tincidunt justo. Phasellus fermentum eros non ex suscipit hendrerit. Morbi vestibulum nibh sed ipsum lacinia, venenatis feugiat justo efficitur. Etiam est magna, consectetur ac sapien eu, commodo hendrerit justo.

Maecenas iaculis et lacus et aliquet. Suspendisse potenti. Nunc arcu velit, efficitur at lorem ac, tempor elementum ante. Mauris molestie eros sed nisl faucibus pharetra. Ut eget metus blandit, fermentum mi eu, venenatis erat. Mauris non suscipit felis. Vivamus luctus sapien ac sollicitudin vulputate. Proin maximus semper libero, eu sodales augue efficitur id. Donec sed eros ligula. Cras quam est, cursus ut malesuada non, feugiat vel risus. Praesent viverra sodales quam vel pulvinar.

Nunc vitae eros id odio mollis mattis non ut mauris. In non volutpat risus. Etiam risus augue, euismod sed consequat vitae, feugiat quis arcu. Pellentesque at gravida sem. Vestibulum dignissim lobortis odio a pellentesque. Morbi eu dolor cursus ligula bibendum rutrum nec fringilla nibh. Cras pharetra tempor nunc id blandit. Nulla vel felis efficitur, pellentesque sapien at, gravida ligula.

Maecenas non augue eu leo pulvinar cursus. Vestibulum sit amet ultrices neque. Quisque id mauris pretium, sagittis urna at, faucibus diam. Mauris ultrices ut enim eu semper. Aliquam non ante blandit, pretium enim ac, dictum metus. Nulla diam augue, congue in congue sit amet, pretium ut quam. Morbi ut vulputate urna. Vestibulum ac laoreet ipsum. Integer viverra, arcu at ullamcorper tincidunt, elit urna faucibus nisl, eu vehicula lorem nisl eu turpis. Vivamus facilisis mattis quam faucibus elementum.

Sed quis luctus arcu. Curabitur mollis purus quis semper consectetur. Pellentesque a orci lacus. Nullam erat orci, vulputate sed dui eu, iaculis rutrum leo. Sed malesuada, massa sit amet mollis aliquet, ligula tellus elementum tellus, a sodales turpis quam vitae dui. Cras auctor eu ipsum sit amet sagittis. Fusce faucibus ligula sit amet eros scelerisque, vel auctor mi ornare. Nunc urna eros, auctor ut laoreet et, tempus a elit.
									
                
                					</textarea></br></br>
              				</div>
              				<div class="row">
              					<div class="form-check" style="padding-left:21px;">
								  <form:checkbox class="form-check-input" path="" value="" id="defaultCheck1" required="required"/>
								  <label class="form-check-label" for="defaultCheck1">
								    J'ai lu et J'approuve les closes du contrat.
								  </label>
								</div>
              				</div>
              			
              				
						</div>
					</div>
					
					           <ul class="list-inline pull-right">
					                <button id="activate:step-3" type="button" class="btn btn-primary btn-lg backbstp3">Précédent</button>
					              <!--   <button id="activate:step-2" class="btn btn-primary btn-lg">Soumettre</button>  -->
					                <form:input type="submit" path="" class="btn btn-primary btn-lg" value="Soumettre" disabled="disabled"/>
					           </ul>
				</div>	
			</div>
     
                
                    

            
     </div>
     
    
    
    <!-- Fin du container du step form -->
    </form:form>
    </div>
    
    </div>


<div><p id="info" style="display: none;"></p></div>
<div><p id="info2" style="display: none;"></p></div>

<script src="resources/CSS/bootstrap/js_Old/jquery-3.1.1.min.js"></script>
<script src="resources/JS/monJS/datepicker.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap.min.js"></script>
<script src="resources/JS/monJS/stepForm.js"></script>
<script src="resources/JS/monJS/stepFormValidatorEE.js"></script>
<script src="resources/JS/monJS/stepFormValidatorEE2.js"></script>
<script src="resources/JS/monJS/stepFormValidatorEE3.js"></script>
<script src="resources/CSS/bootstrap/js_Old/bootstrap-datepicker.js"></script>

<script type="text/javascript">
$(".form_datetime").datepicker({
    format: "yyyy-mm-dd"
});
</script>

</body>
</html>