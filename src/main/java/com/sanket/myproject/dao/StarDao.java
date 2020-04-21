package com.sanket.myproject.dao;

import com.sanket.myproject.model.Star;

public interface StarDao {
	
	int addStar(Star star);
	
	void removeStar(int starId);

	Star getStar(int pid, int userId);

}
