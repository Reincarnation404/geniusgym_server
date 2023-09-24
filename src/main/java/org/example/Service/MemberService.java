package org.example.Service;

import org.example.bean.Member;

import java.util.List;





public interface MemberService {
	
	boolean register(Member member);
	
	boolean editMember(Member member);
	
	boolean editSuspend(Member member);
	
	List<Member> findAll();

}
