package org.example.Dao;

import org.example.bean.Notify;

import java.util.List;



public interface NotifyDao {
	int insert(Notify notify);
	
	int delete(Integer nt_id);
	
	int update(Notify notify);
	
	List<Notify> selectALL();
}
