package org.example.DaoImpl;

import static org.example.util.CommonConstants.route;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.zaxxer.hikari.HikariDataSource;
import org.example.Dao.BodyDataDao;
import org.example.bean.BodyData;


public class BodyDataDaoImpl implements BodyDataDao {
	private HikariDataSource ds;
	public BodyDataDaoImpl(){
		try {
			ds = (HikariDataSource) new InitialContext().lookup(route);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public int insert(BodyData bodyData) {
		String sql = "INSERT INTO body_data (" 
				+ "bd_id" // 健康資料 UUID bd_id
				+ "m_id" // 會員 ID m_id
				+ "bd_hgt" // 身高 bd_hgt
				+ "bd_wgt" // 體重 bd_wgt
				+ "bd_fat" // 體脂 bd_fat
				+ "bd_add_time" // 新增時間 bd_add_time
				+ ") VALUES(?,?,?,?,?,NOW())";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, bodyData.getBd_id());
			pstmt.setString(2, bodyData.getM_id());
			pstmt.setFloat(3, bodyData.getBd_hgt());
			pstmt.setFloat(4, bodyData.getBd_wgt());
			pstmt.setFloat(5, bodyData.getBd_fat());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateById(BodyData bodyData) {
		StringBuilder sql = new StringBuilder("UPDATE body_data SET ");
		Map<String, Object> fieldMap = new LinkedHashMap<>();
		if (bodyData.getM_id() != null) {
			fieldMap.put("m_id", bodyData.getM_id());
		}
		if (bodyData.getBd_hgt() != null) {
			fieldMap.put("bd_hgt", bodyData.getBd_hgt());
		}
		if (bodyData.getBd_wgt() != null) {
			fieldMap.put("bd_wgt", bodyData.getBd_wgt());
		}
		if (bodyData.getBd_fat() != null) {
			fieldMap.put("bd_fat", bodyData.getBd_fat());
		}
		fieldMap.put("bd_id", bodyData.getBd_id());
		sql.append("bd_modi_time = NOW() WHERE bd_id = ?;");
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())
			) {
				int position = 1;
				for (Object value : fieldMap.values()) {
					if (value instanceof String) {
						pstmt.setString(position, (String) value);
					} else if (value instanceof Integer) {
						pstmt.setInt(position, (Integer) value);
					} else if (value instanceof Timestamp) {
						pstmt.setTimestamp(position, (Timestamp) value);
					} else if (value instanceof Float) {
						pstmt.setFloat(position, (Float) value);
					}
					position++;
				}
				return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;
	}

	@Override
	public List<BodyData> selectAll() {
		String sql = "SELECT * FROM body_data;";
		List<BodyData> list = new ArrayList<>();
		BodyData bodyData = new BodyData();
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				bodyData.setBd_id(rs.getInt("bd_id"));
				bodyData.setM_id(rs.getString("m_id"));
				bodyData.setBd_hgt(rs.getFloat("bd_hgt"));
				bodyData.setBd_wgt(rs.getFloat("bd_wgt"));
				bodyData.setBd_fat(rs.getFloat("bd_fat"));
				bodyData.setBd_add_time(rs.getTimestamp("bd_add_time"));
				bodyData.setBd_update_time(rs.getTimestamp("bd_update_time"));
				
				list.add(bodyData);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BodyData selectById(String id) {
		String sql = "SELECT * FROM body_data WHERE m_id = ?;";
		BodyData bodyData = new BodyData();
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
		){
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				bodyData.setBd_id(rs.getInt("bd_id"));
				bodyData.setM_id(rs.getString("m_id"));
				bodyData.setBd_hgt(rs.getFloat("bd_hgt"));
				bodyData.setBd_wgt(rs.getFloat("bd_wgt"));
				bodyData.setBd_fat(rs.getFloat("bd_fat"));
				bodyData.setBd_add_time(rs.getTimestamp("bd_add_time"));
				bodyData.setBd_update_time(rs.getTimestamp("bd_update_time"));
			}
			return bodyData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
