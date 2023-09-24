package org.example.brian_background.model;

import java.io.Serializable;

public class ClassInfoReturn implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer ci_id;
	private String ci_name;
	private String ci_start_time;
	private String ci_ed_time;
	private String ci_place;
	private Integer ci_cost;
	private Integer sc_id;
	private String ci_date;
	private String ci_text;
	private Integer ci_limit;
	private Integer bh_id;
	private String c_id;
	
	public Integer getCi_id() {
		return ci_id;
	}
	public void setCi_id(Integer ci_id) {
		this.ci_id = ci_id;
	}
	public String getCi_name() {
		return ci_name;
	}
	public void setCi_name(String ci_name) {
		this.ci_name = ci_name;
	}
	public String getCi_start_time() {
		return ci_start_time;
	}
	public void setCi_start_time(String ci_start_time) {
		this.ci_start_time = ci_start_time;
	}
	public String getCi_ed_time() {
		return ci_ed_time;
	}
	public void setCi_ed_time(String ci_ed_time) {
		this.ci_ed_time = ci_ed_time;
	}
	public String getCi_place() {
		return ci_place;
	}
	public void setCi_place(String ci_place) {
		this.ci_place = ci_place;
	}
	public Integer getCi_cost() {
		return ci_cost;
	}
	public void setCi_cost(Integer ci_cost) {
		this.ci_cost = ci_cost;
	}
	public Integer getSc_id() {
		return sc_id;
	}
	public void setSc_id(Integer sc_id) {
		this.sc_id = sc_id;
	}
	public String getCi_date() {
		return ci_date;
	}
	public void setCi_date(String ci_date) {
		this.ci_date = ci_date;
	}
	public String getCi_text() {
		return ci_text;
	}
	public void setCi_text(String ci_text) {
		this.ci_text = ci_text;
	}
	public Integer getCi_limit() {
		return ci_limit;
	}
	public void setCi_limit(Integer ci_limit) {
		this.ci_limit = ci_limit;
	}
	public Integer getBh_id() {
		return bh_id;
	}
	public void setBh_id(Integer bh_id) {
		this.bh_id = bh_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	
}
