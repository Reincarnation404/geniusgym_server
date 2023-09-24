package org.example.Dao;

import org.example.bean.ClassInfo;

import java.util.List;


public interface ClassDao {

	List<ClassInfo> selectAll();

	int insert(ClassInfo classInfo);

	int updateById(ClassInfo classInfo);

	int unRegisterById(ClassInfo classInfo);

}
