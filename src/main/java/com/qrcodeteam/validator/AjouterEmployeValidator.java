package com.qrcodeteam.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.qrcodeteam.beans.Employe;
import com.qrcodeteam.beans.EmployeQR;
import com.qrcodeteam.beans.Login;
import com.qrcodeteam.dao.DBConnexion;
import com.qrcodeteam.dao.EmployeDAO;

public class AjouterEmployeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Login.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmployeQR e = (EmployeQR) target;
		Pattern pattern;
		Matcher matcher = null;
	    final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	    final String TELEPHONE_PATTERN = "[0-9]{9}";
	    if(e.getE().getMailEmploye().equals("")) {
			errors.rejectValue("mailEmploye", "errors.required",new Object[] {"mailEmploye"},"Veuillez Saisir votre email");  
	        System.out.println("Mail non fourni");
	      } else {
	    	  pattern=Pattern.compile(EMAIL_PATTERN);
	    	  matcher=pattern.matcher(e.getE().getMailEmploye());
	    	  if(!matcher.matches()) {
	    		errors.rejectValue("mailEmploye", "errors.required",new Object[] {"mailEmploye"},"Veuillez saisir un mail valide");
	    	  }
	    	  if(EmployeDAO.CheckDoublon(DBConnexion.getConnection(), e.getE().getMailEmploye())==1) {
	    		  errors.rejectValue("mailEmploye", "errors.required", new Object[] {"mailEmploye"}, "L'utilisateur existe d�j�");
	    	  }
	      }
	    if(e.getE().getNomEmploye().equals("")) {
	    	errors.rejectValue("nomEmploye", "errors.required",new Object[] {"nomEmploye"},"Veuillez saisir le nom");
	    	System.out.println("Nom non fourni");
	    }
	    
	    if(e.getE().getPrenomEmploye().equals("")) {
	    	errors.rejectValue("prenomEmploye", "errors.required",new Object[] {"prenomEmploye"},"Veuillez saisir le pr�nom");
	    	System.out.println("Pr�nom non fourni");
	    }

	    if (e.getE().getTelEmploye().length() == 0) {
	    	errors.rejectValue("telEmploye", "errors.required",new Object[] {"telEmploye"},"Veuillez Saisir le num�ro de telephone");  
	        System.out.println("Tel non fourni");
	    } else {
	    	pattern=Pattern.compile(TELEPHONE_PATTERN);
	    	matcher = pattern.matcher(e.getE().getTelEmploye());
	    	if(!matcher.matches()) {
	    		errors.rejectValue("telEmploye", "errors.required",new Object[] {"telEmploye"},"Veuillez saisir un numero valide");
	    	}
	    }
	}
	
	public void validatemodif(Object target, Errors errors, String mail) {
		Employe e = (Employe) target;
		Pattern pattern;
		Matcher matcher = null;
	    final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	    final String TELEPHONE_PATTERN = "[0-9]{9}";
	    if(e.getMailEmploye().equals("")) {
			errors.rejectValue("mailEmploye", "errors.required",new Object[] {"mailEmploye"},"Veuillez Saisir votre email");  
	        System.out.println("Mail non fourni");
	      } else {
	    	  pattern=Pattern.compile(EMAIL_PATTERN);
	    	  matcher=pattern.matcher(e.getMailEmploye());
	    	  if(!matcher.matches()) {
	    		errors.rejectValue("mailEmploye", "errors.required",new Object[] {"mailEmploye"},"Veuillez saisir un mail valide");
	    	  }
	    	  if(e.getMailEmploye().equals(mail)) {
	    		  if(EmployeDAO.CheckDoublon(DBConnexion.getConnection(), e.getMailEmploye())==1) {
		    		  errors.rejectValue("mailEmploye", "errors.required", new Object[] {"mailEmploye"}, "Email d�j� utilis�");
		    	  }
	    	  }
	      }
	    if(e.getNomEmploye().equals("")) {
	    	errors.rejectValue("nomEmploye", "errors.required",new Object[] {"nomEmploye"},"Veuillez saisir le nom");
	    	System.out.println("Nom non fourni");
	    }
	    
	    if(e.getPrenomEmploye().equals("")) {
	    	errors.rejectValue("prenomEmploye", "errors.required",new Object[] {"prenomEmploye"},"Veuillez saisir le pr�nom");
	    	System.out.println("Pr�nom non fourni");
	    }

	    if (e.getTelEmploye().length() == 0) {
	    	errors.rejectValue("telEmploye", "errors.required",new Object[] {"telEmploye"},"Veuillez Saisir le num�ro de telephone");  
	        System.out.println("Tel non fourni");
	    } else {
	    	pattern=Pattern.compile(TELEPHONE_PATTERN);
	    	matcher = pattern.matcher(e.getTelEmploye());
	    	if(!matcher.matches()) {
	    		errors.rejectValue("telEmploye", "errors.required",new Object[] {"telEmploye"},"Veuillez saisir un numero valide");
	    	}
	    }
	}
}