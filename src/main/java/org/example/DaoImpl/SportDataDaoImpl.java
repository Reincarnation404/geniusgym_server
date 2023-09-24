package org.example.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.zaxxer.hikari.HikariDataSource;
import org.example.Dao.SportDataDao;
import org.example.bean.SportData;
import static org.example.util.CommonConstants.route;


public class SportDataDaoImpl implements SportDataDao {
	
		private HikariDataSource ds;
		public SportDataDaoImpl(){
			try {
				ds = (HikariDataSource) new InitialContext().lookup(route);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	
	public int insert(SportData sportData) {
		String sql = "INSERT INTO sport_data ("
				+ "sd_bigid, " //同組ID
				+ "m_id, " //會員 ID
				+ "sc_id, " //運動種類 ID
				+ "sc_weigt, " //重量
				+ "sc_freq, " //次數
				+ "sc_set, " //第幾組
				+ "c_id, " //教練 ID( 可為 null)
				+ "sd_record_time, " // 運動時間
				+ "sd_update_time " //更新時間
				+ ") VALUES(?,?,?,?,?,?,?,?,NOW())";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, sportData.getSd_bigid());
			pstmt.setString(2, sportData.getM_id());
			pstmt.setInt(3, sportData.getSc_id());
			pstmt.setFloat(4, sportData.getSc_weigt());
			pstmt.setInt(5, sportData.getSc_freq());
			pstmt.setInt(6, sportData.getSc_set());
			pstmt.setString(7, sportData.getC_id());
			pstmt.setString(8, sportData.getSd_record_time());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}


	@Override
	public List<SportData> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteSet(String sd_record_id) {
		String sql = "DELETE FROM sport_data WHERE (sd_bigid = ?);";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, sd_record_id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

}
