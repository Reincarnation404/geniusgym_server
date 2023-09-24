package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class BodyData implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer bd_id;
	private String m_id;
	private Float bd_hgt;
	private Float bd_wgt;
	private Float bd_fat;
	private Timestamp bd_add_time;
	private Timestamp bd_update_time;
	public Integer getBd_id() {
		return bd_id;
	}
	public void setBd_id(Integer bd_id) {
		this.bd_id = bd_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public Float getBd_hgt() {
		return bd_hgt;
	}
	public void setBd_hgt(Float bd_hgt) {
		this.bd_hgt = bd_hgt;
	}
	public Float getBd_wgt() {
		return bd_wgt;
	}
	public void setBd_wgt(Float bd_wgt) {
		this.bd_wgt = bd_wgt;
	}
	public Float getBd_fat() {
		return bd_fat;
	}
	public void setBd_fat(Float bd_fat) {
		this.bd_fat = bd_fat;
	}
	public Timestamp getBd_add_time() {
		return bd_add_time;
	}
	public void setBd_add_time(Timestamp bd_add_time) {
		this.bd_add_time = bd_add_time;
	}
	public Timestamp getBd_update_time() {
		return bd_update_time;
	}
	public void setBd_update_time(Timestamp bd_update_time) {
		this.bd_update_time = bd_update_time;
	}

	
}
