package com.bcnx.data.entity;

import java.io.Serializable;

public class Member implements Serializable{

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String memId;
	private String name;
	private String location;
	private String iin;
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIin() {
		return iin;
	}
	public void setIin(String iin) {
		this.iin = iin;
	}
}
