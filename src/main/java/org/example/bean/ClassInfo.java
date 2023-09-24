package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;


public class ClassInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer ci_id;
	@Override
	public String toString() {
		return "ClassInfo [ci_id=" + ci_id + ", ci_name=" + ci_name + ", ci_start_time=" + ci_start_time
				+ ", ci_ed_time=" + ci_ed_time + ", ci_place=" + ci_place + ", ci_cost=" + ci_cost + ", c_id=" + c_id
				+ ", ci_date=" + ci_date + ", ci_text=" + ci_text + ", ci_limit=" + ci_limit + ", ci_add_time="
				+ ci_add_time + ", bh_id=" + bh_id + ", ci_regi_time=" + ci_regi_time + ", ci_regi_ed_time="
				+ ci_regi_ed_time + ", b_id=" + b_id + ", sc_id=" + sc_id + ", ci_avail=" + ci_avail + ", bh_name="
				+ bh_name + "]";
	}
	private String ci_name;
	private Timestamp ci_start_time;
	private Timestamp ci_ed_time;
	private String ci_place;
	private Integer ci_cost;
	private String c_id;   //新增
	private Timestamp ci_date; 
	private String ci_text;
	private Integer ci_limit;
	private Timestamp ci_add_time;
	private Integer bh_id;
	private Timestamp ci_regi_time;
	private Timestamp ci_regi_ed_time;
	private String b_id;
	private Integer sc_id;
	private Boolean ci_avail;  //新增
	private String bh_name;   //新增
	
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
	public Timestamp getCi_start_time() {
		return ci_start_time;
	}
	public void setCi_start_time(Timestamp ci_start_time) {
		this.ci_start_time = ci_start_time;
	}
	public Timestamp getCi_ed_time() {
		return ci_ed_time;
	}
	public void setCi_ed_time(Timestamp ci_ed_time) {
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
	public Timestamp getCi_date() {
		return ci_date;
	}
	public void setCi_date(Timestamp ci_date) {
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
	public Timestamp getCi_add_time() {
		return ci_add_time;
	}
	public void setCi_add_time(Timestamp ci_add_time) {
		this.ci_add_time = ci_add_time;
	}
	public Integer getBh_id() {
		return bh_id;
	}
	public void setBh_id(Integer bh_id) {
		this.bh_id = bh_id;
	}
	public Timestamp getCi_regi_time() {
		return ci_regi_time;
	}
	public void setCi_regi_time(Timestamp ci_regi_time) {
		this.ci_regi_time = ci_regi_time;
	}
	public Timestamp getCi_regi_ed_time() {
		return ci_regi_ed_time;
	}
	public void setCi_regi_ed_time(Timestamp ci_regi_ed_time) {
		this.ci_regi_ed_time = ci_regi_ed_time;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public Integer getSc_id() {
		return sc_id;
	}
	public void setSc_id(Integer sc_id) {
		this.sc_id = sc_id;
	}
	public Boolean getCi_avail() {
		return ci_avail;
	}
	public void setCi_avail(Boolean ci_avail) {
		this.ci_avail = ci_avail;
	}
	public String getBh_name() {
		return bh_name;
	}
	public void setBh_name(String bh_name) {
		this.bh_name = bh_name;
	}

	
	
}
