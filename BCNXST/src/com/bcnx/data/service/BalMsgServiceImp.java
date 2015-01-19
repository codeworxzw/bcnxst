package com.bcnx.data.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bcnx.data.dao.BalMsgDao;
import com.bcnx.data.entity.BalMsg;

public class BalMsgServiceImp implements BalMsgService {
	private static final Logger logger = Logger.getLogger(BalMsgServiceImp.class);
	private BalMsgDao balMsgDao;
	public void setBalMsgDao(BalMsgDao balMsgDao){
		this.balMsgDao = balMsgDao;
	}
	@Override
	public void update(BalMsg balMsg) {
		try {
			balMsgDao.update(balMsg);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to update balance message", e);
		}
	}

	@Override
	public String getDe02() {
		try {
			return balMsgDao.getDe02();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de02 for bal msge", e);
			return null;
		}
	}

	@Override
	public String getDe03() {
		try {
			return balMsgDao.getDe03();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de03 for bal msge", e);
			return null;
		}
	}

	@Override
	public String getDe04() {
		try {
			return balMsgDao.getDe04();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de04 for bal msge", e);
			return null;
		}
	}

	@Override
	public String getDe18() {
		try {
			return balMsgDao.getDe18();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de18 for bal msge", e);
			return null;
		}
	}
	@Override
	public String getDe19(){
		try {
			return balMsgDao.getDe19();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de19 for bal msg", e);
			return null;
		}
	}
	@Override
	public String getDe22() {
		try {
			return balMsgDao.getDe22();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de22 for bal msge", e);
			return null;
		}
	}

	@Override
	public String getDe25() {
		try {
			return balMsgDao.getDe25();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de25 for bal msge", e);
			return null;
		}
	}

	@Override
	public String getDe28() {
		try {
			return balMsgDao.getDe28();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de28 for bal msge", e);
			return null;
		}
	}

	@Override
	public String getDe32() {
		try {
			return balMsgDao.getDe32();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de32 for bal msge", e);
			return null;
		}
	}

	@Override
	public String getDe41() {
		try {
			return balMsgDao.getDe41();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de41 for bal msge", e);
			return null;
		}
	}

	@Override
	public String getDe42() {
		try {
			return balMsgDao.getDe42();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de42 for bal msge", e);
			return null;
		}
	}

	@Override
	public String getDe43() {
		try {
			return balMsgDao.getDe43();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de43 for bal msge", e);
			return null;
		}
	}

	@Override
	public String getDe49() {
		try {
			return balMsgDao.getDe49();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de49 for bal msge", e);
			return null;
		}
	}

	@Override
	public String getDe52() {
		try {
			return balMsgDao.getDe52();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de52 for bal msge", e);
			return null;
		}
	}
	@Override
	public int checkRecord() {
		try {
			return balMsgDao.check();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to check data for bal msge", e);
			return 0;
		}
	}
	@Override
	public void save(BalMsg balMsg) {
		try {
			balMsgDao.save(balMsg);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to save data for bal msge", e);
		}
	}
	
}
