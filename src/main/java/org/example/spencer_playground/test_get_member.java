package org.example.spencer_playground;

import org.example.Dao.MemberDao;
import org.example.DaoImpl.MemberDaoImpl;
import org.example.bean.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/test_get_member")
public class test_get_member extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final MemberDao memberDaoImple = new MemberDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Member> memberList = memberDaoImple.selectIdName();
		String resBody = Gson.toJson(memberList);
		resp.getWriter().write(resBody.toString());
	}
}
