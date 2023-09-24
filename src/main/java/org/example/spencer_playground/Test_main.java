package org.example.spencer_playground;
import org.example.Dao.MemberDao;
import org.example.DaoImpl.MemberDaoImpl;
import org.example.bean.Member;
public class Test_main {
	public static void main(String[] args) {
		MemberDao dao = new MemberDaoImpl();
		Member member = new Member();
		member.setB_id("R05221016");
		member.setM_name("HaHaPoint");
		dao.updateById(member);
	}
}
