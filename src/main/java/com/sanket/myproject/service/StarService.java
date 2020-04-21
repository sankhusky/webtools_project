package com.sanket.myproject.service;

import com.sanket.myproject.model.Star;

public interface StarService {

	int addStar(Star star);
	
	void removeStar(int starId);

	Star getStar(int pid, int userId);
}
