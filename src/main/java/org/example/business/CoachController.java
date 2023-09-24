package org.example.business;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.example.Service.CoachService;
import org.example.ServiceImpl.CoachServiceImpl;
import org.example.bean.Coach;

@WebServlet("/buCoach/*")
public class CoachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson gson = new GsonBuilder()
			.setDateFormat("yyyy-MM-dd HH:mm:ss")  //  把/改成-
			.create();
	private static final CoachService service = new CoachServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if(pathInfo == null || pathInfo.equals("/")) {
			List<Coach> list = service.findAll();
			list.forEach(coach -> {
				String picBase64 = Base64.getEncoder().encodeToString(coach.getC_pic());
				coach.setC_picBase64(picBase64);
				coach.setC_pic(null);
			});
			System.out.println(list);
			resp.getWriter().write(gson.toJson(list));

			System.out.println(pathInfo);
			
		}else {
			pathInfo = pathInfo.substring(1);
			String[] pathVariables = pathInfo.split("/");
			Coach coach = new Coach();
			coach.setC_id(pathVariables[0]);
			coach.setC_pwd(pathVariables[1]);
			if (coach != null) {
				if (req.getSession(false) != null) {
					req.changeSessionId(); // ←產生新的Session ID 避免被別人仿造
				} // ↓此屬性物件即用來區分是否登入中
				req.getSession().setAttribute("coach", coach);
			}
			
			//要加判斷不然沒圖片會壞掉
			String picBase64 = Base64.getEncoder().encodeToString(coach.getC_pic());
			coach.setC_picBase64(picBase64);
			
			resp.getWriter().write(gson.toJson(coach));


		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Coach coach = gson.fromJson(req.getReader(), Coach.class);
		System.out.println(coach);
		boolean result = service.register(coach);
		JsonObject respbody = new JsonObject();
		respbody.addProperty("successful", result);
		String message = "新增"+ (result ? "成功":"失敗");
		respbody.addProperty("message", message);
		resp.getWriter().write(respbody.toString());	
		
		System.out.println(message);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Coach coach = gson.fromJson(req.getReader(), Coach.class);
		System.out.println(coach);
		boolean result = service.editCoach(coach);
		JsonObject respbody = new JsonObject();
		respbody.addProperty("successful", result);
		String message = "修改"+ (result ? "成功":"失敗");
		respbody.addProperty("message", message);
		resp.getWriter().write(respbody.toString());
		
		System.out.println(message);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Coach coach = gson.fromJson(req.getReader(), Coach.class);
		System.out.println(coach);
		boolean result = service.editSuspend(coach);
		JsonObject respbody = new JsonObject();
		respbody.addProperty("successful", result);
		String message = "停權"+ (result ? "成功":"失敗");
		respbody.addProperty("message", message);
		resp.getWriter().write(respbody.toString());
		
		System.out.println(message);
	}

}
