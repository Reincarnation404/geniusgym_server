package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class SavedPost implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer sp_id;
	private String m_id;
	private Integer pt_id;
	private Timestamp sp_add_time;
	public Integer getSp_id() {
		return sp_id;
	}
	public void setSp_id(Integer sp_id) {
		this.sp_id = sp_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public Integer getPt_id() {
		return pt_id;
	}
	public void setPt_id(Integer pt_id) {
		this.pt_id = pt_id;
	}
	public Timestamp getSp_add_time() {
		return sp_add_time;
	}
	public void setSp_add_time(Timestamp sp_add_time) {
		this.sp_add_time = sp_add_time;
	}
	
}
