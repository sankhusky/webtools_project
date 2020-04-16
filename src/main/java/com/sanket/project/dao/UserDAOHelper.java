package com.sanket.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sanket.project.model.User;

@Repository
public class UserDAOHelper implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int storeUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user.getUserId();
	}

	@Override
	public User getUser(int userId) {
		return sessionFactory.getCurrentSession().get(User.class, userId);		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = sessionFactory.getCurrentSession().createQuery("from User").list();
		return userList;
	}

	@Override
	public void updateUser(int userId, User user) {
		Session currSession = sessionFactory.getCurrentSession();
		User oldUser = currSession.byId(User.class).load(userId);
		if(user.getUserName()!=null && !user.getUserName().isEmpty())
			oldUser.setUserName(user.getUserName());	
		
		oldUser.setIsActive(user.isIsActive());
		
		if(user.getPassword()!=null && !user.getPassword().isEmpty())
			oldUser.setPassword(user.getPassword());
//		oldUser.setUserName(user.getUserName());
//		oldUser.setUserName(user.getUserName());
		currSession.flush();
		
	}

	@Override
	public void deleteUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		User delUser = session.byId(User.class).load(userId);
		session.delete(delUser);		
	}

}
