package org.example.DaoImpl;


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
import org.example.Dao.BusinessDao;
import org.example.bean.Business;

import static org.example.util.CommonConstants.route;


public class BusinessDaoImpl implements BusinessDao {

	private HikariDataSource ds;
	public BusinessDaoImpl(){
		try {
			ds = (HikariDataSource) new InitialContext().lookup(route);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Business business) {
		String sql = "INSERT INTO business (" + "b_id," // 員工 ID b_id
				+ "b_pwd," // 密碼 b_pwd
				+ "b_name," // 員工姓名 b_name
				+ "b_gen," // 性別 b_gen
				+ "b_cell," // 聯絡電話 b_cell
				+ "b_twid," // 身分證字號 b_twid
				+ "b_addr," // 住址 b_addr
				+ "b_start_date," // 入職日期 b_start_date
				+ "b_modi_id," // 修改人 ( 也是員工 b_modi_id
				+ "b_email," // email b_email
			//	+ "bh_id," // 分店 ID bh_id
				+ "bh_name,"
				+ "b_sus," // 是否停權 b_sus
				+ "b_add_time" // 新增時間 b_add_time
				+ ") VALUES(?,?,?,?,?,?,?,?,?,?,?,1,NOW())";
			
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, business.getB_id());
			pstmt.setString(2, business.getB_pwd());
			pstmt.setString(3, business.getB_name());
			pstmt.setInt(4, business.getB_gen());
			pstmt.setString(5, business.getB_cell());
			pstmt.setString(6, business.getB_twid());
			pstmt.setString(7, business.getB_addr());
			pstmt.setTimestamp(8, business.getB_start_date());
			pstmt.setString(9, business.getB_modi_id());
			pstmt.setString(10, business.getB_email());
			//pstmt.setInt(11, business.getBh_id());
			pstmt.setString(11, business.getBh_name());
			//pstmt.setBoolean(12, business.getB_sus());
			System.out.println(sql);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int unRegisterById(Business business) {
		String sql = "UPDATE business SET b_sus = ?, b_modi_time = now() where b_id = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setBoolean(1, business.getB_sus());
			pstmt.setString(2, business.getB_id());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateById(Business business) {
		StringBuilder sql = new StringBuilder("UPDATE business SET ");
		Map<String, Object> fieldMap = new LinkedHashMap<>();
		if (business.getB_pwd() != null && !business.getB_pwd().isEmpty()) {
			fieldMap.put("b_pwd", business.getB_pwd());
		}
		if (business.getB_name() != null && !business.getB_name().isEmpty()) {
			fieldMap.put("b_name", business.getB_name());
		}
		if (business.getB_gen() != null) {
			fieldMap.put("b_gen", business.getB_gen());
		}
		if (business.getB_cell() != null && !business.getB_cell().isEmpty()) {
			fieldMap.put("b_cell", business.getB_cell());
		}
		if (business.getB_twid() != null && !business.getB_twid().isEmpty()) {
			fieldMap.put("b_twid", business.getB_twid());
		}
		if (business.getB_addr() != null && !business.getB_addr().isEmpty()) {
			fieldMap.put("b_addr", business.getB_addr());
		}
		if (business.getB_start_date() != null) {
			fieldMap.put("b_start_date", business.getB_start_date());
		}
//		if (business.getB_modi_id() != null && !business.getB_modi_id().isEmpty()) {
//			fieldMap.put("b_modi_id", business.getB_modi_id());
//		}
		if (business.getB_email() != null && !business.getB_email().isEmpty()) {
			fieldMap.put("b_email", business.getB_email());
		}
//		if (business.getBh_id() != null) {
//			fieldMap.put("bh_id", business.getBh_id());
//		}
		if (business.getB_sus() != null) {
			fieldMap.put("b_sus", business.getB_sus());
		}
		fieldMap.put("b_id", business.getB_id());
		for (String field : fieldMap.keySet()) {
			if(field.equals("b_id")) {
				continue;
			}
			sql.append(field + " =?,");
		}
		
		sql.append("b_modi_time = NOW() WHERE b_id = ?;");
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())
			) {
				System.out.println(sql);
				int position = 1;
				for (Object value : fieldMap.values()) {
					if (value instanceof String) {
						pstmt.setString(position, (String) value);
					} else if (value instanceof Integer) {
						pstmt.setInt(position, (Integer) value);
					} else if (value instanceof Timestamp) {
						pstmt.setTimestamp(position, (Timestamp) value);
					} else if (value instanceof byte[]) {
						pstmt.setBytes(position, (byte[]) value);
					} else if (value instanceof Boolean) {
						pstmt.setBoolean(position, (Boolean) value);
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
	public List<Business> selectAll() {
		String sql = "SELECT * FROM business order by b_sus desc;";
		List<Business> list = new ArrayList<>();
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				Business business = new Business();
				business.setB_id(rs.getString("b_id"));
				business.setB_pwd(rs.getString("b_pwd"));
				business.setB_name(rs.getString("b_name"));
				business.setB_gen(rs.getInt("b_gen"));
				business.setB_cell(rs.getString("b_cell"));
				business.setB_twid(rs.getString("b_twid"));
				business.setB_addr(rs.getString("b_addr"));
				business.setB_start_date(rs.getTimestamp("b_start_date"));
				business.setB_modi_id(rs.getString("b_modi_id"));
				business.setB_email(rs.getString("b_email"));
		//		business.setBh_id(rs.getInt("bh_id"));
				business.setBh_name(rs.getString("bh_name"));
				business.setB_sus(rs.getBoolean("b_sus"));
				business.setB_add_time(rs.getTimestamp("b_add_time"));
				business.setB_modi_time(rs.getTimestamp("b_modi_time"));
				
				list.add(business);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
