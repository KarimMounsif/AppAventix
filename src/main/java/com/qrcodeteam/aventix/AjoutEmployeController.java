package com.qrcodeteam.aventix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qrcodeteam.beans.Employe;
import com.qrcodeteam.beans.EmployeQR;
import com.qrcodeteam.beans.Entreprise;
import com.qrcodeteam.beans.Login;
import com.qrcodeteam.dao.EmployeDAO;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.QRCodeDAO;
import com.qrcodeteam.utilitaire.IdentifiantGenerateur;
import com.qrcodeteam.validator.AjouterEmployeValidator;

@Controller
public class AjoutEmployeController {
	@RequestMapping(value = "/ajouterEmploye", method = RequestMethod.POST)
	public String ProcessAjouterEmploye(Map<String, Object>  model, @ModelAttribute("employeForm") EmployeQR e, RedirectAttributes attr, BindingResult result, HttpSession session) {
		//Validate champs remplis
		AjouterEmployeValidator ajouterEmployeValidator = new AjouterEmployeValidator();
		ajouterEmployeValidator.validate(e, result);
		if(result.hasErrors()) {
			System.out.println("Erreurs dans le formulaire d'ajout employé");
			return "ajouterEmploye";
		} else {
			// Il n'y a aucune erreur dans le formulaire
			e.getE().setIdEmploye(IdentifiantGenerateur.generatorIdentifiant(8));
			e.getE().setTelEmploye("0"+e.getE().getTelEmploye());
			EmployeDAO.insertEmploye(DBConnexion.getConnection(),e,((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise());
			//return "homeEntreprise";
			return "redirect:/ListerEmploye?msg=1";
		}
	}
	
	@RequestMapping(value="/ajouterEmploye", method = RequestMethod.GET)
	public String ViewAjouterEmployeForm(Map<String,Object> model, HttpSession session) {
		if(session.getAttribute("userEntreprise") == null) {
			Login loginForm = new Login(null,null);
			model.put("loginForm",loginForm);
			return "login";
		} else {
			List<String> civiliteList = new ArrayList<String>();
			civiliteList.add("Monsieur");
			civiliteList.add("Madame");
			civiliteList.add("Mademoiselle");
			model.put("civiliteList", civiliteList);
			
			EmployeQR employeForm = new EmployeQR();
			model.put("employeForm", employeForm);
			int i;
			i=QRCodeDAO.getAvailableQR(DBConnexion.getConnection(), ((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise());
			model.put("QRdisponible", i);
			return "ajouterEmploye";
		}
	}
}