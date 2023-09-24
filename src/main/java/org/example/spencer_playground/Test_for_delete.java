package org.example.spencer_playground;

import org.example.Dao.NotifyDao;
import org.example.DaoImpl.NotifyDaoImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Test_for_delete")
public class Test_for_delete extends HttpServlet {
	/*
	 * private static final long serialVersionUID = 1L; private static final Gson
	 * Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	 * private static final SportBigIdDao SportBigIdDaoImpl = new
	 * SportBigIdDaoImpl();
	 * 
	 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { int sportBigId =
	 * Gson.fromJson(req.getReader(), int.class); // String id =
	 * req.getReader().readLine(); int result =
	 * SportBigIdDaoImpl.delete(sportBigId); JsonObject resBody = new JsonObject();
	 * resBody.addProperty("result", result);
	 * resp.getWriter().write(resBody.toString()); }
	 */
	
	private static final long serialVersionUID = 1L; 
	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final NotifyDao notifyDaoImpl = new NotifyDaoImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo().substring(1);
		int result = notifyDaoImpl.delete(Integer.parseInt(pathInfo));
		JsonObject resBody = new JsonObject();
		resBody.addProperty("result", result);
		resp.getWriter().write(resBody.toString());
	}
}
