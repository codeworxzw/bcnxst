package com.bcnx.data.entity;

import java.io.Serializable;

public class CardAcct implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String card;
	private String type;
	private String curr;
	private String flag;
	private double bal;
	private String exp;
	private String cav;
	private String bin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCurr() {
		return curr;
	}
	public void setCurr(String curr) {
		this.curr = curr;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getCav() {
		return cav;
	}
	public void setCav(String cav) {
		this.cav = cav;
	}
	public String getBin() {
		return bin;
	}
	public void setBin(String bin) {
		this.bin = bin;
	}
}
