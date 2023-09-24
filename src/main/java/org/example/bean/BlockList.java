package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class BlockList implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer bl_id;
	private String c_id;
	private String m_id;
	private Integer cr_id;
	private Timestamp bl_add_time;
	public Integer getBl_id() {
		return bl_id;
	}
	public void setBl_id(Integer bl_id) {
		this.bl_id = bl_id;
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
	public Integer getCr_id() {
		return cr_id;
	}
	public void setCr_id(Integer cr_id) {
		this.cr_id = cr_id;
	}
	public Timestamp getBl_add_time() {
		return bl_add_time;
	}
	public void setBl_add_time(Timestamp bl_add_time) {
		this.bl_add_time = bl_add_time;
	}
	
	
	
}
