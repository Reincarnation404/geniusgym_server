package org.example.brian_background.serviceimpl;

import org.example.DaoImpl.MemberDaoImpl;
import org.example.bean.Member;
import org.example.brian_background.service.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class Login_out_DaoImpl implements Login_out_Dao{
	
	private DataSource ds;
	public Login_out_DaoImpl() {
		try {
			ds = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/example");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Member login(Member member) {
		if (member.getM_id() == null) {
			return null;
		}
		if (member.getM_id().length() < 6 || member.getM_id().length() > 12) {
			return null;
		}
		if (member.getM_pwd() == null) {
			return null;
		}
		return new MemberDaoImpl().selelctByUsernameAndPassword(member);
	}

}
