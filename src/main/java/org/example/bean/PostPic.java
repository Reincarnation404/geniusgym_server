package org.example.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class PostPic implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer pp_id;
	private Integer pt_id;
	private Byte[] pp_pic;
	private Timestamp pp_add_time;
	private Timestamp pp_modi_time;
	public Integer getPp_id() {
		return pp_id;
	}
	public void setPp_id(Integer pp_id) {
		this.pp_id = pp_id;
	}
	public Integer getPt_id() {
		return pt_id;
	}
	public void setPt_id(Integer pt_id) {
		this.pt_id = pt_id;
	}
	public Byte[] getPp_pic() {
		return pp_pic;
	}
	public void setPp_pic(Byte[] pp_pic) {
		this.pp_pic = pp_pic;
	}
	public Timestamp getPp_add_time() {
		return pp_add_time;
	}
	public void setPp_add_time(Timestamp pp_add_time) {
		this.pp_add_time = pp_add_time;
	}
	public Timestamp getPp_modi_time() {
		return pp_modi_time;
	}
	public void setPp_modi_time(Timestamp pp_modi_time) {
		this.pp_modi_time = pp_modi_time;
	}
	
	
}
