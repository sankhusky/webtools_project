package com.sanket.myproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.myproject.account.BCryptUtils;
import com.sanket.myproject.dao.UserDao;
import com.sanket.myproject.model.User;


@Service
public class UserServiceHelper implements UserService {

	@Autowired
	private UserDao userDao;
	
//	@Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	@Transactional
	public int storeUser(User user) {	
		user.setPassword(BCryptUtils.hashPassword(user.getPassword()));
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

	@Override
	@Transactional
	public User getUserByUserName(String userName) {		
		return userDao.getUserByEmail(userName);
	}

	@Override
	public User loginUser(User user) {		
		return userDao.loginUser(user);
	}

	
}
