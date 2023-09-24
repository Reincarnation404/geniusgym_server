package org.example.Dao;

import org.example.brian_background.model.ClassInfoReturn;

import java.util.List;

public interface ClassInfoDao {

	List<ClassInfoReturn> selectAll();
	
}
