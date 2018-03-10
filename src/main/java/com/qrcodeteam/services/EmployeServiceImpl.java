package com.qrcodeteam.services;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;

import com.mysql.jdbc.Connection;
import com.qrcodeteam.beans.CommerceGerant;
//import com.qrcodeteam.beans.Employe;
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
		//System.out.println("OK2");
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
					jrEmploye.setResponseObject(null);
					break sortie1;
				}
				
				else if ( status == 2 ) {
					jrEmploye.setValidated(false);
					HashMap<String, String> errorMessage = new HashMap<String, String>();
					errorMessage.put("erreur", "utilisateur désactivé");
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
	authentification, Service  pour réaliser l'authentification d'un gérant
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/employeService/authGerant?mailGerant=&mdpGerant=
	*****************************************************************************************************/
	@GET
	@Path("authGerant")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse authentificationGerant(Connection con, @QueryParam("mailGerant") String mailGerant, 
			@QueryParam("mdpGerant") String mdpGerant) {
		CommerceGerant comGerant = null;
		ImpServiceDAO impSDao = new ImpServiceDAO();
		JsonResponse jrGerant = new JsonResponse();
		
		comGerant = impSDao.authentificationGerant(DBConnexion.getConnection(), mailGerant, mdpGerant);
		/*sortie1 :*/if( comGerant != null ) {
			/*int status = impSDao.checkStatutEmploye(comGerant.getE().getIdEmploye());
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
				jrEmploye.setResponseObject(null);
				break sortie1;
			}
			
			else if ( status == 2 ) {
				jrEmploye.setValidated(false);
				HashMap<String, String> errorMessage = new HashMap<String, String>();
				errorMessage.put("erreur", "utilisateur désactivé");
				jrEmploye.setErrorMessages(errorMessage);
				jrEmploye.setSuccessMessages(null);
				jrEmploye.setResponseObject(null);
				break sortie1;
			}
			*/
			jrGerant.setValidated(true);
			HashMap<String, String> successMessage = new HashMap<String, String>();
			successMessage.put("succès", "authentification Ok");
			jrGerant.setSuccessMessages(successMessage);
			jrGerant.setErrorMessages(null);
			jrGerant.setResponseObject((Object)comGerant);
	}
	else {
		jrGerant.setValidated(false);
		HashMap<String, String> errorMessage = new HashMap<String, String>();
		errorMessage.put("erreur", "login ou mdp incorrects");
		jrGerant.setErrorMessages(errorMessage);
		jrGerant.setSuccessMessages(null);
		jrGerant.setResponseObject(null);
	}
	
	return jrGerant;
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
	Service pour pour valider le paiement suite à un achat
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/employeService/Paiement?numeroCode=&montant=&idCommercant=
	******************************************************************************************************/
	@GET
	@Path("Paiement")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse paiement(@QueryParam("numeroCode") String numeroCode, @QueryParam("montant") float montant, 
			@QueryParam("idCommercant") String idCommercant) {
		JsonResponse jrPaiement = new JsonResponse();
		ImpServiceDAO impSDao = new ImpServiceDAO();
		boolean retourPaiement;
		retourPaiement = impSDao.validerPaiement(numeroCode, montant, idCommercant);
		
		if(!retourPaiement) {
			jrPaiement.setValidated(false);
			HashMap<String, String> errorMessage = new HashMap<String, String>();
			errorMessage.put("erreur", "Paiement refusé");
			jrPaiement.setErrorMessages(errorMessage);
			jrPaiement.setSuccessMessages(null);
			jrPaiement.setResponseObject(null);
		}
		else {
			jrPaiement.setValidated(true);
			jrPaiement.setErrorMessages(null);
			HashMap<String, String> succesMessage = new HashMap<String, String>();
			succesMessage.put("response", "Paiement effectué");
			jrPaiement.setSuccessMessages(succesMessage);
			jrPaiement.setResponseObject(null);
		}
		
		return jrPaiement;
	
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
	Service pour pour Lister les transactions des 30 derniers jours pour le commerçant
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/employeService/Transactions?idCommerce=
	*****************************************************************************************************/
	@GET
	@Path("Transactions")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse getLastMonthTransactions(@QueryParam("idCommerce") String idCommerce) {
		JsonResponse jrTransactions = new JsonResponse();
		ImpServiceDAO impSDao = new ImpServiceDAO();
		HashMap<String, Float> transactions = null;
		transactions =  (LinkedHashMap<String, Float>) impSDao.getLastMonthTransactions(idCommerce);
		
		if(transactions != null) {
			jrTransactions.setValidated(true);
			jrTransactions.setErrorMessages(null);
			HashMap<String, String> succesMessage = new HashMap<String, String>();
			succesMessage.put("response", "Transactions last months OK");
			jrTransactions.setSuccessMessages(succesMessage);
			jrTransactions.setResponseObject((Object)transactions);
		}
		else {
			jrTransactions.setValidated(false);
			HashMap<String, String> errorMessage = new HashMap<String, String>();
			errorMessage.put("erreur", "There is no transactions for the last month");
			jrTransactions.setErrorMessages(errorMessage);
			jrTransactions.setSuccessMessages(null);
			jrTransactions.setResponseObject(null);
		}
		return jrTransactions;
		
	}


}
	
	
	
	
	
	
	
	
	
	
	
	
