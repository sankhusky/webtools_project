package com.sanket.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stars")
public class Star {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "star_id", updatable = false, nullable = false)
	private int starId;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private User user;
	
	/*
	 * @Column(name="project_id") private int projectId;
	 */
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	public int getStarId() {
		return starId;
	}

	public void setStarId(int starId) {
		this.starId = starId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	

	
//TODO implmement composite key for projectid and userid if possible	
}
