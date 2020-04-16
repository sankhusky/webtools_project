package com.sanket.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.project.dao.UserDao;
import com.sanket.project.model.User;

@Service
public class UserServiceHelper implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public int storeUser(User user) {		
		return userDao.storeUser(user);
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		return userDao.getUser(userId);		
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();		
	}

	@Override
	@Transactional
	public void updateUser(int userId, User user) {
		userDao.updateUser(userId, user);
		
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
		
	}

}
