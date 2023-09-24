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
import org.example.Dao.ClassDao;
import org.example.bean.ClassInfo;

import static org.example.util.CommonConstants.route;


public class ClassDaoImpl implements ClassDao {
	private HikariDataSource ds;
	public ClassDaoImpl(){
		try {
			ds = (HikariDataSource) new InitialContext().lookup(route);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<ClassInfo> selectAll() {
		String sql = "SELECT * FROM class_info order by ci_avail desc";
		List<ClassInfo> list = new ArrayList<>();
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				ClassInfo classInfo = new ClassInfo();
				classInfo.setCi_id(rs.getInt("ci_id"));
				classInfo.setCi_name(rs.getString("ci_name"));
				classInfo.setCi_start_time(rs.getTimestamp("ci_start_time"));
				classInfo.setCi_ed_time(rs.getTimestamp("ci_ed_time"));
				classInfo.setCi_place(rs.getString("ci_place"));
				classInfo.setCi_cost(rs.getInt("ci_cost"));
				classInfo.setC_id(rs.getString("c_id"));
				classInfo.setCi_text(rs.getString("ci_text"));
				classInfo.setCi_limit(rs.getInt("ci_limit"));
				classInfo.setBh_id(rs.getInt("bh_id"));
				classInfo.setCi_regi_time(rs.getTimestamp("ci_regi_time"));
				classInfo.setCi_regi_ed_time(rs.getTimestamp("ci_regi_ed_time"));
				classInfo.setB_id(rs.getString("b_id"));
				classInfo.setSc_id(rs.getInt("sc_id"));
				classInfo.setCi_avail(rs.getBoolean("ci_avail"));
				classInfo.setCi_add_time(rs.getTimestamp("ci_add_time"));

				list.add(classInfo);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public int insert(ClassInfo classInfo) {
		String sql = "INSERT INTO class_info ("
				+ "ci_name," //課程名稱
				+ "ci_start_time," //課程開始時間
				+ "ci_ed_time," //課程結束時間
				+ "ci_place," //上課地點
				+ "ci_cost," //點數
				+ "c_id," //教練 c_id
				+ "ci_text," //課程介紹
				+ "ci_limit," //人數上限
				+ "bh_id,"  //分店ID 
				+ "ci_regi_time," //報名時間
				+ "ci_regi_ed_time," //截止時間
				+ "b_id,"  //修改人ID
				+ "sc_id," //運動種類ID
				+ "ci_avail,"
				+ "ci_add_time" //新增時間 c_add_time
				+ ")VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,1,NOW())";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, classInfo.getCi_name());
			pstmt.setTimestamp(2, classInfo.getCi_start_time());
			pstmt.setTimestamp(3, classInfo.getCi_ed_time());
			pstmt.setString(4, classInfo.getCi_place());
			pstmt.setInt(5, classInfo.getCi_cost());
			pstmt.setString(6, classInfo.getC_id());
			pstmt.setString(7, classInfo.getCi_text());
			pstmt.setInt(8, classInfo.getCi_limit());
			pstmt.setInt(9, classInfo.getBh_id());
			pstmt.setTimestamp(10, classInfo.getCi_regi_time());
			pstmt.setTimestamp(11, classInfo.getCi_regi_ed_time());
			pstmt.setString(12, classInfo.getB_id());
			pstmt.setInt(13, classInfo.getSc_id());
		//	pstmt.setBoolean(14,classInfo.getCi_avail());
			System.out.println(sql);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	
	@Override
	public int updateById(ClassInfo classInfo) {
		StringBuilder sql = new StringBuilder("UPDATE class_info SET ");
		Map<String, Object> fieldMap = new LinkedHashMap<>();
		if (classInfo.getCi_name() != null && !classInfo.getCi_name().isEmpty()) {
			fieldMap.put("ci_name", classInfo.getCi_name());
		}
		if (classInfo.getCi_start_time() != null) {
			fieldMap.put("ci_start_time", classInfo.getCi_start_time());
		}
		if (classInfo.getCi_ed_time() != null) {
			fieldMap.put("ci_ed_time", classInfo.getCi_ed_time());
		}
		if (classInfo.getCi_place() != null && !classInfo.getCi_place().isEmpty()) {
			fieldMap.put("ci_place", classInfo.getCi_place());
		}
		if (classInfo.getCi_cost() != null) {
			fieldMap.put("ci_cost", classInfo.getCi_cost());
		}
		if (classInfo.getC_id() != null && !classInfo.getC_id().isEmpty()) {
			fieldMap.put("c_id", classInfo.getC_id());
		}
		if (classInfo.getCi_text() != null && !classInfo.getCi_text().isEmpty()) {
			fieldMap.put("ci_text", classInfo.getCi_text());
		}
		if (classInfo.getB_id() != null && !classInfo.getB_id().isEmpty()) {
			fieldMap.put("b_id", classInfo.getB_id());
		}
		if (classInfo.getCi_limit() != null) {
			fieldMap.put("ci_limit", classInfo.getCi_limit());
		}
		if (classInfo.getBh_id() != null) {
			fieldMap.put("bh_id", classInfo.getBh_id());
		}
		if (classInfo.getCi_avail() != null) {
			fieldMap.put("ci_avail", classInfo.getCi_avail());
		}
		if (classInfo.getCi_regi_time() != null) {
			fieldMap.put("ci_regi_time", classInfo.getCi_regi_time());
		}
		if (classInfo.getCi_regi_ed_time() != null)  {
			fieldMap.put("ci_regi_ed_time", classInfo.getCi_regi_ed_time());
		}
		if(classInfo.getSc_id() != null) {
			fieldMap.put("sc_id", classInfo.getSc_id());
		}
		fieldMap.put("ci_id", classInfo.getCi_id());
		
		for (String field : fieldMap.keySet()) {
			if(field.equals("ci_id")) {
				continue;
			}
			sql.append(field + " =?,");
			
		}
		
		sql.append("ci_modi_time = NOW() WHERE ci_id = ?;");
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())
			) {
				System.out.println(sql);
				int position = 1;
				for (Object value : fieldMap.values()) {
					System.out.println(value);
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
	public int unRegisterById(ClassInfo classInfo) {
		String sql = "UPDATE class_info SET ci_avail = ?, ci_modi_time = now() WHERE (ci_id = ?);";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setBoolean(1, classInfo.getCi_avail());
			pstmt.setInt(2, classInfo.getCi_id());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
}
