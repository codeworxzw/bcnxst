package com.bcnx.data.entity;

import java.io.Serializable;

public class Bin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String bin;
	private String type;
	private String iin;
	public String getBin() {
		return bin;
	}
	public void setBin(String bin) {
		this.bin = bin;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIin() {
		return iin;
	}
	public void setIin(String iin) {
		this.iin = iin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
