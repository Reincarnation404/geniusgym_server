package org.example.DaoImpl;

import static org.example.util.CommonConstants.route;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.zaxxer.hikari.HikariDataSource;
import org.example.Dao.NotifyDao;
import org.example.bean.Notify;


public class NotifyDaoImpl implements NotifyDao {
	private HikariDataSource ds;

	public NotifyDaoImpl() {
		try {
			ds = (HikariDataSource) new InitialContext().lookup(route);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Notify notify) {
		String sql = "INSERT INTO notify(" 
				+ "m_id, " // 員工 ID
				+ "nt_send_time, " // 發公告時間
				+ "bh_id, " // 分店 ID
				+ "nt_text" // 公告內容
				+ ")VALUES (?,?,?,?)";

		try (
				Connection conn = ds.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, notify.getM_id());
			pstmt.setTimestamp(2, notify.getNt_send_time());
			pstmt.setInt(3, notify.getBh_id());
			pstmt.setString(4, notify.getNt_text());		
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Integer nt_id) {
		String sql = "DELETE FROM notify WHERE nt_id = ?;";
		
		try(
				Connection conn =ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setInt(1, nt_id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(Notify notify) {
		StringBuilder sql = new StringBuilder("UPDATE notify SET ");
		if (notify.getM_id() != null) {
			sql.append("m_id = ?, ");
		}
		if(notify.getBh_id() != null) {
			sql.append("bh_id = ?, ");
		}
		if(notify.getNt_text() != null) {
			sql.append("nt_text = ?, ");
		}
		sql.append("nt_text = nt_text WHERE nt_id = ?;");
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			int position = 1;
			if (notify.getM_id() != null) {
				pstmt.setString(position, notify.getM_id());
				position ++;
			}
			if(notify.getBh_id() != null) {
				pstmt.setInt(position, notify.getBh_id());
				position ++;
			}
			if(notify.getNt_text() != null) {
				pstmt.setString(position, notify.getNt_text());
				position ++;
			}
			pstmt.setInt(position, notify.getNt_id());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return -1;
	}

	@Override
	public List<Notify> selectALL() {
		String sql = "SELECT * FROM notify";
		List<Notify> list = new ArrayList<>();
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			while(rs.next()) {
				Notify notify = new Notify();
				notify.setNt_id(rs.getInt("nt_id"));
				notify.setM_id(rs.getString("m_id"));
				notify.setNt_send_time(rs.getTimestamp("nt_send_time"));
				notify.setBh_id(rs.getInt("bh_id"));
				notify.setNt_text(rs.getString("nt_text"));
				
				list.add(notify);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
