package org.example.ServiceImpl;

import org.example.Dao.BusinessDao;
import org.example.DaoImpl.BusinessDaoImpl;
import org.example.Service.BusinessService;
import org.example.bean.Business;

import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;


public class BusinessServiceImpl implements BusinessService {
	private BusinessDao dao;
	
	public BusinessServiceImpl() {
		dao = new BusinessDaoImpl();
	}

	@Override
	public List<Business> findAll() {
		return dao.selectAll();
	}

	@Override
	public boolean register(Business business) {
		String b_id = business.getB_id();
		if(b_id == null) {
			return false;
		}
		String b_pwd = business.getB_pwd();
		if(b_pwd == null) {
			return false;
		}
		String b_name = business.getB_name();
		if(b_name == null) {
			return false;
		}
		Integer b_gen = business.getB_gen();
		if(b_gen == null) {
			return false;
		}
		String b_cell = business.getB_cell();
		if(b_cell == null) {
			return false;
		}
		String b_twid = business.getB_twid();
		if(b_twid == null) {
			return false;
		}
		String b_addr = business.getB_addr();
		if(b_addr == null) {
			return false;
		}
		Timestamp b_start_date = business.getB_start_date();
		if(b_start_date == null) {
			return false;
		}
//		String b_id = coach.getB_id();
//		if(b_id == null) {
//			return false;
//		}
		String b_email = business.getB_email();
		if(b_email == null) {
			return false;
		}
		String b_branch = business.getBh_name();
		if(b_branch == null) {
			return false;
		}
//		String base64 = coach.getC_picBase64();
//		if(base64 != null && !base64.isEmpty()) {
//			byte[] pic = Base64.getDecoder().decode(base64);
//			coach.setC_pic(pic);
//		}
//		
		return dao.insert(business) >= 1 ;
	}
	

	@Override
	public boolean editBusiness(Business business) {
//		String base64 = coach.getC_picBase64();
//		if(base64 != null && !base64.isEmpty()) {
//			byte[] pic = Base64.getDecoder().decode(base64);
//			coach.setC_pic(pic);
//		}
		int result = dao.updateById(business);
		return result > 0;
	}

	@Override
	public boolean editSuspend(Business business) {
		boolean sus = business.getB_sus();
		if(sus == true) {
			business.setB_sus(false);
		}else {
			business.setB_sus(true);
		}
		int result = dao.unRegisterById(business);
		return result > 0;
	}
	
	
	
	
}
