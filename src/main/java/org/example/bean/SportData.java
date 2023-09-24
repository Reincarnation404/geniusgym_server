package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class SportData implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer sd_id;
	private String sd_bigid;
	private String m_id;
	private Timestamp sd_update_time;
	private Integer sc_id;
	private Float sc_weigt;
	private Integer sc_freq;
	private Integer sc_set;
	private String c_id;
	private String sd_record_time;
	
	public Timestamp getSd_update_time() {
		return sd_update_time;
	}
	public void setSd_update_time(Timestamp sd_update_time) {
		this.sd_update_time = sd_update_time;
	}
	
	public Integer getSd_id() {
		return sd_id;
	}
	public void setSd_id(Integer sd_id) {
		this.sd_id = sd_id;
	}
	public String getSd_bigid() {
		return sd_bigid;
	}
	public void setSd_bigid(String sd_bigid) {
		this.sd_bigid = sd_bigid;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public Integer getSc_id() {
		return sc_id;
	}
	public void setSc_id(Integer sc_id) {
		this.sc_id = sc_id;
	}
	public Float getSc_weigt() {
		return sc_weigt;
	}
	public void setSc_weigt(Float sc_weigt) {
		this.sc_weigt = sc_weigt;
	}
	public Integer getSc_freq() {
		return sc_freq;
	}
	public void setSc_freq(Integer sc_freq) {
		this.sc_freq = sc_freq;
	}
	public Integer getSc_set() {
		return sc_set;
	}
	public void setSc_set(Integer sc_set) {
		this.sc_set = sc_set;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getSd_record_time() {
		return sd_record_time;
	}
	public void setSd_record_time(String sd_record_time) {
		this.sd_record_time = sd_record_time;
	}


}
