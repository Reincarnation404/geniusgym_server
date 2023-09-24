package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;


public class DataAgreeList implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer dal_id;
	private String m_id;
	private String c_id;
	private Timestamp dal_add_time;
	private Integer dal_agree;
	private Timestamp dal_update_time;
	public Integer getDal_id() {
		return dal_id;
	}
	public void setDal_id(Integer dal_id) {
		this.dal_id = dal_id;
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
	public Timestamp getDal_add_time() {
		return dal_add_time;
	}
	public void setDal_add_time(Timestamp dal_add_time) {
		this.dal_add_time = dal_add_time;
	}
	public Integer getDal_agree() {
		return dal_agree;
	}
	public void setDal_agree(Integer dal_agree) {
		this.dal_agree = dal_agree;
	}
	public Timestamp getDal_update_time() {
		return dal_update_time;
	}
	public void setDal_update_time(Timestamp dal_update_time) {
		this.dal_update_time = dal_update_time;
	}
	
}
