package com.sanket.myproject.service;

import java.util.List;

import com.sanket.myproject.model.Project;

public interface ProjectService {
	
	int saveProject(Project project);
	Project getProject(int projectId);
	List<Project> getAllProjects();
	void updateProject(int projectId, Project project);
	void deleteProject(int projectId);

}
