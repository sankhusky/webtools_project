package com.sanket.myproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sanket.myproject.account.ProjectValidator;
import com.sanket.myproject.model.Project;
import com.sanket.myproject.model.Star;
import com.sanket.myproject.model.StarResponse;
import com.sanket.myproject.model.User;
import com.sanket.myproject.service.ProjectService;
import com.sanket.myproject.service.StarService;

@Controller
@RequestMapping(value = "/")
public class DashboardController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectValidator projectValidator;
	
	@Autowired
	private StarService starService;
	
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
	
	@ResponseBody
	@RequestMapping( value= "/dashboard/addstar", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, headers="Accept=*/*")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> addStar(ModelMap model, HttpSession session, @RequestParam int pid) {
		logger.info("star pressed, pid="+ pid );
		User currentUser = (User)session.getAttribute("user");
		Project prj = projectService.getProject(pid);
		
		String cssClass = prj.getStarState(currentUser.getUserId());
		int starCount= prj.getStarCount() ;
		logger.info("star pressed" + pid+ ", "+  currentUser.getUserName());
		
		
	
		 if(starService.getStar(pid,currentUser.getUserId())==null) {
		 Star str = new Star();
		 str.setProject(prj);
		 str.setUser(currentUser);
		 logger.info("Adding star to DB");
		 int sid = starService.addStar(str);
		 logger.info("star added with id=" + sid);
		 starCount = prj.getStarCount() + 1;		
		 cssClass = "star";
		}else { //unstarred			
			if(prj.getStar(currentUser.getUserId())!=null) {
				starService.removeStar(prj.getStar(currentUser.getUserId()).getStarId());	
				starCount--;
				cssClass="";
			}else {
				logger.error("Unable to unstar!! Star is null/no such star found in project!");
			}
		}
		 StarResponse response = new StarResponse();
		 response.setCssClass(cssClass);
		 response.setStarCount(String.valueOf(starCount));
//		 return "{\"starCount\": "+starCount+" \"cssclass\":\""+cssClass+"\"}";
//		 return response;
		 HashMap<String,String> resp = new HashMap<String,String>();
		 resp.put("starCount", String.valueOf(starCount));
		 resp.put("cssClass", cssClass);
		 return ResponseEntity.ok().body(response);
	}
	
}
