package com.sanket.myproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanket.myproject.dao.StarDao;
import com.sanket.myproject.model.Star;

@Service
@Transactional
public class StarServiceHelper implements StarService{

	@Autowired
	StarDao starDao;
	
	@Override
	@Transactional
	public int addStar(Star star) {
		// TODO Auto-generated method stub
		return starDao.addStar(star);
	}

	@Override
	public void removeStar(int starId) {
		starDao.removeStar(starId);
		
	}

	@Override
	public Star getStar(int pid, int userId) {
		return starDao.getStar(pid,userId);
//		return null;
	}

}
