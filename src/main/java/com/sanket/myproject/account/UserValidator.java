package com.sanket.myproject.account;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sanket.myproject.model.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
