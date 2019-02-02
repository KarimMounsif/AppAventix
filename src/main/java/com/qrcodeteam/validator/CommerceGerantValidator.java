package com.qrcodeteam.validator;

import com.qrcodeteam.bom.CommerceGerant;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class CommerceGerantValidator implements Validator {


@Override
public boolean supports(Class<?> clazz) {
	// TODO Auto-generated method stub
	return CommerceGerant.class.equals(clazz);
}

@Override
public void validate(Object target, Errors errors) {
	// TODO Auto-generated method stub
	
	CommerceGerant cg=(CommerceGerant) target;
	
	if(cg.getC().getEffectifCommerce()==0) {
		errors.rejectValue("cg", "errors.required",new Object[] {"c.effectifCommerce"},"Veuillez saisir un effectif");  
        System.out.println("Ici1");
      }
	
}


}