package org.example.Service;

import org.example.bean.Coach;

import java.util.List;


public interface CoachService {
	
	boolean register(Coach coach);
	
	boolean editCoach(Coach coach);
	
	boolean editSuspend(Coach coach);

	List<Coach> findAll();

	

}
