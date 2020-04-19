package com.sanket.myproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.myproject.dao.ProjectDao;
import com.sanket.myproject.model.Project;

@Service
@Transactional
public class ProjectServiceHelper implements ProjectService {

	@Autowired
	ProjectDao projectDao;

	@Override
	@Transactional
	public int saveProject(Project project) {
		
		return projectDao.storeProject(project);
	}

	@Override
	@Transactional
	public Project getProject(int projectId) {
		// TODO Auto-generated method stub
		return projectDao.getProject(projectId);
	}

	@Override
	@Transactional
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return projectDao.getAllProjects();
	}

	@Override
	@Transactional
	public void updateProject(int projectId, Project project) {
		
		projectDao.updateProject(projectId, project);
		
	}

	@Override
	@Transactional
	public void deleteProject(int projectId) {
		projectDao.deleteProject(projectId);
		
	}
}
