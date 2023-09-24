package org.example.spencer_playground;

import org.example.Dao.SportBigIdDao;
import org.example.DaoImpl.SportBigIdDaoImpl;
import org.example.bean.SportBigId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Test_for_select")
public class Test_for_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final SportBigIdDao SportBigIdDaoImpl = new SportBigIdDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String id = req.getReader().readLine();
		List<SportBigId> result = SportBigIdDaoImpl.selectAll();
		String resBody = Gson.toJson(result);
		resp.getWriter().write(resBody);
	}
}
