package com.qrcodeteam.services;

import com.mysql.jdbc.Connection;
import com.qrcodeteam.bom.CommerceGerant;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.mobile_app.gerant.ImplemGerantDAO;
import com.qrcodeteam.utils.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Component
@Path("/commerceService")
public class CommerceServiceImpl {

    private final Logger LOGGER = LoggerFactory.getLogger(CommerceServiceImpl.class);
	
	/*****************************************************************************************************
	authentification, Service  pour r�aliser l'authentification d'un g�rant
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/commerceService/authGerant?mailGerant=&mdpGerant=
	*****************************************************************************************************/
	@GET
	@Path("authGerant")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse authentificationGerant(Connection con, @QueryParam("mailGerant") String mailGerant, 
			@QueryParam("mdpGerant") String mdpGerant) {
        CommerceGerant comGerant;
        ImplemGerantDAO implemGerantDAO = new ImplemGerantDAO();
		JsonResponse jrGerant = new JsonResponse();

        comGerant = implemGerantDAO.authentificationGerant(DBConnexion.getConnection(), mailGerant, mdpGerant);
        if (comGerant != null) {
            int status = implemGerantDAO.checkStatutGerant(comGerant.getG().getIdGerant());
			 if( status == 1 ) {
				jrGerant.setValidated(true);
				jrGerant.setErrorMessages(null);

                 HashMap<String, String> succesMessage = new HashMap<>();
				succesMessage.put("response", "authentication OK");
				jrGerant.setSuccessMessages(succesMessage);
                 jrGerant.setResponseObject(comGerant);
			}
			
			else if ( status == 0 ){
				jrGerant.setValidated(true);
				jrGerant.setErrorMessages(null);
                 HashMap<String, String> succesMessage = new HashMap<>();
				succesMessage.put("response", "premiere connexion");
                 succesMessage.put("passwordChange", "@ipServer/controller/rest/commerceService/updateMdp?idGerant=&newMdp=");
				jrGerant.setSuccessMessages(succesMessage);
                 jrGerant.setResponseObject(comGerant);
			}
			
			else if ( status == 2 ) {
				jrGerant.setValidated(false);
                 HashMap<String, String> errorMessage = new HashMap<>();
                 errorMessage.put("erreur", "utilisateur desactive");
				jrGerant.setErrorMessages(errorMessage);
				jrGerant.setSuccessMessages(null);
				jrGerant.setResponseObject(null);
			}
			
		}
		else {
			jrGerant.setValidated(false);
            HashMap<String, String> errorMessage = new HashMap<>();
			errorMessage.put("erreur", "login ou mdp incorrects");
			jrGerant.setErrorMessages(errorMessage);
			jrGerant.setSuccessMessages(null);
			jrGerant.setResponseObject(null);
		}
	
	return jrGerant;
	}
	
	
	/*****************************************************************************************************
	Service pour pour valider le paiement suite � un achat
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
        ImplemGerantDAO implemGerantDAO = new ImplemGerantDAO();
        HashMap<String, String> errorMessage;
		int retourPaiement;

        LOGGER.debug("numeroCode : " + numeroCode +
                "\n" + "montant: " + montant +
                "\n" + "idCommercant: " + idCommercant);

        retourPaiement = implemGerantDAO.validerPaiement(numeroCode, montant, idCommercant);
        LOGGER.debug("retour = " + retourPaiement);

		switch(retourPaiement) {
		case 4 : 
			jrPaiement.setValidated(false);
            errorMessage = new HashMap<>();
			errorMessage.put("erreur", "transaction impossible en week-end");
			jrPaiement.setErrorMessages(errorMessage);
			jrPaiement.setSuccessMessages(null);
			jrPaiement.setResponseObject(null);
			break;

		case 3 :
			jrPaiement.setValidated(false);
            errorMessage = new HashMap<>();
            errorMessage.put("erreur", "Compte desactive");
			jrPaiement.setErrorMessages(errorMessage);
			jrPaiement.setSuccessMessages(null);
			jrPaiement.setResponseObject(null);
			break;

		case 2 :
			jrPaiement.setValidated(false);
            errorMessage = new HashMap<>();
			errorMessage.put("erreur", "Solde insuffisant");
			jrPaiement.setErrorMessages(errorMessage);
			jrPaiement.setSuccessMessages(null);
			jrPaiement.setResponseObject(null);
			break;

		case 0:
			jrPaiement.setValidated(false);
            errorMessage = new HashMap<>();
            errorMessage.put("erreur", "Solde journalier depasse");
			jrPaiement.setErrorMessages(errorMessage);
			jrPaiement.setSuccessMessages(null);
			jrPaiement.setResponseObject(null);
			break;

		case 1:
			jrPaiement.setValidated(true);
			jrPaiement.setErrorMessages(null);
            HashMap<String, String> succesMessage = new HashMap<>();
            succesMessage.put("response", "Paiement effectue");
			jrPaiement.setSuccessMessages(succesMessage);
			jrPaiement.setResponseObject(null);
			break;

		default:
            LOGGER.debug("Unknown error");
		}
		
		return jrPaiement;
	
	}
	
	

	/*****************************************************************************************************
	Service pour pour Lister les transactions des 30 derniers jours pour le commer�ant
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/commerceService/Transactions?idCommerce=
	*****************************************************************************************************/
	@GET
	@Path("Transactions")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse getLastMonthTransactions(@QueryParam("idCommerce") String idCommerce) { 
		JsonResponse jrTransactions = new JsonResponse();
        ImplemGerantDAO implemGerantDAO = new ImplemGerantDAO();
        HashMap<String, Float> transactions;
        transactions = (LinkedHashMap<String, Float>) implemGerantDAO.getLastMonthTransactions(idCommerce);
		
		if(transactions != null) {
			jrTransactions.setValidated(true);
			jrTransactions.setErrorMessages(null);
            HashMap<String, String> succesMessage = new HashMap<>();
			succesMessage.put("response", "Transactions last months OK");
			jrTransactions.setSuccessMessages(succesMessage);
            jrTransactions.setResponseObject(transactions);
		}
		else {
			jrTransactions.setValidated(false);
            HashMap<String, String> errorMessage = new HashMap<>();
			errorMessage.put("erreur", "There is no transactions for the last month");
			jrTransactions.setErrorMessages(errorMessage);
			jrTransactions.setSuccessMessages(null);
			jrTransactions.setResponseObject(null);
		}
		return jrTransactions;
		
	}


	
	
	/*****************************************************************************************************
	Service pour Changer Mdp Employe � la premi�re connexion
	------------------------------------------------------------------------------------------------------
	http://localhost:8080/aventix/rest/commerceService/updateMdp?idGerant=&newMdp=
	******************************************************************************************************/
	@GET
	@Path("updateMdp")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse changeMdpGerant(@QueryParam("idGerant") String idGerant, @QueryParam("newMdp") String newMdp) {

        ImplemGerantDAO implemGerantDAO = new ImplemGerantDAO();
		JsonResponse jrUpdate = new JsonResponse();
        String retour;
        retour = implemGerantDAO.changeMdpGerant(idGerant, newMdp);

		if(retour != null) {
			jrUpdate.setValidated(true);
			jrUpdate.setErrorMessages(null);
            HashMap<String, String> succesMessage = new HashMap<>();
			succesMessage.put("response", "PasswdChangeSUCCESS");
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
}
