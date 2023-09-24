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
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.example.Dao.MemberDao;
import org.example.bean.Member;


public class MemberDaoImpl implements MemberDao {
	
	private DataSource ds;
	public MemberDaoImpl(){
		try {
			ds = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/example");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	

	@Override
	public int insert(Member member) {
		String sql = "INSERT INTO member ("
				+ "m_id,"// 會員 ID m_id
				+ "m_pwd,"// 密碼 m_pwd
				+ "m_name,"// 姓名 m_name
				+ "m_gen,"// 性別 m_gen
				+ "m_cell,"// 聯絡電話 m_cell
				+ "m_twid,"// 身分證字號 m_twid
				+ "m_addr,"// 住址 m_addr
				+ "m_ed_date,"// 會員期限 m_ed_date
				+ "b_id,"// 修改人 ID b_id
				+ "m_email,"// email m_email
				+ "m_pic,"// 大頭貼 m_pic
				+ "m_sus, "// 是否停權 m_sus
				+ "m_add_time)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,1,NOW())";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, member.getM_id());
			pstmt.setString(2, member.getM_pwd());
			pstmt.setString(3, member.getM_name());
			pstmt.setInt(4, member.getM_gen());
			pstmt.setString(5, member.getM_cell());
			pstmt.setString(6, member.getM_twid());
			pstmt.setString(7, member.getM_addr());
			pstmt.setTimestamp(8, member.getM_ed_date());
			pstmt.setString(9, member.getB_id());
			pstmt.setString(10, member.getM_email());
			pstmt.setBytes(11, member.getM_pic());
			//pstmt.setBoolean(12, member.getM_sus());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int unRegisterById(Member member) {
		String sql = "UPDATE member SET m_sus = ?, m_modi_time = now() WHERE (m_id = ?);";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setBoolean(1, member.getM_sus());
			pstmt.setString(2, member.getM_id());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateById(Member member) {
		StringBuilder sql = new StringBuilder("UPDATE member SET ");
		Map<String, Object> fieldMap = new LinkedHashMap<>();
		if (member.getM_pwd() != null && !member.getM_pwd().isEmpty()) {
			fieldMap.put("m_pwd", member.getM_pwd());
		}
		if (member.getM_name() != null && !member.getM_name().isEmpty() ) {
			fieldMap.put("m_name", member.getM_name());
		}
		if(member.getM_gen() != null) {
			fieldMap.put("m_gen", member.getM_gen());
		}
		if(member.getM_cell() != null && !member.getM_cell().isEmpty()) {
			fieldMap.put("m_cell",member.getM_cell());
		}
		if(member.getM_twid() != null && !member.getM_twid().isEmpty()) {
			fieldMap.put("m_twid", member.getM_twid());
		}
		if(member.getM_addr() != null && !member.getM_addr().isEmpty()) {
			fieldMap.put("m_addr", member.getM_addr());
		}
		if(member.getM_ed_date() != null) {
			fieldMap.put("m_ed_date", member.getM_ed_date());
		}
		if(member.getM_email() != null && !member.getM_email().isEmpty()) {
			fieldMap.put("m_email", member.getM_email());
		}
		if(member.getM_pic()!= null) {
			fieldMap.put("m_pic", member.getM_pic());
		}
//		if(member.getM_sus()!= null) {
//			fieldMap.put("m_sus", member.getM_sus());
//		}
		fieldMap.put("m_id", member.getM_id());
		
		for (String field : fieldMap.keySet()) {
			if(field.equals("m_id")) {
				continue;
			}
			sql.append(field + " =?,");
		}
		sql.append("m_modi_time = NOW() WHERE m_id = ?;");
		System.out.println(sql.toString());
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
					System.out.println(position + (String) value);
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
			pstmt.setString(position++,(String) fieldMap.get("m_id"));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<Member> selectAll() {
		String sql = "SELECT * FROM MEMBER order by m_sus desc";
		List<Member> list =  new ArrayList<>();

		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				Member member = new Member();
				member.setM_id(rs.getString("m_id"));
				member.setM_pwd(rs.getString("m_pwd"));
				member.setM_name(rs.getString("m_name"));
				member.setM_gen(rs.getInt("m_gen"));
				member.setM_cell(rs.getString("m_cell"));
				member.setM_twid(rs.getString("m_twid"));
				member.setM_addr(rs.getString("m_addr"));
				member.setM_ed_date(rs.getTimestamp("m_ed_date"));
				member.setB_id(rs.getString("b_id"));
				member.setM_email(rs.getString("m_email"));
				member.setM_pic(rs.getBytes("m_pic"));
				member.setM_sus(rs.getBoolean("m_sus"));

				list.add(member);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Member> selectIdName() {
		String sql = "SELECT m_id, m_name FROM MEMBER";
		List<Member> list =  new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				Member member = new Member();
				member.setM_id(rs.getString("m_id"));
				member.setM_name(rs.getString("m_name"));

				list.add(member);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Member selelctByUsernameAndPassword(Member member) {
		String sql = "select * from MEMBER where m_id = ? and m_pwd = ?";
		try (Connection conn = ds.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql);

		) {
			pstmt.setString(1, member.getM_id());
			pstmt.setString(2, member.getM_pwd());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					member = new Member();
					member.setM_name(rs.getString("m_name"));
					member.setM_gen(rs.getInt("m_gen"));
					member.setM_cell(rs.getString("m_cell"));
					member.setM_twid(rs.getString("m_twid"));
					member.setM_addr(rs.getString("m_addr"));
					member.setM_ed_date(rs.getTimestamp("m_ed_date"));
					member.setB_id(rs.getString("b_id"));
					member.setM_email(rs.getString("m_email"));
					member.setM_pic(rs.getBytes("m_pic"));
					member.setM_sus(rs.getBoolean("m_sus"));
					return member;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
