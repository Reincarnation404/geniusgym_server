package org.example.DaoImpl;

import org.example.Dao.BranchDao;
import org.example.bean.Branch;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BranchDaoImpl implements BranchDao{
	
	private DataSource ds;
	public BranchDaoImpl() {
		try {
			ds = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/example");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Branch> selectAll() {
		String sql = "select * from Branch";
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet resultSet = pstmt.executeQuery()) {
				List<Branch> branchList = new ArrayList<>();
				while(resultSet.next()) {
				    Branch branch = new Branch();
				    branch.setBh_id(resultSet.getInt("bh_id"));
		            branch.setBh_name(resultSet.getString("bt_name"));
		            branch.setBh_addr(resultSet.getString("bh_addr"));
		            branch.setBh_cell(resultSet.getString("bh_cell"));
		            branch.setBh_start_time(resultSet.getString("bh_start_time"));
		            branch.setBh_ed_time(resultSet.getString("bh_ed_time"));
		            branchList.add(branch);
				}
				return branchList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
