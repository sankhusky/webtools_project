package com.sanket.myproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sanket.myproject.account.UserLoginValidator;
import com.sanket.myproject.model.OTP;
import com.sanket.myproject.model.User;
import com.sanket.myproject.model.UserLogin;
import com.sanket.myproject.service.UserService;
import com.sanket.myproject.utils.EmailUtils;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserLoginValidator userLoginValidator;
//	private UserValidator userValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	Map<String,Integer> userTypeMap;
	
	 @InitBinder
	   protected void initBinder(WebDataBinder binder) {
	      binder.addValidators(userLoginValidator);
	   }

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String displayRegistration(ModelMap model) {
		model.put("userData", new UserLogin());
		List<String> userTypeList = new ArrayList<String>();
		userTypeList.add("Student");
//		userTypeList.add("Course Instructor");
		userTypeList.add("Teacher Assistant");
		
		userTypeMap = new HashMap<String,Integer>();
		userTypeMap.put("Student", 1);
		userTypeMap.put("Teacher Assistant", 2);
		userTypeMap.put("Course Instructor", 3);
//		userTypeMap.put("Strudent", 1);
		model.put("userTypeList", userTypeList);		
		return "registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(ModelMap model, @ModelAttribute("userData") @Valid UserLogin user, BindingResult br,
			HttpSession session) {
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(userValidator, br);
		logger.info("inside registerUser");
		//TODO check for preexisting user
		if (br.hasErrors()) {
			logger.error("validation error--" + br.getFieldError().getDefaultMessage());
//			model.put("userData", new UserLogin());
			List<String> userTypeList = new ArrayList<String>();
			userTypeList.add("Student");
//			userTypeList.add("Course Instructor");
			userTypeList.add("Teacher Assistant");
			model.put("userTypeList", userTypeList);
			return "registration";
		} else {
			User realUser = new User();
			realUser.setUserName(user.getUserName());
			realUser.setPassword(user.getPassword());
			realUser.setEmail(user.getEmail());
			realUser.setUserTypeId(userTypeMap.get(user.getUserType()));
			realUser.setIsActive(true);
			
			logger.info("Saving user: "+realUser.toString());
			session.setAttribute("user", realUser);
			logger.info("registration successful");
			Integer otp=EmailUtils.sendOTP(user.getEmail());
			if(otp!=-1) {
				model.addAttribute("otp",new OTP());
				session.setAttribute("otp", otp);
				session.setAttribute("otp_time", new Date());
				logger.info("otp set at approx"+new Date());
				return "userconfirm";				
			}else {
				model.put("action","Registration");
				return "errorpage";
			}
		}
	}

	
	@RequestMapping(value = "/regsuccess", method = RequestMethod.POST)
	public String showSuccess(ModelMap model, @ModelAttribute("otpResponse") OTP otp, HttpSession session, HttpServletRequest req) {
		logger.info("user entered:"+ otp.getOtp() );
		logger.info(req.getParameter("otp"));
		Date sendTime = (Date) session.getAttribute("otp_time");
		Date now = new Date();
		long diff = now.getTime() - sendTime.getTime();
		long diffMinutes = diff / (60 * 1000) % 60;
		logger.info("send time:"+ sendTime.toString() + " Enter time:"+now.toString()+", time difference="+diffMinutes+" min");
		if(diffMinutes>30) {
			model.put("action","Timely user confirmation");
			return "errorpage";
		}else {
			int realOtp = (Integer) session.getAttribute("otp");
			int otp2 =  Integer.parseInt(req.getParameter("otp"));
			if(otp2==realOtp) {
				model.put("success", new User());
				User realUser = (User) session.getAttribute("user");
				userService.storeUser(realUser);
				return "registrationSuccess";				
			}else {
				model.put("action","OTP Verification");
				return "errorpage";
			}
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String displayLogin(ModelMap model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			model.put("userData", new User());
			return "login";
		} else {
			return "redirect:loginsuccess";

		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(ModelMap model, @ModelAttribute("userData") User user, HttpSession session) {
		
		logger.info("you entered: " + user.toString());
		if (user.getUserName() != null && user.getPassword() != null && session.getAttribute("user") == null) {
			logger.info("New login, validating...");
			user = userService.loginUser(user);
//			logger.info("validation done, returned user:"+ user==null ? "null" : user.toString());
			if (user != null) {
				logger.info("Login successful");
				session.setAttribute("user", user);
				return "redirect:loginsuccess";
			}
			logger.info("user object still not found.. ptobably an invalid input");
//			else {
//				model.put("failed", "Login Failed");
			logger.error("Login failed!!");
				return "home";
//			}
		} else {
			User urs = (User) session.getAttribute("user");
			logger.info("User already logged in");
			logger.info(urs.toString());
			return "redirect:loginsuccess";
		}
	}
	
	@RequestMapping(value = "/loginsuccess", method = RequestMethod.GET)
	public ModelAndView showLoginSuccess(ModelMap model, HttpServletRequest request) {
		model.put("success", new User());
		String referer = request.getHeader("referer");
		logger.info("referer:"+ referer);
	    return new ModelAndView("redirect:" + referer + "dashboard", model);
//		return "redirect:myproject/dashboard";
	}
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public String logout(ModelMap model, HttpSession session) {
		session.removeAttribute("user");
		return "home";
	}

}
