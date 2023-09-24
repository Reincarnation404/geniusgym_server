package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer msg_id;
	private Integer cr_id;
	private String m_id;
	private String c_id;
	private String msg_text;
	private Timestamp msg_add_time;
	public Integer getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(Integer msg_id) {
		this.msg_id = msg_id;
	}
	public Integer getCr_id() {
		return cr_id;
	}
	public void setCr_id(Integer cr_id) {
		this.cr_id = cr_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getMsg_text() {
		return msg_text;
	}
	public void setMsg_text(String msg_text) {
		this.msg_text = msg_text;
	}
	public Timestamp getMsg_add_time() {
		return msg_add_time;
	}
	public void setMsg_add_time(Timestamp msg_add_time) {
		this.msg_add_time = msg_add_time;
	}
	
	
	
}
