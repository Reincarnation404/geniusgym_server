package org.example.business;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.example.Service.BusinessService;
import org.example.ServiceImpl.BusinessServiceImpl;
import org.example.bean.Business;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/buBuz/*")
public class BusinessController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Gson gson = new GsonBuilder()
			.setDateFormat("yyyy-MM-dd HH:mm:ss")  //  把/改成-
			.create();
	private static final BusinessService service = new BusinessServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if(pathInfo == null || pathInfo.equals("/")) {
			List<Business> list = service.findAll();
			System.out.println(list);
			resp.getWriter().write(gson.toJson(list));
			
		}else {
			pathInfo = pathInfo.substring(1);
			String[] pathVariables = pathInfo.split("/");
			Business business = new Business();
			business.setB_id(pathVariables[0]);
			business.setB_pwd(pathVariables[1]);
			if (business != null) {
				if (req.getSession(false) != null) {
					req.changeSessionId(); // ←產生新的Session ID 避免被別人仿造
				} // ↓此屬性物件即用來區分是否登入中
				req.getSession().setAttribute("business", business);
			}
			resp.getWriter().write(gson.toJson(business));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Business business = gson.fromJson(req.getReader(), Business.class);
		System.out.println(business);
		boolean result = service.register(business);
		JsonObject respbody = new JsonObject();
		respbody.addProperty("successful", result);
		String message = "新增"+ (result ? "成功":"失敗");
		respbody.addProperty("message", message);
		resp.getWriter().write(respbody.toString());	
		
		System.out.println(message);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Business business = gson.fromJson(req.getReader(), Business.class);
		System.out.println(business);
		boolean result = service.editBusiness(business);
		JsonObject respbody = new JsonObject();
		respbody.addProperty("successful", result);
		String message = "修改"+ (result ? "成功":"失敗");
		respbody.addProperty("message", message);
		resp.getWriter().write(respbody.toString());
		
		System.out.println(message);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Business business = gson.fromJson(req.getReader(), Business.class);
		System.out.println(business);
		boolean result = service.editSuspend(business);
		JsonObject respbody = new JsonObject();
		respbody.addProperty("successful", result);
		String message = "停權"+ (result ? "成功":"失敗");
		respbody.addProperty("message", message);
		resp.getWriter().write(respbody.toString());
		
		System.out.println(message);
	}
	
}
