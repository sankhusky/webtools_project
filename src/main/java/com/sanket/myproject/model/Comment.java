
  package com.sanket.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
	 *
	 * @author Sanket NUID 001086416
	 */
		  @Entity
		  
		  @Table(name="comments") public class Comment {
		  
		  @Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", user=" + user + ", project=" + project
				+ "]";
	}

		@Id		 
		  @GeneratedValue(strategy= GenerationType.IDENTITY)
		  @Column(name="comment_id")
		  private int commentId;
		  
		  @Column(name="comment") private String comment;
		  
		  @ManyToOne
		  @JoinColumn(name="user_id")		  
		  private User user;
		  
		  @ManyToOne
		  @JoinColumn(name = "project_id")
		  private Project project;
		  
//		  @Column(name="project_id") 
//		  private int projectId;
		  
		  public int getCommentId() { return commentId; }
		  
		  public void setCommentId(int commentId) { this.commentId = commentId; }
		  
		  public String getComment() { return comment; }
		  
		  public void setComment(String comment) { this.comment = comment; }
		  
//		  public int getUserId() { return userId; }
//		  
//		  public void setUserId(int userId) { this.userId = userId; }

		public Project getProject() {
			return project;
		}

		public void setProject(Project project) {
			this.project = project;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		  
		
//		  public int getProjectId() { return projectId; }
		  
//		  public void setProjectId(int projectId) { this.projectId = projectId; }
		  
		  
		  
		  
		  }
		 