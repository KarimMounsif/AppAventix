package com.qrcodeteam.aventix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.qrcodeteam.beans.Admin;
import com.qrcodeteam.beans.Employe;
import com.qrcodeteam.beans.Entreprise;
import com.qrcodeteam.beans.Gerant;
import com.qrcodeteam.beans.Login;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.EmployeDAO;
import com.qrcodeteam.dao.LoginDAO;
import com.qrcodeteam.dao.QRCodeDAO;
import com.qrcodeteam.dao.TransactionsDAO;
import com.qrcodeteam.utilitaire.Numeric;
import com.qrcodeteam.validator.LoginValidator;

/**
 * Handles requests for the application Login page.
 */

@Controller
public class LoginController {
	

	/**
	 * Rôle:
	 * Demande de la page d'authentification (Premiere fois ou retour sur erreur)
	 * methode GET
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin(Map<String, Object>  model, HttpSession session) {
		// verification d'une session pendante
		if(session.getAttribute("userEntreprise") == null && session.getAttribute("userGerant")==null) {
			
		Login loginForm = new Login(null,null);
		model.put("loginForm",loginForm);
		return "login";
		
		
		}else if(session.getAttribute("userEntreprise")!=null) {
		
		// Chercher les 10 derniers Employés ajoutés
			
		List<Employe> listTenEmploye = new ArrayList<Employe>();
		String idEntreprise=((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise();
		listTenEmploye=EmployeDAO.getLastTenEmploye(DBConnexion.getConnection(), idEntreprise);
		System.out.println("N° Entreprise :"+idEntreprise);
		model.put("listTenEmploye",listTenEmploye);
		
		// Chercher QR (Total et disponible)
		int nbTotalQR=QRCodeDAO.getQrEntreprise(DBConnexion.getConnection(), idEntreprise);
		int nbAvailableQR=QRCodeDAO.getAvailableQR(DBConnexion.getConnection(), idEntreprise);
		model.put("nbTotalQR", nbTotalQR);
		model.put("nbAvailableQR", nbAvailableQR);
		
		//Nombre Employe assigne et non assigne
		int nbEmployeAssigned=EmployeDAO.ListerEmployeAvecQR(DBConnexion.getConnection(), idEntreprise).size();
		int nbEmployeNonAssigned=EmployeDAO.ListerEmployeSansQR(DBConnexion.getConnection(), idEntreprise).size();
		int totalEmploye=nbEmployeAssigned+nbEmployeNonAssigned;
		model.put("totalEmploye", totalEmploye);
		model.put("nbEmployeAssigned", nbEmployeAssigned);
		model.put("nbEmployeNonAssigned", nbEmployeNonAssigned);
		
		// Montant en cours 
		float montant=TransactionsDAO.getEncoursMontant(DBConnexion.getConnection(), idEntreprise);
		montant=Numeric.arrondir(montant, 2);
		model.put("montantEnCours",montant);
		
				// Basculer vers l'accueil de l'employeur ou entreprise;
				return "homeEntreprise";
		}else if(session.getAttribute("userGerant")!=null) {
				// Basculer vers l'accueil du Gérant ou du commerce
				return "homeGerant";
			}else {
				// basculer vers l'accueil de Aventix
				return "homeAdminAventix";
			}
			
		}
	
	

	
	/**
	 * 
	 * @param model
	 * @param userLogin
	 * @param result
	 * @param session
	 * @return
	 * Rôle :
	 * Connexion et création de variable de session utilisateur employeur
	 * 
	 */
	@RequestMapping(value = "/loginEmployeur", method = RequestMethod.POST)
	public String processLoginEmployeur(Map<String, Object>  model, @ModelAttribute("loginForm") Login userLogin, BindingResult result, HttpSession session) {
		

		// instanciation d'un validator de formulaire de login	
		LoginValidator loginValidator = new LoginValidator();
		
		// validation du formulaire
        loginValidator.validate(userLogin, result);
		
        // Présence d'erreur dans le formulaire
		if (result.hasErrors()) {
			 System.out.println("il y a des erreurs");
		    // Erreur dans le formulaire
		 return "login";
		}  
		
		// Absence d'erreur dans le formulaire d'authentification
		else {
		 
			Entreprise entreprise=null;
			String resultat="errorlogin";

			//Recherche de l'Entreprise
			entreprise=LoginDAO.getLoginEntreprise(DBConnexion.getConnection(), userLogin);
			
			// Authentification KO
			if(entreprise==null) {
				// mail ou password ne concorde pas
				result.rejectValue("login", "errors.required",new Object[] {"login"},"Mail ou password incorrect"); 
				return "login";
			}
			// Authentification OK & Teste du Status du Compte 0 :Première connexion !!!!
			else if(entreprise.getStatusCompteEntreprise()==0) {
				
				// Initier Changement mot de passe;
				session.setAttribute("idUserEntreprise",entreprise.getIdEntreprise());
				System.out.println("Variable id entreprise créé==>"+(String)session.getAttribute("idUserEntreprise"));
				return "redirect:/initialiserMdp";
				
			}else {
				
				model.put("employe",entreprise);
				model.put("user",entreprise);
				// Chercher les 10 derniers Employés ajoutés
				List<Employe> listTenEmploye = new ArrayList<Employe>();
				listTenEmploye=EmployeDAO.getLastTenEmploye(DBConnexion.getConnection(), entreprise.getIdEntreprise());
				System.out.println("N° Entreprise :"+entreprise.getIdEntreprise());
				model.put("listTenEmploye",listTenEmploye);
				
			
				// Chercher QR (Total et disponible)
				int nbTotalQR=QRCodeDAO.getQrEntreprise(DBConnexion.getConnection(), entreprise.getIdEntreprise());
				int nbAvailableQR=QRCodeDAO.getAvailableQR(DBConnexion.getConnection(), entreprise.getIdEntreprise());
				model.put("nbTotalQR", nbTotalQR);
				model.put("nbAvailableQR", nbAvailableQR);
				
				//Nombre Employe assigne et non assigne
				int nbEmployeAssigned=EmployeDAO.ListerEmployeAvecQR(DBConnexion.getConnection(),  entreprise.getIdEntreprise()).size();
				int nbEmployeNonAssigned=EmployeDAO.ListerEmployeSansQR(DBConnexion.getConnection(),  entreprise.getIdEntreprise()).size();
				int totalEmploye=nbEmployeAssigned+nbEmployeNonAssigned;
				model.put("totalEmploye", totalEmploye);
				model.put("nbEmployeAssigned", nbEmployeAssigned);
				model.put("nbEmployeNonAssigned", nbEmployeNonAssigned);
				
				// Montant en cours 
				float montant=TransactionsDAO.getEncoursMontant(DBConnexion.getConnection(), entreprise.getIdEntreprise());
				montant=Numeric.arrondir(montant,2);
				model.put("montantEnCours",montant);
				
				resultat="successlogin";
				// creation de la session utilisateur
				session.setAttribute("userEntreprise", entreprise);
				// Test StatusCompte OK : Passer sur la page d'accueil de l'acteur (Employeur);
				return "homeEntreprise";
				
			}
			
		}
	}
		
		
	
	
	
	
	/**
	 * 
	 * @param model
	 * @param userLogin
	 * @param result
	 * @param session
	 * @return
	 * Rôle :
	 * Connexion et création de variable de session utilisateur employeur
	 * 
	 */
	@RequestMapping(value = "/loginCommercant", method = RequestMethod.POST)
	public String processLoginCommercant(Map<String, Object>  model, @ModelAttribute("loginForm") Login userLogin, BindingResult result, HttpSession session) {
		
			
		// instanciation d'un validator de formulaire de login	
		LoginValidator loginValidator = new LoginValidator();
		
		// validation du formulaire
        loginValidator.validate(userLogin, result);
		
        // Présence d'erreur dans le formulaire
		if (result.hasErrors()) {
			 System.out.println("il y a des erreurs");
		    // Erreur dans le formulaire
		 return "login";
		}   
		
		// Absence d'erreur dans le formulaire d'authentifictaion
		else {
		 
			Gerant commercant=null;
			String resultat="login";

			//Recherche du Commercant
			commercant=LoginDAO.getLoginCommercant(DBConnexion.getConnection(), userLogin);
			
			// Authentification KO
			if(commercant==null) {
				// mail ou password ne concorde pas
				
				result.rejectValue("login", "errors.required",new Object[] {""},"Mail ou password incorrect"); 
				return "redirect:/login";
			}
			
			else if(commercant.getStatusCompteGerant()==0) {
				
				// Creation de variable idUserGerant: identifiant du gérant dont on veut changer le mot de passe
				session.setAttribute("idUserGerant",commercant.getIdGerant());
				
				// Initier Changement de mot de passe;
				return "redirect:/initialiserMdp";
				
			}else {
				session.setAttribute("userGerant", commercant);
				// creation de la session utilisateur
				
				// Test StatusCompte OK : Passer sur la page d'accueil de l'acteur (Employeur);
				return "homeGerant";
			}
		
		}
		
	
	}
		
	
	
	
	
	
	/**
	 * 
	 * @param model
	 * @param status
	 * @return "login"
	 * Rôle:
	 * Deconnexion  et suppression de la session utilisateur
	 */
	@RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
	public String processDeconnexion(Map<String, Object>  model,SessionStatus status,HttpSession session) {
		
		status.setComplete();
		session.removeAttribute("userEntreprise");
		System.out.println("Fin de la session");
		return "redirect:/login"; 
	}
	

	
	
	
	@RequestMapping(value = "/loginAdminConnexion", method = RequestMethod.GET)
	public String viewLoginAdmin(Map<String, Object>  model, HttpSession session) {
		// verification d'une session pendante
		if(session.getAttribute("userAdmin") == null) {
			
		Login loginForm = new Login(null,null);
		model.put("loginForm",loginForm);
		return "loginAdmin";
		
		}else {
				// basculer vers l'accueil de Aventix
				return "homeAdminAventix";
			}
			
		}
	
	
	
	
	@RequestMapping(value = "/loginAdminConnexion", method = RequestMethod.POST)
	public String processLoginAdmin(Map<String, Object>  model, @ModelAttribute("loginForm") Login userLogin, BindingResult result, HttpSession session) {
		
			
		// instanciation d'un validator de formulaire de login	
		LoginValidator loginValidator = new LoginValidator();
		
		// validation du formulaire
        loginValidator.validate(userLogin, result);
		
        // Présence d'erreur dans le formulaire
		if (result.hasErrors()) {
			 System.out.println("il y a des erreurs");
		    // Erreur dans le formulaire
		 return "loginAdmin";
		}   
		
		// Absence d'erreur dans le formulaire d'authentifictaion
		else {
		 
			Admin admin=null;
			

			//Recherche du Commercant
			admin=LoginDAO.getLoginAdmin(DBConnexion.getConnection(), userLogin);
			
			// Authentification KO
			if(admin==null) {
				// mail ou password ne concorde pas
				
				result.rejectValue("login", "errors.required",new Object[] {""},"Mail ou password incorrect"); 
				return "loginAdmin";
			}
			
			else {
				session.setAttribute("userAdmin", admin);

				return "homeAdminAventix";
			}
		
		}
		
	
	}
}
	
	
