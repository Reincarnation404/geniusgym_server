package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;


public class Member implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String m_id;
	private String m_pwd;
	private String m_name;
	private Integer m_gen;
	private String m_cell;
	private String m_twid;
	private String m_addr;
	private Timestamp m_ed_date;
	private Timestamp m_add_time;
	private Timestamp m_modi_time;
	private String b_id;
	private String m_email;
	private String m_picBase64;
	private byte[] m_pic;
	private Boolean m_sus;
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public Integer getM_gen() {
		return m_gen;
	}
	public void setM_gen(Integer m_gen) {
		this.m_gen = m_gen;
	}
	public String getM_cell() {
		return m_cell;
	}
	public void setM_cell(String m_cell) {
		this.m_cell = m_cell;
	}
	public String getM_twid() {
		return m_twid;
	}
	public void setM_twid(String m_twid) {
		this.m_twid = m_twid;
	}
	public String getM_addr() {
		return m_addr;
	}
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	public Timestamp getM_ed_date() {
		return m_ed_date;
	}
	public void setM_ed_date(Timestamp m_ed_date) {
		this.m_ed_date = m_ed_date;
	}
	public Timestamp getM_add_time() {
		return m_add_time;
	}
	public void setM_add_time(Timestamp m_add_time) {
		this.m_add_time = m_add_time;
	}
	public Timestamp getM_modi_time() {
		return m_modi_time;
	}
	public void setM_modi_time(Timestamp m_modi_time) {
		this.m_modi_time = m_modi_time;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public byte[] getM_pic() {
		return m_pic;
	}
	public void setM_pic(byte[] m_pic) {
		this.m_pic = m_pic;
	}
	public Boolean getM_sus() {
		return m_sus;
	}
	public void setM_sus(Boolean m_sus) {
		this.m_sus = m_sus;
	}
	public String getM_picBase64() {
		return m_picBase64;
	}
	public void setM_picBase64(String m_picBase64) {
		this.m_picBase64 = m_picBase64;
	}
	
	
	
}
