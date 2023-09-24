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
import org.example.Dao.CoachDao;
import org.example.bean.Coach;

import static org.example.util.CommonConstants.route;


public class CoachDaoImpl implements CoachDao {
	private HikariDataSource ds;
	public CoachDaoImpl(){
		try {
			ds = (HikariDataSource) new InitialContext().lookup(route);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Coach coach) {
		String sql = "INSERT INTO coach ("
				+ "c_id," //教練 ID c_id
				+ "c_pwd," //密碼 c_pwd
				+ "c_name," //教練名字 c_name
				+ "c_gen," //性別 c_gen
				+ "c_cell," //聯絡電話 c_cell
				+ "c_twid," //身分證字號 c_twid
				+ "c_addr," //住址 c_addr
				+ "c_start_date," //入職日期 c_start_date
				+ "b_id," //修改人 ID b_id
				+ "c_email," //email c_email
				+ "c_intro," //註解( 可以打經歷 ) c_intro
				+ "c_sus," //是否停權 c_sus
				+ "c_pic," //大頭貼 c_pic
		//		+ "bh_id" //分店 ID bh_id
				+ "bh_name,"  //分店名稱 bh_name
				+ "c_add_time" //新增時間 c_add_time
				+ ")VALUES (?,?,?,?,?,?,?,?,?,?,?,1,?,?,NOW())";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, coach.getC_id());
			pstmt.setString(2, coach.getC_pwd());
			pstmt.setString(3, coach.getC_name());
			pstmt.setInt(4, coach.getC_gen());
			pstmt.setString(5, coach.getC_cell());
			pstmt.setString(6, coach.getC_twid());
			pstmt.setString(7, coach.getC_addr());
			pstmt.setTimestamp(8, coach.getC_start_date());
			pstmt.setString(9, coach.getB_id());
			pstmt.setString(10, coach.getC_email());
			pstmt.setString(11, coach.getC_intro());
		//	pstmt.setBoolean(12, coach.getC_sus());
			pstmt.setBytes(12, coach.getC_pic());
			pstmt.setString(13, coach.getBh_name());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int unRegisterById(Coach coach) {
		String sql = "UPDATE coach SET c_sus = ?, c_modi_time = now() WHERE (c_id = ?);";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setBoolean(1, coach.getC_sus());
			pstmt.setString(2, coach.getC_id());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateById(Coach coach) {
		StringBuilder sql = new StringBuilder("UPDATE coach SET ");
		Map<String, Object> fieldMap = new LinkedHashMap<>();
		if (coach.getC_pwd() != null && !coach.getC_pwd().isEmpty()) {
			fieldMap.put("c_pwd", coach.getC_pwd());
		}
		if (coach.getC_name() != null && !coach.getC_name().isEmpty()) {
			fieldMap.put("c_name", coach.getC_name());
		}
		if (coach.getC_gen() != null) {
			fieldMap.put("c_gen", coach.getC_gen());
		}
		if (coach.getC_cell() != null && !coach.getC_cell().isEmpty()) {
			fieldMap.put("c_cell", coach.getC_cell());
		}
		if (coach.getC_twid() != null && !coach.getC_twid().isEmpty()) {
			fieldMap.put("c_twid", coach.getC_twid());
		}
		if (coach.getC_addr() != null && !coach.getC_addr().isEmpty()) {
			fieldMap.put("c_addr", coach.getC_addr());
		}
		if (coach.getC_start_date() != null) {
			fieldMap.put("c_start_date", coach.getC_start_date());
		}
		if (coach.getB_id() != null && !coach.getB_id().isEmpty()) {
			fieldMap.put("b_id", coach.getB_id());
		}
		if (coach.getC_email() != null && !coach.getC_email().isEmpty()) {
			fieldMap.put("c_email", coach.getC_email());
		}
		if (coach.getC_intro() != null && !coach.getC_intro().isEmpty()) {
			fieldMap.put("c_intro", coach.getC_intro());
		}
//		if (coach.getC_sus() != null) {
//			fieldMap.put("c_sus", coach.getC_sus());
//		}
		if (coach.getC_pic() != null) {
			fieldMap.put("c_pic", coach.getC_pic());
		}
		if (coach.getBh_id() != null)  {
			fieldMap.put("bh_id", coach.getBh_id());
		}
		if(coach.getBh_name() != null) {
			fieldMap.put("bh_name", coach.getBh_name());
		}
		fieldMap.put("c_id", coach.getC_id());
		
		for (String field : fieldMap.keySet()) {
			if(field.equals("c_id")) {
				continue;
			}
			sql.append(field + " =?,");
		}
		
		sql.append("c_modi_time = NOW() WHERE c_id = ?;");
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
	public List<Coach> selectAll() {
		String sql = "SELECT * FROM coach order by c_sus desc";
		List<Coach> list = new ArrayList<>();
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				Coach coach = new Coach();
				coach.setC_id(rs.getString("c_id"));
				coach.setC_pwd(rs.getString("c_pwd"));
				coach.setC_name(rs.getString("c_name"));
				coach.setC_gen(rs.getInt("c_gen"));
				coach.setC_cell(rs.getString("c_cell"));
				coach.setC_twid(rs.getString("c_twid"));
				coach.setC_addr(rs.getString("c_addr"));
				coach.setC_start_date(rs.getTimestamp("c_start_date"));
				coach.setB_id(rs.getString("b_id"));
				coach.setC_email(rs.getString("c_email"));
				coach.setC_intro(rs.getString("c_intro"));
				coach.setC_sus(rs.getBoolean("c_sus"));
				coach.setC_pic(rs.getBytes("c_pic"));
				//coach.setBh_id(rs.getInt("bh_id"));
				coach.setBh_name(rs.getString("bh_name"));
				coach.setC_add_time(rs.getTimestamp("c_add_time"));
				coach.setC_modi_time(rs.getTimestamp("c_modi_time"));
				
				list.add(coach);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
