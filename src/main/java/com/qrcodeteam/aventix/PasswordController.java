package com.qrcodeteam.aventix;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.qrcodeteam.beans.Entreprise;
import com.qrcodeteam.beans.Login;
import com.qrcodeteam.beans.Mdp;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.PasswordDAO;
import com.qrcodeteam.dao.StatusCompteDAO;
import com.qrcodeteam.validator.LoginValidator;
import com.qrcodeteam.validator.MdpValidator;

/**
 * Handles requests for the application home page.
 */

@Controller
public class PasswordController {
	
	private static final Logger logger = LoggerFactory.getLogger(PasswordController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/initialiserMdp", method = RequestMethod.GET)
	public String viewInitialiserMdp(Map<String,Object> model, HttpSession session) {
		logger.info("Changement de mot de passe");
				if(session.getAttribute("idUserEntreprise")!=null ||session.getAttribute("idUserGerant")!=null ) {
				Mdp initMdpForm=new Mdp(null,null);
				model.put("initMdpForm",initMdpForm);
				return "initialiserMdp";
				}else {
					return "redirect:/login";
				}
			
	}
	
	@RequestMapping(value="/initialiserMdp",method = RequestMethod.POST)
	public String processInitialiserMdp(Map<String,Object> model, @ModelAttribute("initMdpForm") Mdp mdpForm, BindingResult result,HttpSession session,SessionStatus status) {
		
		// instanciation d'un validator de formulaire de mot de passe	
			MdpValidator mdpValidator = new MdpValidator();
					
		// validation du formulaire
			mdpValidator.validate(mdpForm, result);
			
		if(result.hasErrors()) {
			return "initialiserMdp";
		}else {
			if(session.getAttribute("idUserEntreprise")!=null) {
				PasswordDAO.changePasswordEntreprise(DBConnexion.getConnection(),(String) session.getAttribute("idUserEntreprise"),mdpForm);
				System.out.println("Mise a jour du mot de passe");
				StatusCompteDAO.activerCompteEntreprise(DBConnexion.getConnection(),(String) session.getAttribute("idUserEntreprise"));
				System.out.println("Changement du Status du compte");
			}
			if(session.getAttribute("idUserGerant")!=null) {
				PasswordDAO.changePasswordGerant(DBConnexion.getConnection(),(String) session.getAttribute("idUserGerant"),mdpForm);
				StatusCompteDAO.activerCompteGerant(DBConnexion.getConnection(), (String) session.getAttribute("idUserGerant"));
			}
			status.setComplete();
			model.put("successMsg","Mot de passe modifier avec Succès");
			return "redirect:/login";
		}
	}
	
}
