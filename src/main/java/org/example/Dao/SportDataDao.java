package org.example.Dao;

import org.example.bean.SportData;

import java.util.List;


public interface SportDataDao {
	int insert(SportData sportData);
	
	int deleteSet(String sd_record_id);
	
	List<SportData> selectAll();
}
