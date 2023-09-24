package org.example.Dao;

import org.example.bean.Business;

import java.util.List;



public interface BusinessDao {
	int insert(Business business);

	int unRegisterById(Business business);// 此不是真實刪除，

	int updateById(Business business);

	List<Business> selectAll();
}
