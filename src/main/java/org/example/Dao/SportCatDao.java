package org.example.Dao;

import org.example.bean.SportCat;

import java.util.List;


public interface SportCatDao {
	int insert(SportCat sportCat);
	
	int delete(Integer sc_id);
	
	int update(SportCat sportCat);
	
	List<SportCat> selectAll();
}
