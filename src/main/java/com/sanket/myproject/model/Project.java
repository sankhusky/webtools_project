package com.sanket.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
 * package com.sanket.project.model;
 * 
 *//**
	 *
	 * @author Sanket NUID 001086416
	 */
		  
		  @Entity
		  
		  @Table(name="projects") public class Project {
		  
		  @Id		  
		  @GeneratedValue(strategy= GenerationType.IDENTITY)
		  @Column(name="project_id")
		  private int projectId;
		  
		  @Column(name="project_name") private String projectName;
		  
//		  @Column(name="user_id") 
//		  private String userId;
		  
		  @ManyToOne
		  @JoinColumn(name = "user_id")
		  private User user;

		  
		  @Transient
		  private String createdOn;
		  
		  @Column(name="project_description") private String projectDescription;
		  
		  @Column(name="link") private String link;
		  
		  @Column(name="is_active") private boolean isActive;
		  
		  @Column(name="stars") private int stars;
		  
		  @Column(name="instructor_id") private int instructorId;
		  
		  @Column(name="submitted_on") private String submittedOn;
		  
		  public int getProjectId() { return projectId; }
		  
		  public void setProjectId(int projectId) { this.projectId = projectId; }
		  
		  public String getProjectName() { return projectName; }
		  
		  public void setProjectName(String projectName) { this.projectName =
		  projectName; }
		  
//		  public String getUserId() { return userId; }
//		  
//		  public void setUserId(String userId) { this.userId = userId; }
//		  
		  public String getCreatedOn() { return createdOn; }
		  
		  public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }
		  
		  public String getProjectDescription() { return projectDescription; }
		  
		  public void setProjectDescription(String projectDescription) {
		  this.projectDescription = projectDescription; }
		  
		  public String getLink() { return link; }
		  
		  public void setLink(String link) { this.link = link; }
		  
		  public boolean isIsActive() { return isActive; }
		  
		  public void setIsActive(boolean isActive) { this.isActive = isActive; }
		  
		  public int getStars() { return stars; }
		  
		  public void setStars(int stars) { this.stars = stars; }
		  
		  public int getInstructorId() { return instructorId; }
		  
		  public void setInstructorId(int instructorId) { this.instructorId =
		  instructorId; }
		  
		  public String getSubmittedOn() { return submittedOn; }
		  
		  public void setSubmittedOn(String submittedOn) { this.submittedOn =
		  submittedOn; }
		  
		  
		  
		  }
		 