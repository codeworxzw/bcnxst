package com.bcnx.data.entity;

import java.io.Serializable;

public class NetMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mti = "0800";
	private String de07;
	private String de11;
	private String de37;
	private String de70 = "001";
	public String getMti() {
		return mti;
	}
	public void setMti(String mti) {
		this.mti = mti;
	}
	public String getDe07() {
		return de07;
	}
	public void setDe07(String de07) {
		this.de07 = de07;
	}
	public String getDe11() {
		return de11;
	}
	public void setDe11(String de11) {
		this.de11 = de11;
	}
	public String getDe37() {
		return de37;
	}
	public void setDe37(String de37) {
		this.de37 = de37;
	}
	public String getDe70() {
		return de70;
	}
	public void setDe70(String de70) {
		this.de70 = de70;
	}
}
