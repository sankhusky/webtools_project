package com.sanket.myproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sanket.myproject.model.Project;
import com.sanket.myproject.model.User;

@Repository
@Transactional
public class ProjectDaoHelper implements ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int storeProject(Project proj) {
		sessionFactory.getCurrentSession().save(proj);
		return proj.getProjectId();
	}

	@Override
	public Project getProject(int projectId) {
		return sessionFactory.getCurrentSession().get(Project.class, projectId);
	}

	@Override
	public void updateProject(int projectId, Project project) {
		Session currentSession = sessionFactory.getCurrentSession();
		Project oldproject = currentSession.byId(Project.class).load(projectId);
		oldproject = project;
		
		currentSession.flush();
		
	}

	@Override
	public void deleteProject(int projectId) {
		Session session = sessionFactory.getCurrentSession();
		Project delProject = session.byId(Project.class).load(projectId);
		session.delete(delProject);	
		
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projectList = sessionFactory.getCurrentSession().createQuery("from Project").list();
		return projectList;
	}
	
	
	
	
}
