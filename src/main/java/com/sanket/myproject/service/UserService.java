package com.sanket.myproject.service;

import java.util.List;

import com.sanket.myproject.model.User;

public interface UserService {

int storeUser(User user);
	
	User getUser(int userId);
	
	List<User> getAllUsers();
	
	void updateUser(int userId, User user);
	
	void deleteUser(int userId);
	
	User getUserByUserName(String userName);
	
	User loginUser(User user);
}
