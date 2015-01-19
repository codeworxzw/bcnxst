package com.bcnx.data.dao;

import java.sql.SQLException;
import java.util.List;

import com.bcnx.data.entity.CardAcct;

public interface CardAcctDao {
	public void save(CardAcct cardAcct) throws SQLException;
	public List<CardAcct> list() throws SQLException;
	public CardAcct getCardAcct(String card) throws SQLException;
	public void update(CardAcct cardAcct) throws SQLException;
	public CardAcct getCardAcct(CardAcct cardAcct) throws SQLException;
	public String getExpDate(String card) throws SQLException;
	public String getCav(String card) throws SQLException;
	public String getType(String card) throws SQLException;
	public String getBalance(String card) throws SQLException;
	public String getCurr(String card) throws SQLException;
	public String getFlag(String card) throws SQLException;
	public List<CardAcct> getCardLike(String card) throws SQLException;
	public void delete(CardAcct c) throws SQLException;
}
