package org.example.bean;

import java.io.Serializable;

public class Branch implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer bh_id;
	private String bh_name;
	private String bh_addr;
	private String bh_cell;
	private String bh_start_time;
	private String bh_ed_time;
	
	public Integer getBh_id() {
		return bh_id;
	}
	public void setBh_id(Integer bh_id) {
		this.bh_id = bh_id;
	}
	public String getBh_name() {
		return bh_name;
	}
	public void setBh_name(String bh_name) {
		this.bh_name = bh_name;
	}
	public String getBh_addr() {
		return bh_addr;
	}
	public void setBh_addr(String bh_addr) {
		this.bh_addr = bh_addr;
	}
	public String getBh_cell() {
		return bh_cell;
	}
	public void setBh_cell(String bh_cell) {
		this.bh_cell = bh_cell;
	}
	public String getBh_start_time() {
		return bh_start_time;
	}
	public void setBh_start_time(String bh_start_time) {
		this.bh_start_time = bh_start_time;
	}
	public String getBh_ed_time() {
		return bh_ed_time;
	}
	public void setBh_ed_time(String bh_ed_time) {
		this.bh_ed_time = bh_ed_time;
	}
	
	
}
