package org.example.spencer_playground;

import org.example.Dao.NotifyDao;
import org.example.DaoImpl.NotifyDaoImpl;
import org.example.bean.Notify;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Test_for_insert")
public class Test_for_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final NotifyDao notifyDaoImpl = new NotifyDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Notify notify = Gson.fromJson(req.getReader(), Notify.class);
		//String id = req.getReader().readLine();
		int result = notifyDaoImpl.insert(notify);
		JsonObject resBody = new JsonObject();
		resBody.addProperty("result", result);
		resp.getWriter().write(resBody.toString());
	}
}
