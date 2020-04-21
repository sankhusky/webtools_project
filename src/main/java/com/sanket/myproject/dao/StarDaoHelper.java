package com.sanket.myproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sanket.myproject.model.Star;
import com.sanket.myproject.model.User;

@Repository
@Transactional
public class StarDaoHelper implements StarDao{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public int addStar(Star star) {
		sessionFactory.getCurrentSession().save(star);
		return star.getStarId(); 
	}


	@Override
	public void removeStar(int starId) {
		Session session = sessionFactory.getCurrentSession();
		Star str = sessionFactory.getCurrentSession().byId(Star.class).load(starId);
		session.delete(str);		
	}


	@Override
	public Star getStar(int pid, int userId) {
		String hql = "FROM Star WHERE user_id = :userId AND project_id= :pid";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("pid", pid);
		query.setParameter("userId", userId);
		List<Star> starList = query.list();
		if(starList!=null && starList.size()>0) {
			return starList.get(0);
		}
		return null;
	}
	
	

}
