package com.qrcodeteam.services;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.mysql.jdbc.Connection;
import com.qrcodeteam.beans.EmployeQrCodeRest;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.ImpServiceDAO;
import com.qrcodeteam.utilitaire.JsonResponse;


@Component
@Path("/employeService")
public class EmployeServiceImpl implements IEmployeService{

	/******************************************************************************************************
	authentification, Service  pour réaliser l'authentification d'un employé
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
		ImpServiceDAO impSDao = new ImpServiceDAO();
		JsonResponse jrEmploye = new JsonResponse();
		eqr = impSDao.authentificationEmploye(DBConnexion.getConnection(), mailEmploye, mdpEmploye);   
		sortie1 :if( eqr != null ) {
				int status = impSDao.checkStatutEmploye(eqr.getE().getIdEmploye());
				 if( status == 1 ) {
					jrEmploye.setValidated(true);
					jrEmploye.setErrorMessages(null);
					
					HashMap<String, String> succesMessage = new HashMap<String, String>();
					succesMessage.put("response", "authentication OK");
					jrEmploye.setSuccessMessages(succesMessage);
					jrEmploye.setResponseObject((Object)eqr);
					break sortie1;
				}
				
				else if ( status == 0 ){
					jrEmploye.setValidated(true);
					jrEmploye.setErrorMessages(null);
					HashMap<String, String> succesMessage = new HashMap<String, String>();
					succesMessage.put("response", "premiere connexion");
					succesMessage.put("passwordChange", "@ipServer/aventix/rest/employeService/updateMdp?idEmploye=valueOfIdEmploye&newMdp=valueOfnewPasswd");
					jrEmploye.setSuccessMessages(succesMessage);
					jrEmploye.setResponseObject((Object)eqr);
					break sortie1;
				}
				
				else if ( status == 2 ) {
					jrEmploye.setValidated(false);
					HashMap<String, String> errorMessage = new HashMap<String, String>();
					errorMessage.put("erreur", "utilisateur desactive");
					jrEmploye.setErrorMessages(errorMessage);
					jrEmploye.setSuccessMessages(null);
					jrEmploye.setResponseObject(null);
					break sortie1;
				}
		}
		else {
			jrEmploye.setValidated(false);
			HashMap<String, String> errorMessage = new HashMap<String, String>();
			errorMessage.put("erreur", "login ou mdp incorrects");
			jrEmploye.setErrorMessages(errorMessage);
			jrEmploye.setSuccessMessages(null);
			jrEmploye.setResponseObject(null);
		}
		
		return jrEmploye;
	}

	
	/*****************************************************************************************************
	Service pour Changer Mdp Employe à la première connexion
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/employeService/updateMdp?idEmploye=&newMdp=
	******************************************************************************************************/
	@GET
	@Path("updateMdp")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse changeMdpEmploye(@QueryParam("idEmploye") String idEmploye, @QueryParam("newMdp") String newMdp) 

	{
		ImpServiceDAO impSDao = new ImpServiceDAO();
		JsonResponse jrUpdate = new JsonResponse();
		String retour = null;
		retour = impSDao.changeMdpEmploye(idEmploye, newMdp); 
		if(retour != null) {
			//System.out.println("retour OK");
			jrUpdate.setValidated(true);
			jrUpdate.setErrorMessages(null);
			HashMap<String, String> succesMessage = new HashMap<String, String>();
			succesMessage.put("response", "PasswdChangeSUCCESS ");
			jrUpdate.setSuccessMessages(succesMessage);
			jrUpdate.setResponseObject(null);
		}
		else {
			jrUpdate.setValidated(false);
			HashMap<String, String> errorMessage = new HashMap<String, String>();
			errorMessage.put("erreur", "PasswdChangeFAIL");
			jrUpdate.setErrorMessages(errorMessage);
			jrUpdate.setSuccessMessages(null);
			jrUpdate.setResponseObject(null);;
		}
		return jrUpdate;
	}
	
	
	/*****************************************************************************************************
	getQrCode, Service pour obtenir le QR code à la demande
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/employeService/getQrCode?idEmploye=
	******************************************************************************************************/
	@GET
	@Path("getQrCode")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse getQrCode(@QueryParam("idEmploye") String idEmploye) {
		JsonResponse jrQrcode = new JsonResponse();
		ImpServiceDAO impSDao = new ImpServiceDAO();
		HashMap<String, String> code = new HashMap<String, String>();
		
		code = (HashMap<String, String>) impSDao.getQrCode(DBConnexion.getConnection(), idEmploye);
		
		if (code != null)
		{
			jrQrcode.setValidated(true);
			jrQrcode.setErrorMessages(null);
			HashMap<String, String> succesMessage = new HashMap<String, String>();
			succesMessage.put("response", "QrCode OK");
			jrQrcode.setSuccessMessages(succesMessage);
			jrQrcode.setResponseObject((Object)code);
			
		}
		else
		{
			jrQrcode.setValidated(false);
			HashMap<String, String> errorMessage = new HashMap<String, String>();
			errorMessage.put("erreur", "Could not get Qr Code");
			jrQrcode.setErrorMessages(errorMessage);
			jrQrcode.setSuccessMessages(null);
			jrQrcode.setResponseObject(null);
			return jrQrcode;
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
		ImpServiceDAO impSDao = new ImpServiceDAO();
		HashMap<String, Float> soldesTotalEtJournalier = null;
		
		soldesTotalEtJournalier = (HashMap<String, Float>) impSDao.getSoldeTotalEtJournalier(idEmploye);
		
		if(soldesTotalEtJournalier != null) {
			jrSolde.setValidated(true);
			jrSolde.setErrorMessages(null);
			HashMap<String, String> succesMessage = new HashMap<String, String>();
			succesMessage.put("response", "Solde Journalier et Total OK");
			jrSolde.setSuccessMessages(succesMessage);
			jrSolde.setResponseObject((Object)soldesTotalEtJournalier);
		}
		else {
			jrSolde.setValidated(false);
			HashMap<String, String> errorMessage = new HashMap<String, String>();
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
		ImpServiceDAO impSDao = new ImpServiceDAO();
		HashMap<String, Float> achats = null;
		achats =  (LinkedHashMap<String, Float>) impSDao.getLastMonthAchats(idEmploye);
		
		if(achats != null) {
			jrAchats.setValidated(true);
			jrAchats.setErrorMessages(null);
			HashMap<String, String> succesMessage = new HashMap<String, String>();
			succesMessage.put("response", "Achats last months OK");
			jrAchats.setSuccessMessages(succesMessage);
			jrAchats.setResponseObject((Object)achats);
		}
		else {
			jrAchats.setValidated(false);
			HashMap<String, String> errorMessage = new HashMap<String, String>();
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
	http://localhost:8080/aventix/rest/employeService/Commerces
	****************************************************************************************************/
	/*@GET
	@Path("commercesNearby")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse getCommerces() {
		JsonResponse jrCommerces = new JsonResponse();
		ImpServiceDAO impSDao = new ImpServiceDAO();
		HashMap<String, Float> commerces = null;
		commerces =  (LinkedHashMap<String, Float>) impSDao.getCommercesDAO();
		
		if(commerces != null) {
			jrCommerces.setValidated(true);
			jrCommerces.setErrorMessages(null);
			HashMap<String, String> succesMessage = new HashMap<String, String>();
			succesMessage.put("response", "comemrces nearby");
			jrCommerces.setSuccessMessages(succesMessage);
			jrCommerces.setResponseObject((Object)commerces);
		}
		else {
			jrCommerces.setValidated(false);
			HashMap<String, String> errorMessage = new HashMap<String, String>();
			errorMessage.put("erreur", "There is no commerces nearby");
			jrCommerces.setErrorMessages(errorMessage);
			jrCommerces.setSuccessMessages(null);
			jrCommerces.setResponseObject(null);
		}
		
		return jrCommerces;
	}
	*/
}
	
	
	
	
	
	
	
	
	
	
	
	
