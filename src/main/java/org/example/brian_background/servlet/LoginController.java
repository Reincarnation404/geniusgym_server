package org.example.brian_background.servlet;

import org.example.bean.Member;
import org.example.brian_background.service.Login_out_Dao;
import org.example.brian_background.serviceimpl.Login_out_DaoImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login/*")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Login_out_Dao service;

	@Override
	public void init() throws ServletException {
		service = new Login_out_DaoImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		Member member = gson.fromJson(req.getReader(), Member.class);
		member = service.login(member);
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", member != null);
		
		if (member != null) {
			if (req.getSession(false) != null) {
				req.changeSessionId();
			}
			req.getSession().setAttribute("member", member);
			respBody.addProperty("message", "success");
		}else {
			respBody.addProperty("message", "使用者名稱或密碼錯誤");
		}
		resp.getWriter().write(respBody.toString());
		
	}

}
