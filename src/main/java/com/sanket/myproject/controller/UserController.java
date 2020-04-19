package com.sanket.myproject.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sanket.myproject.account.UserValidator;
import com.sanket.myproject.model.User;
import com.sanket.myproject.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public String displayRegistration(ModelMap model) {
		model.put("userData", new User());
		return "registration";
	}
	
	public String registerUser(ModelMap model, @ModelAttribute("userData") @Valid User user, BindingResult br, HttpSession session) {
		UserValidator userValidator = new UserValidator();
		userValidator.validate(userValidator, br);
		if(br.hasErrors()) { 
			return "registration";
		}else {
			userService.storeUser(user);
			session.setAttribute("user", user);
			return "redirect:success";
		}
	}
}
