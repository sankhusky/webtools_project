package com.sanket.myproject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sanket.myproject.model.Project;
import com.sanket.myproject.service.ProjectService;

@Controller
@RequestMapping(value = "/")
public class DashboardController {
	
	@Autowired
	private ProjectService projectService;
	
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String displayMainDashboard(ModelMap model, HttpSession session) {
//		List<Project> allProjects = projectService.getAllProjects();
//		model.put("projectList", allProjects);
		return "dashboard/dashboard"; 
	}
	
}
