package com.qrcodeteam.services;

import com.mysql.jdbc.Connection;
import com.qrcodeteam.bom.Achat;
import com.qrcodeteam.bom.Commerce;
import com.qrcodeteam.bom.EmployeQrCodeRest;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.mobile_app.employe.ImplemEmployeDAO;
import com.qrcodeteam.utils.JsonResponse;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;


@Component
@Path("/employeService")
public class EmployeServiceImpl {

	/******************************************************************************************************
	authentification, Service  pour r�aliser l'authentification d'un employ�
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/employeService/authEmploye?mailEmploye=&mdpEmploye=
	******************************************************************************************************/
	@GET
	@Path("authEmploye")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse authentificationEmploye(Connection con, @QueryParam("mailEmploye") String mailEmploye, 
			@QueryParam("mdpEmploye") String mdpEmploye) {

		EmployeQrCodeRest eqr;
        ImplemEmployeDAO implemEmployeDAO = new ImplemEmployeDAO();
		JsonResponse jrEmploye = new JsonResponse();
        eqr = implemEmployeDAO.authentificationEmploye(DBConnexion.getConnection(), mailEmploye, mdpEmploye);

        if (eqr != null) {
            int status = implemEmployeDAO.checkStatutEmploye(eqr.getE().getIdEmploye());
				 if( status == 1 ) {
					jrEmploye.setValidated(true);
					jrEmploye.setErrorMessages(null);

                     HashMap<String, String> succesMessage = new HashMap<>();
					succesMessage.put("response", "authentication OK");
					jrEmploye.setSuccessMessages(succesMessage);
                     jrEmploye.setResponseObject(eqr);
				}
				
				else if ( status == 0 ){
					jrEmploye.setValidated(true);
					jrEmploye.setErrorMessages(null);
                     HashMap<String, String> succesMessage = new HashMap<>();
					succesMessage.put("response", "premiere connexion");
                     succesMessage.put("passwordChange", "@ipServer/controller/rest/employeService/updateMdp?idEmploye=valueOfIdEmploye&newMdp=valueOfnewPasswd");
					jrEmploye.setSuccessMessages(succesMessage);
                     jrEmploye.setResponseObject(eqr);
				}
				
				else if ( status == 2 ) {
					jrEmploye.setValidated(false);
                     HashMap<String, String> errorMessage = new HashMap<>();
					errorMessage.put("erreur", "utilisateur desactive");
					jrEmploye.setErrorMessages(errorMessage);
					jrEmploye.setSuccessMessages(null);
					jrEmploye.setResponseObject(null);
				}
		}
		else {
			jrEmploye.setValidated(false);
            HashMap<String, String> errorMessage = new HashMap<>();
			errorMessage.put("erreur", "login ou mdp incorrects");
			jrEmploye.setErrorMessages(errorMessage);
			jrEmploye.setSuccessMessages(null);
			jrEmploye.setResponseObject(null);
		}
		
		return jrEmploye;
	}

	
	/*****************************************************************************************************
	Service pour Changer Mdp Employe � la premi�re connexion
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/employeService/updateMdp?idEmploye=&newMdp=
	******************************************************************************************************/
	@GET
	@Path("updateMdp")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse changeMdpEmploye(@QueryParam("idEmploye") String idEmploye, @QueryParam("newMdp") String newMdp) 

	{
        ImplemEmployeDAO implemEmployeDAO = new ImplemEmployeDAO();
		JsonResponse jrUpdate = new JsonResponse();
        String retour;
        retour = implemEmployeDAO.changeMdpEmploye(idEmploye, newMdp);
		if(retour != null) {
			jrUpdate.setValidated(true);
			jrUpdate.setErrorMessages(null);
            HashMap<String, String> succesMessage = new HashMap<>();
			succesMessage.put("response", "PasswdChangeSUCCESS ");
			jrUpdate.setSuccessMessages(succesMessage);
			jrUpdate.setResponseObject(null);
		}
		else {
			jrUpdate.setValidated(false);
            HashMap<String, String> errorMessage = new HashMap<>();
			errorMessage.put("erreur", "PasswdChangeFAIL");
			jrUpdate.setErrorMessages(errorMessage);
			jrUpdate.setSuccessMessages(null);
            jrUpdate.setResponseObject(null);
		}
		return jrUpdate;
	}
	
	
	/*****************************************************************************************************
	getQrCode, Service pour obtenir le QR code � la demande
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/employeService/getQrCode?idEmploye=
	******************************************************************************************************/
	@GET
	@Path("getQrCode")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse getQrCode(@QueryParam("idEmploye") String idEmploye) {

		JsonResponse jrQrcode = new JsonResponse();
        ImplemEmployeDAO impSDao = new ImplemEmployeDAO();
        HashMap<String, String> code;
		
		code = (HashMap<String, String>) impSDao.getQrCode(DBConnexion.getConnection(), idEmploye);
		System.out.println(code);
		if (code != null)
		{
			jrQrcode.setValidated(true);
			jrQrcode.setErrorMessages(null);
            HashMap<String, String> succesMessage = new HashMap<>();
			succesMessage.put("response", "QrCode OK");
			jrQrcode.setSuccessMessages(succesMessage);
            jrQrcode.setResponseObject(code);
		}
		else
		{
			jrQrcode.setValidated(false);
            HashMap<String, String> errorMessage = new HashMap<>();
            errorMessage.put("erreur", "QR code non assigne");
			jrQrcode.setErrorMessages(errorMessage);
			jrQrcode.setSuccessMessages(null);
            jrQrcode.setResponseObject(null);
		}
		return jrQrcode;
	}

	
	/*****************************************************************************************************
	Service pour pour obtenir le solde total et journalier 
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/employeService/Solde?idEmploye=
	*****************************************************************************************************/
	@GET
	@Path("Solde")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse getSoldeTotalEtJournalier(@QueryParam("idEmploye") String idEmploye) {
		
		JsonResponse jrSolde = new JsonResponse();
        ImplemEmployeDAO impSDao = new ImplemEmployeDAO();
        HashMap<String, Float> soldesTotalEtJournalier;
		
		soldesTotalEtJournalier = (HashMap<String, Float>) impSDao.getSoldeTotalEtJournalier(idEmploye);
		
		if(soldesTotalEtJournalier != null) {
			jrSolde.setValidated(true);
			jrSolde.setErrorMessages(null);
            HashMap<String, String> succesMessage = new HashMap<>();
			succesMessage.put("response", "Solde Journalier et Total OK");
			jrSolde.setSuccessMessages(succesMessage);
            jrSolde.setResponseObject(soldesTotalEtJournalier);
		}
		else {
			jrSolde.setValidated(false);
            HashMap<String, String> errorMessage = new HashMap<>();
			errorMessage.put("erreur", "Could not get Solde Journalier et Total");
			jrSolde.setErrorMessages(errorMessage);
			jrSolde.setSuccessMessages(null);
			jrSolde.setResponseObject(null);
		}
		
		return jrSolde;
		
	}
	
	

	/*****************************************************************************************************
	Service pour pour Lister les achat des 30 derniers jours pour l'employe
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/employeService/Achats?idEmploye=
	*****************************************************************************************************/
	@GET
	@Path("Achats")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse getLastMonthAchats(@QueryParam("idEmploye") String idEmploye) {

		JsonResponse jrAchats = new JsonResponse();
        ImplemEmployeDAO impSDao = new ImplemEmployeDAO();
        List<Achat> achats;
		achats = impSDao.getLastMonthAchats(idEmploye);
		
		if(achats != null) {
			jrAchats.setValidated(true);
			jrAchats.setErrorMessages(null);
            HashMap<String, String> succesMessage = new HashMap<>();
			succesMessage.put("response", "Achats last months OK");
			jrAchats.setSuccessMessages(succesMessage);
            jrAchats.setResponseObject(achats);
		}
		else {
			jrAchats.setValidated(false);
            HashMap<String, String> errorMessage = new HashMap<>();
			errorMessage.put("erreur", "There is no achats for the last month");
			jrAchats.setErrorMessages(errorMessage);
			jrAchats.setSuccessMessages(null);
			jrAchats.setResponseObject(null);
		}
		
		return jrAchats;
	}
	
	
	/*****************************************************************************************************
	Service pour pour Lister les restaurants/commerces pour l'employe
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/employeService/commercesNearby
	****************************************************************************************************/
	@GET
	@Path("commercesNearby")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse getCommerces() {

		JsonResponse jrCommerces = new JsonResponse();
        ImplemEmployeDAO impSDao = new ImplemEmployeDAO();
        List<Commerce> commerces;
		commerces = impSDao.getCommercesDAO();
		
		if(commerces != null) {
			jrCommerces.setValidated(true);
			jrCommerces.setErrorMessages(null);
            HashMap<String, String> succesMessage = new HashMap<>();
			succesMessage.put("response", "commerces nearby");
			jrCommerces.setSuccessMessages(succesMessage);
            jrCommerces.setResponseObject(commerces);
		}
		else {
			jrCommerces.setValidated(false);
            HashMap<String, String> errorMessage = new HashMap<>();
			errorMessage.put("erreur", "There is no commerces nearby");
			jrCommerces.setErrorMessages(errorMessage);
			jrCommerces.setSuccessMessages(null);
			jrCommerces.setResponseObject(null);
		}
		
		return jrCommerces;
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
