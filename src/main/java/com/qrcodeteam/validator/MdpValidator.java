package com.qrcodeteam.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.qrcodeteam.beans.Login;
import com.qrcodeteam.beans.Mdp;

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
