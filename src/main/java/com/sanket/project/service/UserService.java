package com.sanket.project.service;

import java.util.List;

import com.sanket.project.model.User;

public interface UserService {

int storeUser(User user);
	
	User getUser(int userId);
	
	List<User> getAllUsers();
	
	void updateUser(int userId, User user);
	
	void deleteUser(int userId);
}
