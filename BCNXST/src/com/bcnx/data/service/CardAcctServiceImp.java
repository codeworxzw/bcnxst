package com.bcnx.data.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.bcnx.data.dao.CardAcctDao;
import com.bcnx.data.entity.CardAcct;

public class CardAcctServiceImp implements CardAcctService {
	private static final Logger logger = Logger.getLogger(CardAcctServiceImp.class);
	private CardAcctDao cardAcctDao;
	public void setCardAcctDao(CardAcctDao cardAcctDao){
		this.cardAcctDao = cardAcctDao;
	}
	@Override
	public void save(CardAcct cardAcct) {
		try {
			cardAcctDao.save(cardAcct);
		} catch (SQLException e) {
			logger.debug("Exception occur while try to save card",e);
			e.printStackTrace();
		}
	}

	@Override
	public void update(CardAcct cardAcct) {
		try {
			cardAcctDao.update(cardAcct);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to update card", e);
		}
	}

	@Override
	public List<CardAcct> getCardAccts() {
		try {
			return cardAcctDao.list();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to fetch cards list",e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CardAcct getCardAcct(CardAcct cardAcct) {
		try {
			return cardAcctDao.getCardAcct(cardAcct);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to fetch card", e);
			return null;
		}
	}

	@Override
	public String getExpiryDate(String card) {
		try {
			return cardAcctDao.getExpDate(card);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to fetch exp", e);
			return null;
		}
	}

	@Override
	public String getCav(String card) {
		try {
			return cardAcctDao.getCav(card);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to fetch CAV", e);
			return null;
		}
	}

	@Override
	public String getAmtType(String card) {
		try {
			return cardAcctDao.getType(card);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to fetch type",e);
			return null;
		}
	}

	@Override
	public String getBalance(String card) {
		try {
			return cardAcctDao.getBalance(card);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to fetch balance",e);
			return null;
		}
	}

	@Override
	public String getCurrency(String card) {
		try {
			return cardAcctDao.getCurr(card);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to fetch currency",e);
			return null;
		}
	}

	@Override
	public String getFlag(String card) {
		try {
			return cardAcctDao.getFlag(card);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to fetch flag",e);
			return null;
		}
	}

	@Override
	public List<CardAcct> getCardLike(String card) {
		try {
			return cardAcctDao.getCardLike(card);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to fetch card",e);
			return null;
		}
	}

	@Override
	public void delete(CardAcct c) {
		try {
			cardAcctDao.delete(c);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to delete card",e);
		}
	}

}
