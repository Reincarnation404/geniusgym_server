package org.example.Dao;

import org.example.bean.Point;

import java.util.List;


public interface PointDao {
	int insert(Point point);

	List<Point> selectAll();

	Point selectById(Point point);
}
