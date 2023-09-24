package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer com_id;
	private Integer pt_id;
	private Timestamp com_add_time;
	private Timestamp com_modi_time;
	private String m_id;
	private String c_id;
	private String com_text;
	public Integer getCom_id() {
		return com_id;
	}
	public void setCom_id(Integer com_id) {
		this.com_id = com_id;
	}
	public Integer getPt_id() {
		return pt_id;
	}
	public void setPt_id(Integer pt_id) {
		this.pt_id = pt_id;
	}
	public Timestamp getCom_add_time() {
		return com_add_time;
	}
	public void setCom_add_time(Timestamp com_add_time) {
		this.com_add_time = com_add_time;
	}
	public Timestamp getCom_modi_time() {
		return com_modi_time;
	}
	public void setCom_modi_time(Timestamp com_modi_time) {
		this.com_modi_time = com_modi_time;
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
	public String getCom_text() {
		return com_text;
	}
	public void setCom_text(String com_text) {
		this.com_text = com_text;
	}
	
	
}
