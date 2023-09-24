package org.example.Dao;

import org.example.bean.Branch;

import java.util.List;

public interface BranchDao {

	List<Branch> selectAll();
	
}
