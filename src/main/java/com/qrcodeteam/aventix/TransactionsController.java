package com.qrcodeteam.aventix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qrcodeteam.beans.Entreprise;
import com.qrcodeteam.beans.Login;
import com.qrcodeteam.beans.Transaction;
import com.qrcodeteam.beans.Achat;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.TransactionsDAO;

@Controller
public class TransactionsController {
	@RequestMapping(value="/ListerTransactions", method = RequestMethod.GET)
	public String ViewTransactions (Map<String,Object> model, HttpSession session) {
		List<Transaction> listeTransacs = new ArrayList<Transaction>();
		if(session.getAttribute("userEntreprise") == null) {
			Login loginForm = new Login(null,null);
			model.put("loginForm",loginForm);
			return "login";
		} else {
			listeTransacs=TransactionsDAO.ListerTransactions(DBConnexion.getConnection(), ((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise());
			model.put("listeachat", listeTransacs);
			return "listerTransactions";
		}
	}
}
