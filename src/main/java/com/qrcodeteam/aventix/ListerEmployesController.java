
package com.qrcodeteam.aventix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qrcodeteam.beans.Employe;
import com.qrcodeteam.beans.Entreprise;
import com.qrcodeteam.beans.Login;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.EmployeDAO;
import com.qrcodeteam.validator.AjouterEmployeValidator;

@Controller
public class ListerEmployesController {
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/ListerEmploye", method = RequestMethod.GET)
	public String ViewListeEmploye(ServletRequest request, Map<String,Object> model, HttpSession session) {
		List<Employe> empsansqr = new ArrayList<Employe>();
		List<Employe> empavecqr = new ArrayList<Employe>();
		//Map<String, String[]> paramMap = request.getParameterMap();
		
		if(session.getAttribute("userEntreprise") == null) {
			Login loginForm = new Login(null,null);
			model.put("loginForm",loginForm);
			return "login";
		} else {
			
			
			if(request.getParameterMap().containsKey("msg") && request.getParameter("msg").equals("1"))
			model.put("msg", "Employe ajouté avec success");
			if(request.getParameterMap().containsKey("msg") && request.getParameter("msg").equals("2"))
			model.put("msg", "Erreur sur l'ajout de l'employe");
			
			empsansqr = EmployeDAO.ListerEmployeSansQR(DBConnexion.getConnection(), ((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise());
			model.put("empsansqr",empsansqr);
			model.put("nbNonAssigned", empsansqr.size());
			empavecqr = EmployeDAO.ListerEmployeAvecQR(DBConnexion.getConnection(), ((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise());
			model.put("empavecqr",empavecqr);
			model.put("nbAssigned", empavecqr.size());
		return "ListerEmploye";
		}
	}
	
	@RequestMapping(value="/modifierEmploye", method = RequestMethod.GET)
	public String ModifierEmploye(Map<String,Object> model, @RequestParam("idEmploye") String id, HttpSession session) {
		if(session.getAttribute("userEntreprise") == null) {
			Login loginForm = new Login(null,null);
			model.put("loginForm",loginForm);
			return "login";
		} else {
			Employe emp = new Employe();
			emp = EmployeDAO.getEmploye(DBConnexion.getConnection(), id, ((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise());
			emp.setTelEmploye(emp.getTelEmploye().substring(1, 10));
			model.put("emp", emp);
			List<String> civilite = new ArrayList<String>();
			civilite.add("Monsieur");
			civilite.add("Madame");
			civilite.add("Mademoiselle");
			model.put("civilite", civilite);
			model.put("mailavantmodif", emp.getMailEmploye());
			return "modifierEmploye";
			
			
		}
	}
	
	@RequestMapping(value="/modifierEmploye", method = RequestMethod.POST)
	public String PersistModificationsEmploye(Map<String,Object> model, @RequestParam("idEmploye") String idemp,@ModelAttribute("mailavantmodif") String mail, @ModelAttribute("emp") Employe emp, BindingResult result, HttpSession session) {
		
		AjouterEmployeValidator ajouterEmployeValidator = new AjouterEmployeValidator();
		ajouterEmployeValidator.validatemodif(emp, result,mail);
		if(result.hasErrors()) {
			System.out.println("Erreurs dans le formulaire de modif d'un employ�");
			return "modifierEmploye";
		} else {		
		emp.setIdEmploye(idemp);
		emp.setTelEmploye("0"+emp.getTelEmploye());
		EmployeDAO.UpdateEmploye(DBConnexion.getConnection(),emp , ((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise());
		return "redirect:/ListerEmploye";
		}
	}
	
	@RequestMapping(value="/supprimerEmploye", method = RequestMethod.POST)
	public String SupprimerEmploye(@RequestParam("idEmploye") String idemp, HttpSession session) {
		EmployeDAO.SupprimerEmploye(DBConnexion.getConnection(), idemp, ((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise());
		return "redirect:/ListerEmploye";
	}
	
	@RequestMapping(value="/rechargerEmploye", method = RequestMethod.POST)
	public String RechargerEmploye(@RequestParam("idEmploye") String idemp, @RequestParam("prix") String prix, HttpSession session) {
		try {
			float prixvalue = Float.parseFloat(prix);
			if (prixvalue>0) {
				EmployeDAO.RechargerEmploye(DBConnexion.getConnection(), idemp, ((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise(),prixvalue);
			}
		} catch (Exception ex) {
			System.out.println("Not a number");
		} finally {
			return "redirect:/ListerEmploye";
		}
	}
}