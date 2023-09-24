package org.example.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.zaxxer.hikari.HikariDataSource;
import org.example.Dao.SportCatDao;
import org.example.bean.SportCat;

import static org.example.util.CommonConstants.route;


public class SportCatDaoImpl implements SportCatDao {
	private HikariDataSource ds;
	public SportCatDaoImpl(){
		try {
			ds = (HikariDataSource) new InitialContext().lookup(route);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insert(SportCat sportCat) {
		String sql = "INSERT INTO sport_cat ("
				+ "sb_cat, " //分類
				+ "sc_name" //名稱
				+ ") VALUES(?,?);";
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);			
				){
			pstmt.setInt(1, sportCat.getSb_id());
			pstmt.setString(2, sportCat.getSc_name());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int delete(Integer sc_id) {
		String sql = "DELETE FROM sport_cat WHERE (sc_id = ?);";
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);			
				){
			pstmt.setInt(1, sc_id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(SportCat sportCat) {
		StringBuilder sql = new StringBuilder("UPDATE sport_cat SET ");
		if(sportCat.getSb_id() != null) {
			sql.append("`sb_cat` = ?, ");
		}
		if(sportCat.getSc_name() != null) {
			sql.append("`sc_name` = ?, ");
		}
		sql.append("`sc_name` =`sc_name` WHERE (`sc_id` = ?);");
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());			
				){
			int position = 1;
			if(sportCat.getSb_id() != null) {
				pstmt.setInt(position, sportCat.getSb_id());
				position ++;
			}
			if(sportCat.getSc_name() != null) {
				pstmt.setString(position, sportCat.getSc_name());
				position ++;
			}
			pstmt.setInt(position, sportCat.getSc_id());
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
		
	}

	@Override
	public List<SportCat> selectAll() {
		String sql = "SELECT * FROM sport_cat";
		List<SportCat> list = new ArrayList<SportCat>();
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
				ResultSet rs = pstmt.executeQuery();
				){
			while(rs.next()) {
				SportCat item = new SportCat();
				item.setSb_id(rs.getInt("sb_cat"));
				item.setSc_name(rs.getString("sc_name"));
				item.setSc_id(rs.getInt("sc_id"));
				
				list.add(item);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
