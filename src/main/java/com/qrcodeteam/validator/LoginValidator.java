package com.qrcodeteam.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.qrcodeteam.beans.Login;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Login.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		Login login = (Login) target;
		Pattern pattern;
		Matcher matcher = null;
	    final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		if(login.getLogin().equals("")) {
			
			errors.rejectValue("login", "errors.required",new Object[] {"login"},"Veuillez Saisir votre email");  
	        System.out.println("Ici1");
	      }else {
	    	  pattern=Pattern.compile(EMAIL_PATTERN);
	    	  matcher=pattern.matcher(login.getLogin());
	    	  if(!matcher.matches()) {
	    		errors.rejectValue("login", "errors.required",new Object[] {"pdf"},"Veuillez saisir un mail valide");
	    	  }
	      }
		if(login.getMdp().equals("")) {
			errors.rejectValue("login", "errors.required",new Object[] {"mdp"},"Veuillez Saisir un mot de passe"); 
			System.out.println("Ici2");
			
		}
		
		
	}

}
