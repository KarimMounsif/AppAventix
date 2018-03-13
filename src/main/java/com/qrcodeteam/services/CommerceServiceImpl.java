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
import com.qrcodeteam.beans.CommerceGerant;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.ImpServiceDAO;
import com.qrcodeteam.utilitaire.JsonResponse;

@Component
@Path("/commerceService")
public class CommerceServiceImpl implements ICommerceService{
	
	
	/*****************************************************************************************************
	authentification, Service  pour réaliser l'authentification d'un gérant
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/commerceService/authGerant?mailGerant=&mdpGerant=
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
		sortie1 : if( comGerant != null ) {
			int status = impSDao.checkStatutGerant(comGerant.getG().getIdGerant());
			 if( status == 1 ) {
				jrGerant.setValidated(true);
				jrGerant.setErrorMessages(null);
				
				HashMap<String, String> succesMessage = new HashMap<String, String>();
				succesMessage.put("response", "authentication OK");
				jrGerant.setSuccessMessages(succesMessage);
				jrGerant.setResponseObject((Object)comGerant);
				break sortie1;
			}
			
			else if ( status == 0 ){
				jrGerant.setValidated(true);
				jrGerant.setErrorMessages(null);
				HashMap<String, String> succesMessage = new HashMap<String, String>();
				succesMessage.put("response", "premiere connexion");
				succesMessage.put("passwordChange", "@ipServer/aventix/rest/commerceService/updateMdp?idGerant=&newMdp=");
				jrGerant.setSuccessMessages(succesMessage);
				jrGerant.setResponseObject((Object)comGerant);
				break sortie1;
			}
			
			else if ( status == 2 ) {
				jrGerant.setValidated(false);
				HashMap<String, String> errorMessage = new HashMap<String, String>();
				errorMessage.put("erreur", "utilisateur désactivé");
				jrGerant.setErrorMessages(errorMessage);
				jrGerant.setSuccessMessages(null);
				jrGerant.setResponseObject(null);
				break sortie1;
			}
			
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
	Service pour pour valider le paiement suite à un achat
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/commerceService/Paiement?numeroCode=&montant=&idCommercant=
	******************************************************************************************************/
	@GET
	@Path("Paiement")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse paiement(@QueryParam("numeroCode") String numeroCode, @QueryParam("montant") float montant, 
			@QueryParam("idCommercant") String idCommercant) {
		JsonResponse jrPaiement = new JsonResponse();
		ImpServiceDAO impSDao = new ImpServiceDAO();
		HashMap<String, String> errorMessage = null;
		int retourPaiement;
		System.out.println(numeroCode);
		System.out.println(montant);
		System.out.println(idCommercant);
		retourPaiement = impSDao.validerPaiement(numeroCode, montant, idCommercant);
		System.out.println("retour = " + retourPaiement);
		switch(retourPaiement) {
		case 4 : 
			jrPaiement.setValidated(false);
			errorMessage = new HashMap<String, String>();
			errorMessage.put("erreur", "transaction impossible en week-end");
			jrPaiement.setErrorMessages(errorMessage);
			jrPaiement.setSuccessMessages(null);
			jrPaiement.setResponseObject(null);
			break;
		case 3 :
			jrPaiement.setValidated(false);
			errorMessage = new HashMap<String, String>();
			errorMessage.put("erreur", "Compte désactivé");
			jrPaiement.setErrorMessages(errorMessage);
			jrPaiement.setSuccessMessages(null);
			jrPaiement.setResponseObject(null);
			break;
		case 2 :
			jrPaiement.setValidated(false);
			errorMessage = new HashMap<String, String>();
			errorMessage.put("erreur", "Solde insuffisant");
			jrPaiement.setErrorMessages(errorMessage);
			jrPaiement.setSuccessMessages(null);
			jrPaiement.setResponseObject(null);
			break;
		case 0:
			jrPaiement.setValidated(false);
			errorMessage = new HashMap<String, String>();
			errorMessage.put("erreur", "Solde journalier dépassé");
			jrPaiement.setErrorMessages(errorMessage);
			jrPaiement.setSuccessMessages(null);
			jrPaiement.setResponseObject(null);
			break;
		case 1:
			jrPaiement.setValidated(true);
			jrPaiement.setErrorMessages(null);
			HashMap<String, String> succesMessage = new HashMap<String, String>();
			succesMessage.put("response", "Paiement effectué");
			jrPaiement.setSuccessMessages(succesMessage);
			jrPaiement.setResponseObject(null);
			break;
		default:
			System.out.println("Erreur fatale");
		}
		
		return jrPaiement;
	
	}
	
	

	/*****************************************************************************************************
	Service pour pour Lister les transactions des 30 derniers jours pour le commerçant
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/commerceService/Transactions?idCommerce=
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


	
	
	/*****************************************************************************************************
	Service pour Changer Mdp Employe à la première connexion
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/commerceService/updateMdp?idGerant=&newMdp=
	******************************************************************************************************/
	@GET
	@Path("updateMdp")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse changeMdpGerant(@QueryParam("idGerant") String idGerant, @QueryParam("newMdp") String newMdp) {
		ImpServiceDAO impSDao = new ImpServiceDAO();
		JsonResponse jrUpdate = new JsonResponse();
		String retour = null;
		retour = impSDao.changeMdpGerant(idGerant, newMdp); 
		if(retour != null) {
			jrUpdate.setValidated(true);
			jrUpdate.setErrorMessages(null);
			HashMap<String, String> succesMessage = new HashMap<String, String>();
			succesMessage.put("response", "PasswdChangeSUCCESS");
			jrUpdate.setSuccessMessages(succesMessage);
			jrUpdate.setResponseObject(null);
		}
		else {
			jrUpdate.setValidated(false);
			HashMap<String, String> errorMessage = new HashMap<String, String>();
			errorMessage.put("erreur", "PasswdChangeFAIL");
			jrUpdate.setErrorMessages(errorMessage);
			jrUpdate.setSuccessMessages(null);
			jrUpdate.setResponseObject(null);
		}
		return jrUpdate;
	}
}
