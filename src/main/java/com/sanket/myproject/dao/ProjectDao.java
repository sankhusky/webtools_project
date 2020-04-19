package com.sanket.myproject.dao;

import java.util.List;

import com.sanket.myproject.model.Project;

public interface ProjectDao {

	int storeProject(Project proj);
	
	Project getProject(int projectId);
	
	void updateProject(int projectId, Project project);
	
	void deleteProject(int projectId);
	
	List<Project> getAllProjects();
}
