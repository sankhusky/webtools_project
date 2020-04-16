package com.sanket.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;;

/**
*
* @author Sanket
* NUID 001086416
*/
@Entity
@Table(name="users")
public class User {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column(name="user_id")
   private int userId; 
   
   @Column(name="user_type_id")
   private int userTypeId;
   
   @Column(name="user_name")
   private String userName;
   
   @Column(name="email")
   private String email;
   
   @Column(name="password")
   private String password;
   
   @NotNull
   @Column(name="created_on")
   private String createdOn;
   
   @Column(name="is_active")
   private boolean isActive;

   public int getUserId() {
       return userId;
   }

   public void setUserId(int userId) {
       this.userId = userId;
   }

   public int getUserTypeId() {
       return userTypeId;
   }

   public void setUserTypeId(int userTypeId) {
       this.userTypeId = userTypeId;
   }

   public String getUserName() {
       return userName;
   }

   public void setUserName(String userName) {
       this.userName = userName;
   }

   public String getPassword() {
       return password;
   }

   public void setPassword(String password) {
       this.password = password;
   }

   public String getCreatedOn() {
       return createdOn;
   }

   public void setCreatedOn(String createdOn) {
       this.createdOn = createdOn;
   }

   public boolean isIsActive() {
       return isActive;
   }

   public void setIsActive(boolean isActive) {
       this.isActive = isActive;
   }

@Override
public String toString() {
	return "User [userId=" + userId + ", userTypeId=" + userTypeId + ", userName=" + userName + ", password=" + password
			+ ", createdOn=" + createdOn + ", isActive=" + isActive + "]";
}
   
   
   
}
