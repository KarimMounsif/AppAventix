package com.qrcodeteam.aventix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qrcodeteam.beans.Commerce;
import com.qrcodeteam.beans.CommerceGerant;
import com.qrcodeteam.beans.Entreprise;
import com.qrcodeteam.beans.EntrepriseEmploye;
import com.qrcodeteam.beans.Login;
import com.qrcodeteam.dao.AdminDAO;
import com.qrcodeteam.dao.DBConnexion;


@Controller
public class ListerPartenaireController {
	@RequestMapping(value="/listerPartenaire", method = RequestMethod.GET)
	public String ViewListeAdhesion(Map<String,Object> model, HttpSession session) {
		
		List<CommerceGerant> lCommerce= new ArrayList<CommerceGerant>();
		List<EntrepriseEmploye> lEntreprise = new ArrayList<EntrepriseEmploye>();
		
	if(session.getAttribute("userAdmin") == null) {
			Login loginForm = new Login(null,null);
			model.put("loginForm",loginForm);
			return "loginAdmin";
		} else {
			lCommerce = AdminDAO.listerCommercePartenaire(DBConnexion.getConnection());
			model.put("nbComPartenaire", lCommerce.size());
			model.put("listCommerce",lCommerce);
			lEntreprise = AdminDAO.listerEntreprisePartenaire(DBConnexion.getConnection());
			model.put("nbEntPartenaire", lEntreprise.size());
			model.put("listEntreprise",lEntreprise);
		return "listerPartenaire";
		}
	}
	

}
