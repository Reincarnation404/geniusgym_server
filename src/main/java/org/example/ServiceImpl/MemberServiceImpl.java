package org.example.ServiceImpl;

import org.example.Dao.MemberDao;
import org.example.DaoImpl.MemberDaoImpl;
import org.example.Service.MemberService;
import org.example.bean.Member;

import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;



public class MemberServiceImpl implements MemberService {
	private MemberDao dao;
	
	public MemberServiceImpl(){
		dao = new MemberDaoImpl();
	}
	
	@Override
	public boolean register(Member member) {
		String m_id = member.getM_id();
		if(m_id == null) {
			return false;
		}
		String m_pwd = member.getM_pwd();
		if(m_pwd == null) {
			return false;
		}
		String m_name = member.getM_name();
		if(m_name == null) {
			return false;
		}
		Integer m_gen = member.getM_gen();
		if(m_gen == null) {
			return false;
		}
		String m_cell = member.getM_cell();
		if(m_cell == null) {
			return false;
		}
		String m_twid = member.getM_twid();
		if(m_twid == null) {
			return false;
		}
		String m_addr = member.getM_addr();
		if(m_addr == null) {
			return false;
		}
		Timestamp m_ed_date = member.getM_ed_date();
		if(m_ed_date == null) {
			return false;
		}
		String b_id = member.getB_id();
		if(b_id == null) {
			return false;
		}
		String m_email = member.getM_email();
		if(m_email == null) {
			return false;
		}
		String base64 = member.getM_picBase64();
		if(base64 != null && !base64.isEmpty()) {
			byte[] pic = Base64.getDecoder().decode(base64);
			member.setM_pic(pic);
		}
		
		return dao.insert(member) >= 1 ;
	}

	@Override
	public List<Member> findAll() {
		return dao.selectAll();
	}

	@Override
	public boolean editSuspend(Member member) {
		boolean sus = member.getM_sus();
		if(sus == true) {
			member.setM_sus(false);
		}else {
			member.setM_sus(true);
		}
		int result = dao.unRegisterById(member);
		return result > 0;
	}

	@Override
	public boolean editMember(Member member) {
		String base64 = member.getM_picBase64();
		if(base64 != null && !base64.isEmpty()) {
			byte[] pic = Base64.getDecoder().decode(base64);
			member.setM_pic(pic);
		}
		int result = dao.updateById(member);
		return result > 0;
	}


}
