package com.sanket.myproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.sanket.myproject.account.ProjectValidator;
import com.sanket.myproject.model.Project;
import com.sanket.myproject.model.User;
import com.sanket.myproject.service.ProjectService;

@Controller
@RequestMapping(value = "/")
public class DashboardController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectValidator projectValidator;
	
	Map<Integer, String> userTypeMap;
	
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	 @InitBinder
	   protected void initBinder(WebDataBinder binder) {
	      binder.addValidators(projectValidator);
	   }
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String displayMainDashboard(ModelMap model, HttpSession session) {
		List<Project> allProjects = projectService.getAllProjects();
		model.put("projectList", allProjects);
		return "dashboard/dashboard"; 
	}
	
	@RequestMapping(value= "/dashboard/createproject", method=RequestMethod.GET)
	public String showCreateProject(ModelMap model, HttpSession session) {
		model.put("projectData", new Project());
		return "project_views/createproject";
		
	}
	
	@RequestMapping(value= "/dashboard/createproject", method=RequestMethod.POST)
	public String createProject(ModelMap model, @ModelAttribute("projectData") @Valid Project project, BindingResult br, HttpSession session) {
		
		
		if (br.hasErrors()) {
			logger.error("validation error--" + br.getFieldError().getDefaultMessage());

				return "project_views/createproject";

		} else {
			project.setCreatedOn(null);
			project.setSubmittedOn(null);
			if(session.getAttribute("user") instanceof User) {
				User currentUser = (User) session.getAttribute("user");				
				project.setUser(currentUser);
			}
			projectService.saveProject(project);
			model.addAttribute("isNewProject", true);
			logger.info("project added successfully");
			return "project_views/createsuccess";
		}
	
		
	}
	
	@RequestMapping( value= "/dashboard/profile", method=RequestMethod.GET)
	public String openProfile(ModelMap model, HttpSession session) {
		userTypeMap = new HashMap<Integer,String>();
		userTypeMap.put( 1,"Student");
		userTypeMap.put( 2,"Teacher Assistant");
		userTypeMap.put(3,"Course Instructor" );
		model.put("userTypes", userTypeMap);
		model.put("projectCount", ((User) session.getAttribute("user")).getProjects().size());
		 return "dashboard/profile";
		
	}
	
}
