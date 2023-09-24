package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Chatroom implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer cr_id;
	private String c_id;
	private String m_id;
	private Timestamp cr_add_time;
	public Integer getCr_id() {
		return cr_id;
	}
	public void setCr_id(Integer cr_id) {
		this.cr_id = cr_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public Timestamp getCr_add_time() {
		return cr_add_time;
	}
	public void setCr_add_time(Timestamp cr_add_time) {
		this.cr_add_time = cr_add_time;
	}
	
	
}
