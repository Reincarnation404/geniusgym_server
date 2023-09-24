package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

public class Coach implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String c_id;

	@Override
	public String toString() {
		return "Coach{" +
				"c_id='" + c_id + '\'' +
				", c_pwd='" + c_pwd + '\'' +
				", c_name='" + c_name + '\'' +
				", c_gen=" + c_gen +
				", c_cell='" + c_cell + '\'' +
				", c_twid='" + c_twid + '\'' +
				", c_addr='" + c_addr + '\'' +
				", c_start_date=" + c_start_date +
				", c_add_time=" + c_add_time +
				", c_modi_time=" + c_modi_time +
				", b_id='" + b_id + '\'' +
				", c_email='" + c_email + '\'' +
				", c_intro='" + c_intro + '\'' +
				", c_sus=" + c_sus +
				", c_picBase64='" + c_picBase64 + '\'' +
				", c_pic=" + Arrays.toString(c_pic) +
				", bh_id=" + bh_id +
				", bh_name='" + bh_name + '\'' +
				'}';
	}

	private String c_pwd;
	private String c_name;
	private Integer c_gen;
	private String c_cell;
	private String c_twid;
	private String c_addr;
	private Timestamp c_start_date;
	private Timestamp c_add_time;
	private Timestamp c_modi_time;
	private String b_id;
	private String c_email;
	private String c_intro;
	private Boolean c_sus;
	private String c_picBase64;   //新增
	private byte[] c_pic;
	private Integer bh_id;
	private String bh_name;   //新增
	
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
	public String getC_pwd() {
		return c_pwd;
	}
	public void setC_pwd(String c_pwd) {
		this.c_pwd = c_pwd;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Integer getC_gen() {
		return c_gen;
	}
	public void setC_gen(Integer c_gen) {
		this.c_gen = c_gen;
	}
	public String getC_cell() {
		return c_cell;
	}
	public void setC_cell(String c_cell) {
		this.c_cell = c_cell;
	}
	public String getC_twid() {
		return c_twid;
	}
	public void setC_twid(String c_twid) {
		this.c_twid = c_twid;
	}
	public String getC_addr() {
		return c_addr;
	}
	public void setC_addr(String c_addr) {
		this.c_addr = c_addr;
	}
	public Timestamp getC_start_date() {
		return c_start_date;
	}
	public void setC_start_date(Timestamp c_start_date) {
		this.c_start_date = c_start_date;
	}
	public Timestamp getC_add_time() {
		return c_add_time;
	}
	public void setC_add_time(Timestamp c_add_time) {
		this.c_add_time = c_add_time;
	}
	public Timestamp getC_modi_time() {
		return c_modi_time;
	}
	public void setC_modi_time(Timestamp c_modi_time) {
		this.c_modi_time = c_modi_time;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getC_email() {
		return c_email;
	}
	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	public String getC_intro() {
		return c_intro;
	}
	public void setC_intro(String c_intro) {
		this.c_intro = c_intro;
	}
	public Boolean getC_sus() {
		return c_sus;
	}
	public void setC_sus(Boolean c_sus) {
		this.c_sus = c_sus;
	}
	public byte[] getC_pic() {
		return c_pic;
	}
	public void setC_pic(byte[] c_pic) {
		this.c_pic = c_pic;
	}
	public String getC_picBase64() {
		return c_picBase64;
	}
	public void setC_picBase64(String c_picBase64) {
		this.c_picBase64 = c_picBase64;
	}
	public String getBh_name() {
		return bh_name;
	}
	public void setBh_name(String bh_name) {
		this.bh_name = bh_name;
	}
	
	

}
