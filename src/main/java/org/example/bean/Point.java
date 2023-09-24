package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Point implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer p_id;
	private String m_id;
	private Integer p_left;
	private Integer p_card;
	private Timestamp p_modi_time;
	private String p_rec;
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public Integer getP_left() {
		return p_left;
	}
	public void setP_left(Integer p_left) {
		this.p_left = p_left;
	}
	public Integer getP_card() {
		return p_card;
	}
	public void setP_card(Integer p_card) {
		this.p_card = p_card;
	}
	public Timestamp getP_modi_time() {
		return p_modi_time;
	}
	public void setP_modi_time(Timestamp p_modi_time) {
		this.p_modi_time = p_modi_time;
	}
	public String getP_rec() {
		return p_rec;
	}
	public void setP_rec(String p_rec) {
		this.p_rec = p_rec;
	}
	
}
