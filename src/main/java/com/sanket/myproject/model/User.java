package com.sanket.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;;

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
   
   @NotNull
   @Size(min=2,max=30)
   @Column(name="user_name")
   private String userName;
   
   @NotNull
   @Column(name="email")
   private String email;
   
   @NotNull
   @Column(name="password")
   private String password;
   
//   @Column(name="created_on")
   @Transient
   private String createdOn;
   
   @Column(name="is_active")
   private boolean isActive;
  
   @Transient
   private String passwordConfirm; 
   @Transient
   private String userType;
   
   
   
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


   
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public boolean isActive() {
	return isActive;
}

public void setActive(boolean isActive) {
	this.isActive = isActive;
}

public String getPasswordConfirm() {
	return passwordConfirm;
}

public void setPasswordConfirm(String passwordConfirm) {
	this.passwordConfirm = passwordConfirm;
}



public String getUserType() {
	return userType;
}

public void setUserType(String userType) {
	this.userType = userType;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", userTypeId=" + userTypeId + ", userName=" + userName + ", password=" + password
			+ ", createdOn=" + createdOn + ", isActive=" + isActive + "]";
}
   
   
   
}
