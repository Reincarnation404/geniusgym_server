package org.example.ServiceImpl;

import org.example.Dao.CoachDao;
import org.example.DaoImpl.CoachDaoImpl;
import org.example.Service.CoachService;
import org.example.bean.Coach;

import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;


public class CoachServiceImpl implements CoachService {
	private CoachDao dao;
	
	public CoachServiceImpl() {
		dao = new CoachDaoImpl();
	}

	@Override
	public List<Coach> findAll() {
		return dao.selectAll();
	}
	

	@Override
	public boolean register(Coach coach) {
		String c_id = coach.getC_id();
		if(c_id == null) {
			return false;
		}
		String c_pwd = coach.getC_pwd();
		if(c_pwd == null) {
			return false;
		}
		String c_name = coach.getC_name();
		if(c_name == null) {
			return false;
		}
		Integer c_gen = coach.getC_gen();
		if(c_gen == null) {
			return false;
		}
		String c_cell = coach.getC_cell();
		if(c_cell == null) {
			return false;
		}
		String c_twid = coach.getC_twid();
		if(c_twid == null) {
			return false;
		}
		String c_addr = coach.getC_addr();
		if(c_addr == null) {
			return false;
		}
		Timestamp c_start_date = coach.getC_start_date();
		if(c_start_date == null) {
			return false;
		}
		String b_id = coach.getB_id();
		if(b_id == null) {
			return false;
		}
		String c_email = coach.getC_email();
		if(c_email == null) {
			return false;
		}
		String c_intro = coach.getC_intro();
		if(c_intro == null) {
			return false;
		}
		String c_branch = coach.getBh_name();
		if(c_branch == null) {
			return false;
		}
		String base64 = coach.getC_picBase64();
		if(base64 != null && !base64.isEmpty()) {
			byte[] pic = Base64.getDecoder().decode(base64);
			coach.setC_pic(pic);
		}
		
		return dao.insert(coach) >= 1 ;
	}
	

	@Override
	public boolean editCoach(Coach coach) {
		String base64 = coach.getC_picBase64();
		if(base64 != null && !base64.isEmpty()) {
			byte[] pic = Base64.getDecoder().decode(base64);
			coach.setC_pic(pic);
		}
		int result = dao.updateById(coach);
		return result > 0;
	}
	

	@Override
	public boolean editSuspend(Coach coach) {
		boolean sus = coach.getC_sus();
		if(sus == true) {
			coach.setC_sus(false);
		}else {
			coach.setC_sus(true);
		}
		int result = dao.unRegisterById(coach);
		return result > 0;
	}
	
	
	

}
