package org.example.spencer_playground;

import org.example.Dao.SportBigIdDao;
import org.example.Dao.SportCatDao;
import org.example.DaoImpl.SportBigIdDaoImpl;
import org.example.DaoImpl.SportCatDaoImpl;
import org.example.bean.SportBigId;
import org.example.bean.SportCat;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetSportCat")
public class GetSportCat extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static SportCatDao sportCatDao = new SportCatDaoImpl();
	private static SportBigIdDao sportBigDao = new SportBigIdDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<SportCat> list = sportCatDao.selectAll();
		Gson gson = new Gson();
		String jsonIn = gson.toJson(list);
		resp.getWriter().write(jsonIn);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<SportBigId> list = sportBigDao.selectAll();
		Gson gson = new Gson();
		String jsonIn = gson.toJson(list);
		resp.getWriter().write(jsonIn);
	}
}
