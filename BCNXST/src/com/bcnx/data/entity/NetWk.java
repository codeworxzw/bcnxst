package com.bcnx.data.entity;

import java.io.Serializable;

public class NetWk implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String mode;
	private String ip;
	private int port;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
}
