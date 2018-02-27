package com.qrcodeteam.aventix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qrcodeteam.beans.Commande;
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
		System.out.println("le nombre de Qr code commandé ==>"+qte);
		try        
		{
		    Thread.sleep(5000);
		    jsr.setValidated(true);
		    
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
		
		return jsr;
	}
}
