package com.sanket.myproject.dao;

import java.util.List;

import com.sanket.myproject.model.User;

public interface UserDao {

	int storeUser(User user);
	
	User getUser(int userId);
	
	List<User> getAllUsers();
	
	void updateUser(int userId, User user);
	
	void deleteUser(int userId);
	
	User getUserByEmail(String userName);
	
	User loginUser(User user);
}
