package org.example.spencer_playground;

import org.example.Dao.SportDataDao;
import org.example.DaoImpl.SportDataDaoImpl;
import org.example.bean.SportData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet("/GetSportData")
public class GetSportData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").setLenient().create();
	private static final SportDataDao SportDataDaoImpl = new SportDataDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 插入運動資訊
		Type sportDataType = new TypeToken<List<SportData>>() {}.getType();
		String json = req.getReader().readLine();
		List<SportData> sportDataList= Gson.fromJson(json, sportDataType);
		
		Integer a =0;
		for(SportData sportData: sportDataList) {
			a = a +SportDataDaoImpl.insert(sportData);
		}
		resp.getWriter().write(a.toString());
	}
}
