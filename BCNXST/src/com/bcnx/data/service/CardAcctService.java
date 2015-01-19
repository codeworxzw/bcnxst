package com.bcnx.data.service;

import java.util.List;

import com.bcnx.data.entity.CardAcct;

public interface CardAcctService {
	public void save(CardAcct cardAcct);
	public void update(CardAcct carAcct);
	public List<CardAcct> getCardAccts();
	public CardAcct getCardAcct(CardAcct cardAcct);
	public String getExpiryDate(String card);
	public String getCav(String card);
	public String getAmtType(String card);
	public String getBalance(String card);
	public String getCurrency(String card);
	public String getFlag(String card);
	public List<CardAcct> getCardLike(String card);
	public void delete(CardAcct c);
}
