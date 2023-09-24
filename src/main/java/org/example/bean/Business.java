package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;


public class Business implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String b_id;
	private String b_pwd;
	private String b_name;
	private Integer b_gen;
	private String b_cell;
	private String b_twid;
	private String b_addr;
	private Timestamp b_start_date;
	private Timestamp b_add_time;
	private Timestamp b_modi_time;
	private String b_modi_id;
	private String b_email;
	private Integer bh_id;
	private String bh_name;   //新增
	private Boolean b_sus;
	
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_pwd() {
		return b_pwd;
	}
	public void setB_pwd(String b_pwd) {
		this.b_pwd = b_pwd;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public Integer getB_gen() {
		return b_gen;
	}
	public void setB_gen(Integer b_gen) {
		this.b_gen = b_gen;
	}
	public String getB_cell() {
		return b_cell;
	}
	public void setB_cell(String b_cell) {
		this.b_cell = b_cell;
	}
	public String getB_twid() {
		return b_twid;
	}
	public void setB_twid(String b_twid) {
		this.b_twid = b_twid;
	}
	public String getB_addr() {
		return b_addr;
	}
	public void setB_addr(String b_addr) {
		this.b_addr = b_addr;
	}
	public Timestamp getB_start_date() {
		return b_start_date;
	}
	public void setB_start_date(Timestamp b_start_date) {
		this.b_start_date = b_start_date;
	}
	public Timestamp getB_add_time() {
		return b_add_time;
	}
	public void setB_add_time(Timestamp b_add_time) {
		this.b_add_time = b_add_time;
	}
	public Timestamp getB_modi_time() {
		return b_modi_time;
	}
	public void setB_modi_time(Timestamp b_modi_time) {
		this.b_modi_time = b_modi_time;
	}
	public String getB_modi_id() {
		return b_modi_id;
	}
	public void setB_modi_id(String b_modi_id) {
		this.b_modi_id = b_modi_id;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String b_email) {
		this.b_email = b_email;
	}

	public Integer getBh_id() {
		return bh_id;
	}
	public void setBh_id(Integer bh_id) {
		this.bh_id = bh_id;
	}
	public Boolean getB_sus() {
		return b_sus;
	}
	public void setB_sus(Boolean b_sus) {
		this.b_sus = b_sus;
	}
	public String getBh_name(){
		return bh_name;
	}
	public void setBh_name(String bh_name) {
		this.bh_name = bh_name;
	}
	
	
	
}
