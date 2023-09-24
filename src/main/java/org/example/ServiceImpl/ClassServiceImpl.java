package org.example.ServiceImpl;

import org.example.Dao.ClassDao;
import org.example.DaoImpl.ClassDaoImpl;
import org.example.Service.ClassService;
import org.example.bean.ClassInfo;

import java.sql.Timestamp;
import java.util.List;


public class ClassServiceImpl implements ClassService {

	private ClassDao dao;
	public ClassServiceImpl() {
		dao = new ClassDaoImpl();
	}
	
	@Override
	public List<ClassInfo> findAll() {
		return dao.selectAll();
	}

	@Override
	public boolean addInfo(ClassInfo classInfo) {
		String ci_name = classInfo.getCi_name();
		if(ci_name == null) {
			return false;
		}
		Timestamp ci_start_time = classInfo.getCi_start_time();
		if(ci_start_time == null) {
			return false;
		}
		Timestamp ci_ed_time = classInfo.getCi_ed_time();
		if(ci_ed_time == null) {
			return false;
		}
		String ci_place = classInfo.getCi_place();
		if(ci_place == null) {
			return false;
		}
		Integer ci_cost = classInfo.getCi_cost();
		if(ci_cost == null) {
			return false;
		}
		String ci_text = classInfo.getCi_text();
		if(ci_text == null) {
			return false;
		}
		Integer ci_limit = classInfo.getCi_limit();
		if(ci_limit == null){
			return false;
		}
		Integer bh_id = classInfo.getBh_id();
		if(bh_id == null){
			return false;
		}
		Timestamp ci_regi_time = classInfo.getCi_regi_time();
		if(ci_regi_time == null) {
			return false;
		}	
		Timestamp ci_regi_ed_time = classInfo.getCi_regi_ed_time();
		if(ci_regi_ed_time == null) {
			return false;
		}
		String b_id = classInfo.getB_id();
		if(b_id == null) {
			return false;
		}
		Integer sc_id = classInfo.getSc_id();
		if(sc_id == null) {
			return false;
		}
//		Boolean ci_avail = classInfo.getCi_avail();
//		if(ci_avail == null) {
//			return false;
//		}
		
		return dao.insert(classInfo) >= 1 ;
	}
	

	@Override
	public boolean editClass(ClassInfo classInfo) {
		int result = dao.updateById(classInfo);
		return result > 0;
	}

	@Override
	public boolean editAvail(ClassInfo classInfo) {
		boolean avail = classInfo.getCi_avail();
		if(avail == true) {
			classInfo.setCi_avail(false);
		}else {
			classInfo.setCi_avail(true);
		}
		int result = dao.unRegisterById(classInfo);
		return result > 0;
	}
	
	

}
