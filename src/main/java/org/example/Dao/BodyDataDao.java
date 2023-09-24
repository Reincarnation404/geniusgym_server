package org.example.Dao;

import org.example.bean.BodyData;

import java.util.List;



public interface BodyDataDao {
	int insert(BodyData bodyData);

	int updateById(BodyData bodyData);

	List<BodyData> selectAll();
	
	BodyData selectById(String id);
}
