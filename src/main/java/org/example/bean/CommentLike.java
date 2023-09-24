package org.example.bean;

import java.io.Serializable;

public class CommentLike implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer cl_id;
	private Integer pt_id;
	private String m_id;
	private String c_id;
	private Integer lc_id;
	public Integer getCl_id() {
		return cl_id;
	}
	public void setCl_id(Integer cl_id) {
		this.cl_id = cl_id;
	}
	public Integer getPt_id() {
		return pt_id;
	}
	public void setPt_id(Integer pt_id) {
		this.pt_id = pt_id;
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
	public Integer getLc_id() {
		return lc_id;
	}
	public void setLc_id(Integer lc_id) {
		this.lc_id = lc_id;
	}
	
	
	
}
