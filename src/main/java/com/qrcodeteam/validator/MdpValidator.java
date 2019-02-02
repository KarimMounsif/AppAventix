package com.qrcodeteam.validator;

import com.qrcodeteam.bom.Mdp;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MdpValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Mdp.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Mdp mdp=(Mdp)target;
	}

}
