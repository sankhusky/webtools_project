package com.sanket.myproject.account;

import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sanket.myproject.model.Comment;
import com.sanket.myproject.model.Project;
import com.sanket.myproject.model.User;

@Component
public class ProjectValidator implements Validator {

	private static final Logger logger = LoggerFactory.getLogger(ProjectValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		logger.info("inside validate method");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectName", "project.name.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectDescription", "project.description.empty");
	
		Project proj = (Project) target;
		proj.setActive(true);
		proj.setComments(new TreeSet<Comment>());
		proj.setInstructorId(0);
		if(proj.getLink()==null && proj.getLink().isEmpty()) {
			proj.setLink("NA");
		}
		proj.setStars(0);
		proj.setSubmittedOn("NA");
		proj.setUser(new User());
	}
	
	
}
