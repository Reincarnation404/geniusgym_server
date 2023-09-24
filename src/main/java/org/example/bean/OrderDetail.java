package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;


public class OrderDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int od_id;
	private String m_id;
	private int or_id;
	private String c_id;
	private Integer od_total;
	private Integer sc_id;
	private Timestamp od_start_time;
	private Timestamp od_ed_time;
	private Integer cl_id;
	private Timestamp od_update_time;
	
	public int getOd_id() {
		return od_id;
	}
	public void setOd_id(int od_id) {
		this.od_id = od_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getOr_id() {
		return or_id;
	}
	public void setOr_id(int or_id) {
		this.or_id = or_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public Integer getOd_total() {
		return od_total;
	}
	public void setOd_total(Integer od_total) {
		this.od_total = od_total;
	}
	public Integer getSc_id() {
		return sc_id;
	}
	public void setSc_id(Integer sc_id) {
		this.sc_id = sc_id;
	}
	public Timestamp getOd_start_time() {
		return od_start_time;
	}
	public void setOd_start_time(Timestamp od_start_time) {
		this.od_start_time = od_start_time;
	}
	public Timestamp getOd_ed_time() {
		return od_ed_time;
	}
	public void setOd_ed_time(Timestamp od_ed_time) {
		this.od_ed_time = od_ed_time;
	}
	public Integer getCl_id() {
		return cl_id;
	}
	public void setCl_id(Integer cl_id) {
		this.cl_id = cl_id;
	}
	public Timestamp getOd_update_time() {
		return od_update_time;
	}
	public void setOd_update_time(Timestamp od_update_time) {
		this.od_update_time = od_update_time;
	}
	
}
