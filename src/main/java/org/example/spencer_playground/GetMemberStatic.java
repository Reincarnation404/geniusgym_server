package org.example.spencer_playground;

import org.example.Dao.BodyDataDao;
import org.example.DaoImpl.BodyDataDaoImpl;
import org.example.bean.BodyData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetMemberStatic")
public class GetMemberStatic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final BodyDataDao bodyDataDaoImpl = new BodyDataDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = Gson.fromJson(req.getReader(), BodyData.class).getM_id();
		BodyData bodyData = bodyDataDaoImpl.selectById(id);
		System.out.println(id + bodyData.getM_id());
		String resBody = Gson.toJson(bodyData);
		resp.getWriter().write(resBody.toString());
	}
}
