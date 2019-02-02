package com.qrcodeteam.controller;

import com.qrcodeteam.bom.*;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.web_app.CreationCompteDAO;
import com.qrcodeteam.utils.IdentifiantGenerateur;
import com.qrcodeteam.validator.CommerceGerantValidator;
import com.qrcodeteam.validator.EntrepriseEmployeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Handles requests for the application home page.
 */
@SessionAttributes("user")
@Controller
public class CreationCompteController {
	
	private static final Logger logger = LoggerFactory.getLogger(CreationCompteController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/creationCompteCommercant", method = RequestMethod.GET)
	public String viewCreerCompteCommercant(Map<String, Object> model,HttpSession session) {
		logger.info("Création de Compte Commercant view");
		
		/*if(session.getAttribute("user") == null) {
		Login loginForm = new Login(null,null);
		model.put("loginForm",loginForm);
		return "login";
		}else {*/

		List<String> civiliteList = new ArrayList<>();
		civiliteList.add("Monsieur");
		civiliteList.add("Madame");
		civiliteList.add("Mademoiselle");

		List<String> typeCommerceList = new ArrayList<>();
		typeCommerceList.add("Bar Kiosque");
		typeCommerceList.add("Boulangerie");
		typeCommerceList.add("Restaurant");
		typeCommerceList.add("Supermarché");
		
		
		CommerceGerant commerceGerantForm=new CommerceGerant(new Commerce(),new Gerant());	
		model.put("commerceGerantForm",commerceGerantForm);
		model.put("civiliteList", civiliteList);
		model.put("typeCommerceList", typeCommerceList);
		return "creationCompteCommercant";
		//}	
	}
	
	@RequestMapping(value = "/creationCompteCommercant", method = RequestMethod.POST)
	public String processCreerCompteCommercant(Map<String, Object>  model,@ModelAttribute("commerceGerantForm") CommerceGerant registerCommerceGerant,  BindingResult result,@RequestParam("file") MultipartFile[] files, HttpSession session) {

				
				// instanciate validator
				CommerceGerantValidator commerceGerantValidator=new CommerceGerantValidator();
				
				// Process validation
				commerceGerantValidator.validate(registerCommerceGerant, result);
				
		        // Présence d'erreur dans le formulaire
				if (result.hasErrors()) {
					
					 System.out.println("il y a des erreurs");
					 
				     //Erreur dans le formulaire 
					 //Remplir le formulaire avec les element precedemment inscrit par l'utilisateur
					 
				 return "creationCompteCommercant";
				 
				}
				else {
					
					// Générer gérantID
					String idGerant=IdentifiantGenerateur.generatorIdentifiant(8);
					registerCommerceGerant.getG().setIdGerant(idGerant);
					
					// Générer commerceID
					String idCommerce=IdentifiantGenerateur.generatorIdentifiant(8);
					registerCommerceGerant.getC().setIdCommerce(idCommerce);
					registerCommerceGerant.getC().setIdGerant(idGerant);
					
					//add gerant to DB
					CreationCompteDAO.insertGerant(DBConnexion.getConnection(), registerCommerceGerant.getG());
					
					//add commerce to DB
					CreationCompteDAO.insertCommerce(DBConnexion.getConnection(), registerCommerceGerant.getC());
					
					//Telecharger les fichiers 
					String message = "";
					for (MultipartFile multipartFile : files) {
						MultipartFile file = multipartFile;
						
						//String name = names[i];
						try {
							byte[] bytes = file.getBytes();

							// Creating the directory to store file
							String rootPath = System.getProperty("catalina.home");
							File dir = new File(rootPath + File.separator + "tmpFiles_"+registerCommerceGerant.getG().getNomGerant()+registerCommerceGerant.getG().getIdGerant());
							if (!dir.exists())
								dir.mkdirs();

							// Create the file on server
							File serverFile = new File(dir.getAbsolutePath()
									+ File.separator + file.getOriginalFilename());
							BufferedOutputStream stream = new BufferedOutputStream(
									new FileOutputStream(serverFile));
							stream.write(bytes);
							stream.close();

							logger.info("Server File Location="+ serverFile.getAbsolutePath());
							
							return "successCreationCompteCommercant";
						} catch (Exception e) {
						
							System.out.println("You failed to upload => " + e.getMessage());
							return "errorlogin";
						}
					}
					
					
				}
				
				return "errorlogin";
			
					
	}
	
	
	
	@RequestMapping(value = "/creationCompteEmployeur", method = RequestMethod.GET)
	public String viewCreerCompteEmployeur(Map<String, Object> model,HttpSession session) {
		logger.info("Création de Compte Entreprise/employeur view");

		EntrepriseEmploye entrepriseEmployeForm=new EntrepriseEmploye(new Entreprise(),new Employe());	
		model.put("entrepriseEmployeForm",entrepriseEmployeForm);
		List<String> civiliteList = new ArrayList();
		civiliteList.add("Monsieur");
		civiliteList.add("Madame");
		civiliteList.add("Mademoiselle");
		model.put("civiliteList", civiliteList);
		return "creationCompteEmployeur";
	
	}
	
	
	@RequestMapping(value="/creationCompteEmployeur", method= RequestMethod.POST)
	public String processCreerCompteEmployeur(Map<String, Object>model, @ModelAttribute("entrepriseEmployeForm") EntrepriseEmploye registerEntrepriseEmploye,  BindingResult result,@RequestParam("file") MultipartFile[] files, HttpSession session) {
		// instanciate validator
		EntrepriseEmployeValidator entrepriseEmployeurValidator=new EntrepriseEmployeValidator();
		
		// Process validation
		entrepriseEmployeurValidator.validate(registerEntrepriseEmploye, result);
		
        // Présence d'erreur dans le formulaire
		if (result.hasErrors()) {
			
			 System.out.println("il y a des erreurs");
			 
		     //Erreur dans le formulaire 
			 //Remplir le formulaire avec les element precedemment inscrit par l'utilisateur
			 
		 return "creationCompteEmployeur";
		 
		}
		else {
			
			// Générer EmployeurID
			String idEmploye=IdentifiantGenerateur.generatorIdentifiant(8);
			registerEntrepriseEmploye.getEmploye().setIdEmploye(idEmploye);
			registerEntrepriseEmploye.getEntreprise().setIdEmploye(idEmploye);
			
			// Générer EntrepriseID
			String idEntreprise=IdentifiantGenerateur.generatorIdentifiant(8);
			registerEntrepriseEmploye.getEntreprise().setIdEntreprise(idEntreprise);
			registerEntrepriseEmploye.getEmploye().setIdEntreprise(idEntreprise);
		
			// TODO changer les deux méthodes par une seule méthode transaction (Atomicité)
			//add commerce to DB
			CreationCompteDAO.insertEntreprise(DBConnexion.getConnection(), registerEntrepriseEmploye.getEntreprise());
			
			//add gerant to DB
			CreationCompteDAO.insertEmployeur(DBConnexion.getConnection(), registerEntrepriseEmploye.getEmploye());
			
			
			
			//Telecharger les fichiers 
			String message = "";
			for (MultipartFile multipartFile : files) {
				MultipartFile file = multipartFile;
				
				//String name = names[i];
				try {
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "tmpFiles_" + registerEntrepriseEmploye.getEmploye().getNomEmploye() + registerEntrepriseEmploye.getEntreprise().getIdEmploye());
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + file.getOriginalFilename());
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					logger.info("Server File Location="+ serverFile.getAbsolutePath());
					
					return "successCreationCompteCommercant";
				} catch (Exception e) {
				
					System.out.println("You failed to upload => " + e.getMessage());
					return "errorlogin";
				}
			}
			
			
		}
		
		return "errorlogin";
		
		
		//return "";
	}
	
	

}
