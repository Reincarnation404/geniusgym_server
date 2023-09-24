package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Notify implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer nt_id;
	private String m_id;
	private Timestamp nt_send_time;
	private Integer bh_id;
	private String nt_text;
	private byte[] nt_pic;

	private String nt_title;

	public Notify() {
	}

	public Integer getNt_id() {
		return nt_id;
	}
	public void setNt_id(Integer nt_id) {
		this.nt_id = nt_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public Timestamp getNt_send_time() {
		return nt_send_time;
	}
	public void setNt_send_time(Timestamp nt_send_time) {
		this.nt_send_time = nt_send_time;
	}
	public Integer getBh_id() {
		return bh_id;
	}
	public void setBh_id(Integer bh_id) {
		this.bh_id = bh_id;
	}
	public String getNt_text() {
		return nt_text;
	}
	public void setNt_text(String nt_text) {
		this.nt_text = nt_text;
	}
	public byte[] getNt_pic() {
		return nt_pic;
	}
	public void setNt_pic(byte[] nt_pic) {
		this.nt_pic = nt_pic;
	}

	public String getNt_title() {
		return nt_title;
	}

	public void setNt_title(String nt_title) {
		this.nt_title = nt_title;
	}
}
