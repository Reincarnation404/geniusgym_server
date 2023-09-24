package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class CommentPic implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer cp_id;
	private Integer pt_id;
	private Byte[] cp_pic;
	private Timestamp cp_add_time;
	private Timestamp cp_modi_time;
	public Integer getCp_id() {
		return cp_id;
	}
	public void setCp_id(Integer cp_id) {
		this.cp_id = cp_id;
	}
	public Integer getPt_id() {
		return pt_id;
	}
	public void setPt_id(Integer pt_id) {
		this.pt_id = pt_id;
	}
	public Byte[] getCp_pic() {
		return cp_pic;
	}
	public void setCp_pic(Byte[] cp_pic) {
		this.cp_pic = cp_pic;
	}
	public Timestamp getCp_add_time() {
		return cp_add_time;
	}
	public void setCp_add_time(Timestamp cp_add_time) {
		this.cp_add_time = cp_add_time;
	}
	public Timestamp getCp_modi_time() {
		return cp_modi_time;
	}
	public void setCp_modi_time(Timestamp cp_modi_time) {
		this.cp_modi_time = cp_modi_time;
	}
	
	
	
}
