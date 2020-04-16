
  package com.sanket.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
	 *
	 * @author Sanket NUID 001086416
	 */
		  @Entity
		  
		  @Table(name="comments") public class Comment {
		  
		  @Id		 
		  @GeneratedValue(strategy= GenerationType.IDENTITY)
		  @Column(name="comment_id")
		  private int commentId;
		  
		  @Column(name="comment") private String comment;
		  
		  @Column(name="user_id") private int userId;
		  
		  @Column(name="project_id") private int projectId;
		  
		  public int getCommentId() { return commentId; }
		  
		  public void setCommentId(int commentId) { this.commentId = commentId; }
		  
		  public String getComment() { return comment; }
		  
		  public void setComment(String comment) { this.comment = comment; }
		  
		  public int getUserId() { return userId; }
		  
		  public void setUserId(int userId) { this.userId = userId; }
		  
		  public int getProjectId() { return projectId; }
		  
		  public void setProjectId(int projectId) { this.projectId = projectId; }
		  
		  
		  }
		 