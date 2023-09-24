package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderRec implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer or_id;
	private String m_id;
	private Integer or_amt;
	private Integer or_total;
	public Integer getOr_total() {
		return or_total;
	}
	public void setOr_total(Integer or_total) {
		this.or_total = or_total;
	}
	private Timestamp or_buy_time;
	public Integer getOr_id() {
		return or_id;
	}
	public void setOr_id(Integer or_id) {
		this.or_id = or_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public Integer getOr_amt() {
		return or_amt;
	}
	public void setOr_amt(Integer or_amt) {
		this.or_amt = or_amt;
	}
	public Timestamp getOr_buy_time() {
		return or_buy_time;
	}
	public void setOr_buy_time(Timestamp or_buy_time) {
		this.or_buy_time = or_buy_time;
	}
	
	
}
