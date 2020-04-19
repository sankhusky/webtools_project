package com.sanket.myproject.account;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sanket.myproject.model.UserLogin;

@Component
public class UserLoginValidator implements Validator{

	private static final Logger logger = LoggerFactory.getLogger(UserLoginValidator.class);
	
	/*
	 * @Override public boolean supports(Class<?> clazz) { // TODO Auto-generated
	 * method stub return UserLogin.class.equals(clazz); }
	 */
	
	@Override
    public boolean supports(Class<?> clazz) {
        return true; // always true
    }

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		logger.info("inside validate method");
		
	    ValidationUtils.rejectIfEmpty(errors, "userName", "user.name.empty");
	      ValidationUtils.rejectIfEmpty(errors, "email", "user.email.empty");
	      ValidationUtils.rejectIfEmpty(errors, "password", "user.password.empty");
	      ValidationUtils.rejectIfEmpty(errors, "passwordConfirm", "user.passwordconfirm.empty");

	      UserLogin user = (UserLogin) target;

	      Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	            Pattern.CASE_INSENSITIVE);
	      if (!(pattern.matcher(user.getEmail()).matches())) {
	         errors.rejectValue("email", "user.email.invalid");
	      }

	   }
		
	

}
