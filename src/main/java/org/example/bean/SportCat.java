package org.example.bean;

import java.io.Serializable;

public class SportCat implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer sc_id;
	private Integer sb_id;
	private String sc_name;
	
	public Integer getSb_id() {
		return sb_id;
	}
	public void setSb_id(Integer sb_id) {
		this.sb_id = sb_id;
	}
	public Integer getSc_id() {
		return sc_id;
	}
	public void setSc_id(Integer sc_id) {
		this.sc_id = sc_id;
	}
	public String getSc_name() {
		return sc_name;
	}
	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}
	
}
