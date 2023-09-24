package org.example.Service;

import org.example.bean.ClassInfo;

import java.util.List;



public interface ClassService {

	List<ClassInfo> findAll();

	boolean addInfo(ClassInfo classInfo);

	boolean editClass(ClassInfo classInfo);

	boolean editAvail(ClassInfo classInfo);

}
