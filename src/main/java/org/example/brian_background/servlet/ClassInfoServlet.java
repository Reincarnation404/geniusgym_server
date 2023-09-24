package org.example.brian_background.servlet;

import org.example.Dao.ClassInfoDao;
import org.example.DaoImpl.ClassInfoImpl;
import org.example.brian_background.model.ClassInfoReturn;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/member/classinfo")
public class ClassInfoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ClassInfoDao classInfoImpl;
	@Override
	public void init() throws ServletException {
		classInfoImpl = new ClassInfoImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		List<ClassInfoReturn> classInfoReturns = classInfoImpl.selectAll();
		resp.getWriter().write(gson.toJson(classInfoReturns));
	}
	
}
