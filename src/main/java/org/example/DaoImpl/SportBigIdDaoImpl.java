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
import org.example.Dao.SportBigIdDao;
import org.example.bean.SportBigId;

import static org.example.util.CommonConstants.route;


public class SportBigIdDaoImpl implements SportBigIdDao {
	private HikariDataSource ds;

	public SportBigIdDaoImpl() {
		try {
			ds = (HikariDataSource) new InitialContext().lookup(route);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(SportBigId sportBigId) {
		String sql = "INSERT INTO sport_Bigcat (" + "sb_cat," // 運動分類
				+ "sb_name" // 運動分類
				+ ") VALUES(?,?);";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, sportBigId.getSb_cat());
			pstmt.setString(2, sportBigId.getSb_name());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int delete(Integer sb_id) {
		String sql = "DELETE FROM sport_Bigcat WHERE sb_id=?";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, sb_id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(SportBigId sportBigId) {
		StringBuilder sql = new StringBuilder("UPDATE sport_Bigcat SET ");
		if (sportBigId.getSb_cat() != null) {
			sql.append("sb_cat =?,");
		}
		if (sportBigId.getSb_name() != null) {
			sql.append("sb_name =?,");
		}
		sql.append("sb_name = sb_name WHERE sb_id = ?");
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());				
				){
			int position = 1;
			if  (sportBigId.getSb_cat() != null) {
				pstmt.setString(position, sportBigId.getSb_cat());
				position ++;
			}
			if (sportBigId.getSb_name() != null) {
				pstmt.setString(position, sportBigId.getSb_name());
				position ++;
			}
			pstmt.setInt(position, sportBigId.getSb_id());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<SportBigId> selectAll() {
		String sql = "SELECT * FROM sport_Bigcat";
		List<SportBigId> list = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				SportBigId sportBigId = new SportBigId();

				sportBigId.setSb_cat(rs.getString("sb_cat"));
				sportBigId.setSb_id(rs.getInt("sb_id"));
				sportBigId.setSb_name(rs.getString("sb_name"));

				list.add(sportBigId);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
