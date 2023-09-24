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
import org.example.Service.ClassService;
import org.example.ServiceImpl.ClassServiceImpl;
import org.example.bean.ClassInfo;


@WebServlet("/buClass")
public class ClassController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Gson gson = new GsonBuilder()
			.setDateFormat("yyyy-MM-dd HH:mm:ss")  //  把/改成-
			.create();
	private static final ClassService service = new ClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if(pathInfo == null || pathInfo.equals("/")) {
			List<ClassInfo> list = service.findAll();
			System.out.println(list);
			resp.getWriter().write(gson.toJson(list));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClassInfo classInfo = gson.fromJson(req.getReader(), ClassInfo.class);
		System.out.println("test" + classInfo);
		boolean result = service.addInfo(classInfo);
		JsonObject respbody = new JsonObject();
		respbody.addProperty("successful", result);
		String message = "新增"+ (result ? "成功":"失敗");
		respbody.addProperty("message", message);
		resp.getWriter().write(respbody.toString());	
		
		System.out.println(message);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClassInfo classInfo = gson.fromJson(req.getReader(), ClassInfo.class);
		System.out.println(classInfo);
		boolean result = service.editClass(classInfo);
		JsonObject respbody = new JsonObject();
		respbody.addProperty("successful", result);
		String message = "修改"+ (result ? "成功":"失敗");
		respbody.addProperty("message", message);
		resp.getWriter().write(respbody.toString());
		
		System.out.println(message);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClassInfo classInfo = gson.fromJson(req.getReader(), ClassInfo.class);
		System.out.println(classInfo);
		boolean result = service.editAvail(classInfo);
		JsonObject respbody = new JsonObject();
		respbody.addProperty("successful", result);
		String message = "開放"+ (result ? "成功":"失敗");
		respbody.addProperty("message", message);
		resp.getWriter().write(respbody.toString());
		
		System.out.println(message);
	}
	
	
}
