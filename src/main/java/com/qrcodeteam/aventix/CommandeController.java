package com.qrcodeteam.aventix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qrcodeteam.beans.Commande;
import com.qrcodeteam.beans.Entreprise;
import com.qrcodeteam.beans.Qrcode;
import com.qrcodeteam.dao.CommandeDAO;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.utilitaire.CommandeUtils;
import com.qrcodeteam.utilitaire.IdentifiantGenerateur;
import com.qrcodeteam.utilitaire.JsonResponse;


@Controller
public class CommandeController {
	private static final Logger logger = LoggerFactory.getLogger(CommandeController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/commandeQrcode", method = RequestMethod.GET)
	public String viewCommandeQrCode(Map<String, Object> model,HttpSession session) {
		logger.info("Passer Commande QR Code view");
		

		//Commande commandeForm=new Commande();	
		//model.put("commandeForm",commandeForm);
		return "commandeQrcode";
		
	}
	
	
	
	@RequestMapping(value = "/commandeQrcode",method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE },headers="Accept=application/json")
	
	public @ResponseBody JsonResponse processCommandeQrCode(Map<String, Object> model,@RequestParam("qte") int qte,HttpSession session) {
		JsonResponse jsr=new JsonResponse(false,null,null);
		List <Qrcode> listQrCode = null;
		float prixUnitaireQrCode=(float) 9.99;
		System.out.println("le nombre de Qr code commandé ==>"+qte);
		
		// créer commande
		Commande commande= new Commande();
		commande.setDateCommande(new DateTime());
		//commande.setIdEntreprise(((Entreprise)session.getAttribute("userEntreprise")).getIdEntreprise());
		commande.setIdEntreprise("X39Lf");
		commande.setIdCommande(IdentifiantGenerateur.generatorIdentifiant(8));
		commande.setPrixCommande(CommandeUtils.calculPrixCommande((float)9.99, qte));
		commande.setQuantiteCommande(qte);
		commande.setStatusLivraison(0);
		
		// génération des QRcodes
		//listQrCode=IdentifiantGenerateur.generatorListQR(qte,(Entreprise)session.getAttribute("userEntreprise"),prixUnitaireQrCode,commande);
		
		Entreprise e = new Entreprise();
		e.setIdEntreprise("X39Lf");
		listQrCode=IdentifiantGenerateur.generatorListQR(qte,e,prixUnitaireQrCode,commande);
		
		// Persister commande et Qrcode : finaliser commande puis livrer QRcode à Employe.
		
		jsr=CommandeDAO.commanderQRcode(DBConnexion.getConnection(), commande, listQrCode);
		
		
		
		return jsr;
	}
}
