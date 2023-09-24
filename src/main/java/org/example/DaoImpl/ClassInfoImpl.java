package org.example.DaoImpl;

import org.example.Dao.ClassInfoDao;
import org.example.brian_background.model.ClassInfoReturn;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClassInfoImpl implements ClassInfoDao{
	private DataSource ds;
	public ClassInfoImpl() {
		try {
			ds = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/example");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<ClassInfoReturn> selectAll() {
		String sql = "select * from class_info";
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet resultSet = pstmt.executeQuery()) {
				List<ClassInfoReturn> classInfos = new ArrayList<>();
				  while (resultSet.next()) {
			            ClassInfoReturn classInfo = new ClassInfoReturn();
			            classInfo.setCi_id(resultSet.getInt("ci_id"));
			            classInfo.setCi_name(resultSet.getString("ci_name"));
			            classInfo.setCi_start_time(timeStampToTimeString(resultSet.getTimestamp("ci_start_time")));
			            classInfo.setCi_ed_time(timeStampToTimeString(resultSet.getTimestamp("ci_ed_time")));
			            classInfo.setCi_place(resultSet.getString("ci_place"));
			            classInfo.setCi_cost(resultSet.getInt("ci_cost"));
			            classInfo.setSc_id(resultSet.getInt("sc_id"));
			            classInfo.setCi_date(timeStampToDateString(resultSet.getTimestamp("ci_ed_time")));		            
			            classInfo.setCi_text(resultSet.getString("ci_text"));
			            classInfo.setCi_limit(resultSet.getInt("ci_limit"));
			            classInfo.setBh_id(resultSet.getInt("bh_id"));
			            classInfo.setC_id(resultSet.getString("c_id"));
			            classInfos.add(classInfo);
			        }
				return classInfos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
		
	private String timeStampToTimeString(Timestamp timestamp) {
       DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
       return sdf.format(timestamp);
	}
	
	private String timeStampToDateString(Timestamp timestamp) {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(timestamp);
	}
		
}
