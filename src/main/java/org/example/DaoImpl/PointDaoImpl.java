package org.example.DaoImpl;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.zaxxer.hikari.HikariDataSource;
import org.example.Dao.PointDao;
import org.example.bean.Point;

import static org.example.util.CommonConstants.route;


public class PointDaoImpl implements PointDao {
	private HikariDataSource ds;
	public PointDaoImpl(){
		try {
			ds = (HikariDataSource) new InitialContext().lookup(route);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insert(Point point) {
		
		String sql = "INSERT INTO point ("
				+ "p_id" //ID p_id
				+ "m_id" //會員 ID m_id
				+ "p_left" //點數餘額 p_left
				+ "p_card" //信用卡綁定 p_card
				+ "p_rec" //點數交易記錄（課程花費 / 點數儲值 ） p_rec
				+ "p_modi_time" //點數異動時間 p_modi_time
				+ ") VALUES(?,?,?,?,?,NOW())";
		return 0;
	}

	@Override
	public List<Point> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point selectById(Point point) {
		// TODO Auto-generated method stub
		return null;
	}

}
