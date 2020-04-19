package com.sanket.myproject.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sanket.myproject.account.BCryptUtils;
import com.sanket.myproject.model.User;

@Repository
public class UserDAOHelper implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int storeUser(User user) {
		try {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(user);
		sessionFactory.getCurrentSession().getTransaction().commit();
		return user.getUserId();
		} catch (HibernateException e) {
            e.printStackTrace();
            sessionFactory.getCurrentSession().getTransaction().rollback();
        } finally {
        	sessionFactory.getCurrentSession().close();
        }
		return -1;
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

	@Override
	public User loginUser(User user) {
		String hql = "FROM users WHERE user_name = :userName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("userName", user.getUserName());
		List<User> userList = query.list();
		if(userList!=null) {
			User returnedUser = userList.get(0);
			if(BCryptUtils.checkPass(user.getPassword(), returnedUser.getPassword())) {
				return returnedUser;
			}
		}
		return null;
	}

	@Override
	public User getUserByEmail(String userName) {
		return sessionFactory.getCurrentSession().get(User.class, userName);
	}

}
