package org.example.Dao;

import org.example.bean.Coach;

import java.util.List;



public interface CoachDao {
	 int insert(Coach coach);
	 
	 int unRegisterById(Coach coach);
	 
	 int updateById(Coach coach);
	 
	 List<Coach> selectAll();
}
