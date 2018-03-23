package com.qrcodeteam.aventix;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qrcodeteam.beans.Entreprise;
import com.qrcodeteam.beans.Employe;
import com.qrcodeteam.beans.EmployeQR;
import com.qrcodeteam.beans.Login;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.EmployeDAO;
import com.qrcodeteam.dao.QRCodeDAO;

@Controller

public class AssignerQRController {
	@RequestMapping(value="/AssignerQR", method = RequestMethod.GET)
	public String ViewListeEmployeSansQR(Map<String,Object> model, HttpSession session) {
		List <Employe> liste = new ArrayList<Employe>();
		if(session.getAttribute("userEntreprise") == null) {
			Login loginForm = new Login(null,null);
			model.put("loginForm",loginForm);
			return "login";
		} else {
			liste = EmployeDAO.ListerEmployeSansQR(DBConnexion.getConnection(), ((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise());
			model.put("liste",liste);
			int i = QRCodeDAO.getAvailableQR(DBConnexion.getConnection(), ((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise());
			model.put("nombreQRdispo", i);
			return "AssignerQR";
		}
	}
	
	@RequestMapping(value="/AssignerQR", method=RequestMethod.POST)
	public String AssignerQRFromList(@RequestParam("idEmploye") String id, HttpSession session) {
		EmployeQR e = new EmployeQR();
		e.getE().setIdEmploye(id);
		EmployeDAO.assignerQRCODE(DBConnexion.getConnection(), e, ((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise());
		return "redirect:/AssignerQR";
	}
}