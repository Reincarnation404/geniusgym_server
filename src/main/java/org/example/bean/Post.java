package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Post implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer pt_id;
	private Timestamp pt_add_time;
	private Timestamp pt_update_time;
	private String pt_user_code;
	private String pt_text;
	public Integer getPt_id() {
		return pt_id;
	}
	public void setPt_id(Integer pt_id) {
		this.pt_id = pt_id;
	}
	public Timestamp getPt_add_time() {
		return pt_add_time;
	}
	public void setPt_add_time(Timestamp pt_add_time) {
		this.pt_add_time = pt_add_time;
	}
	public Timestamp getPt_update_time() {
		return pt_update_time;
	}
	public void setPt_update_time(Timestamp pt_update_time) {
		this.pt_update_time = pt_update_time;
	}
	public String getPt_user_code() {
		return pt_user_code;
	}
	public void setPt_user_code(String pt_user_code) {
		this.pt_user_code = pt_user_code;
	}
	public String getPt_text() {
		return pt_text;
	}
	public void setPt_text(String pt_text) {
		this.pt_text = pt_text;
	}

}
