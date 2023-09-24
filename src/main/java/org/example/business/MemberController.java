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
import org.example.Service.MemberService;
import org.example.ServiceImpl.MemberServiceImpl;
import org.example.bean.Member;


@WebServlet("/buMember/*")
public class MemberController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Gson gson = new GsonBuilder()
			.setDateFormat("yyyy-MM-dd HH:mm:ss")  //  把/改成-
			.create();
	private static final MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if(pathInfo == null || pathInfo.equals("/")) {
			List<Member> list = service.findAll();
			list.forEach(member -> {
				String picBase64 = Base64.getEncoder().encodeToString(member.getM_pic());
				member.setM_picBase64(picBase64);
				member.setM_pic(null);
			});
			//System.out.println(list);
			resp.getWriter().write(gson.toJson(list));
			
		}else {
			pathInfo = pathInfo.substring(1);
			String[] pathVariables = pathInfo.split("/");
			Member member = new Member();
			member.setM_id(pathVariables[0]);
			member.setM_pwd(pathVariables[1]);
			if (member != null) {
				if (req.getSession(false) != null) {
					req.changeSessionId(); // ←產生新的Session ID 避免被別人仿造
				} // ↓此屬性物件即用來區分是否登入中
				req.getSession().setAttribute("member", member);
			}
			
			//要加判斷不然沒圖片會壞掉
			String picBase64 = Base64.getEncoder().encodeToString(member.getM_pic());
			member.setM_picBase64(picBase64);
			
			resp.getWriter().write(gson.toJson(member));
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = gson.fromJson(req.getReader(), Member.class);
		//System.out.println(member);
		boolean result = service.register(member);
		JsonObject respbody = new JsonObject();
		respbody.addProperty("successful", result);
		String message = "新增"+ (result ? "成功":"失敗");
		respbody.addProperty("message", message);
		resp.getWriter().write(respbody.toString());	
		
		System.out.println(message);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = gson.fromJson(req.getReader(), Member.class);
		//System.out.println(member);
		boolean result = service.editMember(member);
		JsonObject respbody = new JsonObject();
		respbody.addProperty("successful", result);
		String message = "修改"+ (result ? "成功":"失敗");
		respbody.addProperty("message", message);
		resp.getWriter().write(respbody.toString());
		
		//System.out.println(message);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = gson.fromJson(req.getReader(), Member.class);
		//System.out.println(member);
		boolean result = service.editSuspend(member);
		JsonObject respbody = new JsonObject();
		respbody.addProperty("successful", result);
		String message = "停權"+ (result ? "成功":"失敗");
		respbody.addProperty("message", message);
		resp.getWriter().write(respbody.toString());
		
		//System.out.println(message);
	}
	
	
}
