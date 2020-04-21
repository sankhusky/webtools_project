package com.sanket.myproject.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sanket.myproject.controller.DashboardController;
import com.sanket.myproject.service.StarService;

/**
	 *
	 * @author Sanket NUID 001086416
	 */

	
		  
		  @Entity
		  
		  @Table(name="projects") public class Project {
			  
//			  @Autowired
//			  private StarService starService;
//		  
			  private static final Logger logger = LoggerFactory.getLogger(Project.class);
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

		  
		  @Column(name="created_on", insertable=false)
		  private String createdOn;
		  
		  @OneToMany(mappedBy="project", fetch = FetchType.EAGER)		  
		  private Set<Comment> comments;
		  
		  @OneToMany(mappedBy="project", fetch = FetchType.EAGER)		  
		  private Set<Star> stars;
		  
		  @Column(name="project_description") private String projectDescription;
		  
		  @Column(name="link") private String link;
		  
		  @Column(name="is_active") private boolean isActive;
		  
		  
		  
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
		  		
		  
		  public int getInstructorId() { return instructorId; }
		  
		  public void setInstructorId(int instructorId) { this.instructorId =
		  instructorId; }
		  
		  public String getSubmittedOn() { return submittedOn; }
		  
		  public void setSubmittedOn(String submittedOn) { this.submittedOn =
		  submittedOn; }

		  
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		public Set<Comment> getComments() {
			return comments;
		}

		public void setComments(Set<Comment> comments) {
			this.comments = comments;
		}

		public Set<Star> getStars() {
			return stars;
		}

		public void setStars(Set<Star> stars) {
			this.stars = stars;
		}

		
		public int getStarCount() {
			return this.stars.size();
		}
	/*
	 * @Override public String toString() { return "Project [projectId=" + projectId
	 * + ", projectName=" + projectName + ", user=" + user + ", createdOn=" +
	 * createdOn + ", comments=" + comments + ", stars=" + stars +
	 * ", projectDescription=" + projectDescription + ", link=" + link +
	 * ", isActive=" + isActive + ", instructorId=" + instructorId +
	 * ", submittedOn=" + submittedOn + "]"; }
	 */
		  
		  
		public String getStarState(int userId) {
			String state = "";

			for(Star str: this.stars) {
				if(str.getUser().getUserId()==userId) {
					state = "star";
					break;
				}
			}
			logger.info("Star state for project id : "+ this.projectId  +", "+ " user:"+userId+" ="+state);
//			if(starService.getStar(this.projectId, userId)!=null) {
//				state="star";
//			}
			return state;
		}

		public Star getStar(int userId) {
			Star resultStr=null;
			for(Star str: this.stars) {
				if(str.getUser().getUserId()==userId) {
					resultStr = str;
					break;
				}
			}
			return resultStr;			
		}
		  
		  
		  
		  }
		 