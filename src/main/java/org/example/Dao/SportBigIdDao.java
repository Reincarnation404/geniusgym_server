package org.example.Dao;

import org.example.bean.SportBigId;

import java.util.List;


public interface SportBigIdDao {
	int insert(SportBigId sportBigId);
	
	int delete(Integer sb_id);
	
	int update(SportBigId sportBigId);
	
	List<SportBigId> selectAll();
}
