package com.qrcodeteam.aventix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qrcodeteam.beans.CommerceGerant;
import com.qrcodeteam.beans.EntrepriseEmploye;
import com.qrcodeteam.beans.Login;
import com.qrcodeteam.dao.AdminDAO;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.StatusCompteDAO;

@Controller
public class AdhesionController {

	@RequestMapping(value="/listerDemande", method = RequestMethod.GET)
	public String ViewListeDemandeAdhesion(Map<String,Object> model, HttpSession session) {
		
		List<CommerceGerant> lCommerce= new ArrayList<CommerceGerant>();
		int nbDemandeCom=0;
		List<EntrepriseEmploye> lEntreprise = new ArrayList<EntrepriseEmploye>();
		int nbDemandeEnt=0;
	if(session.getAttribute("userAdmin") == null) {
			Login loginForm = new Login(null,null);
			model.put("loginForm",loginForm);
			return "loginAdmin";
		} else {
			lCommerce = AdminDAO.listerCommerceDemande(DBConnexion.getConnection());
			nbDemandeCom=lCommerce.size();
			model.put("nbCom", nbDemandeCom);
			model.put("listCommerce",lCommerce);
			
			lEntreprise = AdminDAO.listerEntrepriseDemande(DBConnexion.getConnection());
			nbDemandeEnt=lEntreprise.size();
			model.put("nbEnt", nbDemandeEnt);
			model.put("listEntreprise",lEntreprise);
			
		return "listerDemande";
		}
	}
	
public String ValiderDemandeAdhesion(ServletRequest request,Map<String,Object> model, HttpSession session) {
		String idCommerce="";

	if(session.getAttribute("userAdmin") == null) {
			Login loginForm = new Login(null,null);
			model.put("loginForm",loginForm);
			return "loginAdmin";
		} else {
			if(request.getParameterMap().containsKey("nCommerce")) {
				idCommerce=request.getParameter("nCommerce");
				//TODO Set DAO to activate compte : Status compte commerce et gerant puis generer mdp
			StatusCompteDAO.initCompteCommerce(DBConnexion.getConnection(),idCommerce);
			
				
			}
			
		return "listerDemande";
		}
	}
	
	
	
}
