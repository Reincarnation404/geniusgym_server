package org.example.bean;

import java.io.Serializable;

public class SportBigId implements Serializable{


	private static final long serialVersionUID = 1L;
	private int sb_id;
	private String sb_cat;
	private String sb_name;
	
	
	public int getSb_id() {
		return sb_id;
	}
	public void setSb_id(int sb_id) {
		this.sb_id = sb_id;
	}
	public String getSb_cat() {
		return sb_cat;
	}
	public void setSb_cat(String sb_cat) {
		this.sb_cat = sb_cat;
	}
	public String getSb_name() {
		return sb_name;
	}
	public void setSb_name(String sb_name) {
		this.sb_name = sb_name;
	}


}
