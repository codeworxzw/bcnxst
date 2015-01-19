package com.bcnx.data.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bcnx.data.dao.CwdMsgDao;
import com.bcnx.data.entity.CwdMsg;

public class CwdMsgServiceImp implements CwdMsgService {
	private static final Logger logger = Logger.getLogger(CwdMsgServiceImp.class);
	private CwdMsgDao cwdMsgDao;
	public void setCwdMsgDao(CwdMsgDao cwdMsgDao){
		this.cwdMsgDao = cwdMsgDao;
	}
	@Override
	public void update(CwdMsg cwdMsg) {
		try {
			cwdMsgDao.update(cwdMsg);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to update cwd msg", e);
		}
	}

	@Override
	public String getDe02() {
		try {
			return cwdMsgDao.getDe02();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de02 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe03() {
		try {
			return cwdMsgDao.getDe03();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de03 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe04() {
		try {
			return cwdMsgDao.getDe04();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de04 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe18() {
		try {
			return cwdMsgDao.getDe18();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de18 for cwd msge", e);
			return null;
		}
	}
	
	public String getDe19(){
		try{
			return cwdMsgDao.getDe19();
		}
		catch(SQLException e){
			logger.debug("Exception occured while try to get de19 for cwd msg", e);
			return null;
		}
	}
	@Override
	public String getDe22() {
		try {
			return cwdMsgDao.getDe22();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de22 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe25() {
		try {
			return cwdMsgDao.getDe25();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de25 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe28() {
		try {
			return cwdMsgDao.getDe28();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de28 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe32() {
		try {
			return cwdMsgDao.getDe32();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de32 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe41() {
		try {
			return cwdMsgDao.getDe41();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de41 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe42() {
		try {
			return cwdMsgDao.getDe42();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de42 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe43() {
		try {
			return cwdMsgDao.getDe43();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de43 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe49() {
		try {
			return cwdMsgDao.getDe49();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de49 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe52() {
		try {
			return cwdMsgDao.getDe52();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de52 for cwd msge", e);
			return null;
		}
	}
	@Override
	public void save(CwdMsg cwdMsg) {
		try {
			cwdMsgDao.save(cwdMsg);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to save cwd msge",e);
		}
	}
	@Override
	public int check() {
		try {
			return cwdMsgDao.check();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to check cwd msge",e);
			return 0;
		}
	}
}
