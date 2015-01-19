package com.bcnx.data.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bcnx.data.dao.RevMsgDao;
import com.bcnx.data.entity.RevMsg;

public class RevMsgServiceImp implements RevMsgService {
	private static final Logger logger = Logger.getLogger(RevMsgServiceImp.class);
	private RevMsgDao revMsgDao;
	
	public void setRevMsgDao(RevMsgDao revMsgDao) {
		this.revMsgDao = revMsgDao;
	}

	@Override
	public void update(RevMsg revMsg) {
		try {
			revMsgDao.update(revMsg);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to update reversal message",e);
		}
	}


	@Override
	public String getDe02() {
		try {
			return revMsgDao.getDe02();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de02 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe03() {
		try {
			return revMsgDao.getDe03();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de03 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe04() {
		try {
			return revMsgDao.getDe04();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de04 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe18() {
		try {
			return revMsgDao.getDe18();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de18 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe22() {
		try {
			return revMsgDao.getDe22();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de22 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe25() {
		try {
			return revMsgDao.getDe25();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de25 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe28() {
		try {
			return revMsgDao.getDe28();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de28 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe32() {
		try {
			return revMsgDao.getDe32();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de32 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe41() {
		try {
			return revMsgDao.getDe41();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de41 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe42() {
		try {
			return revMsgDao.getDe42();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de42 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe43() {
		try {
			return revMsgDao.getDe43();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de43 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe49() {
		try {
			return revMsgDao.getDe49();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de49 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe39() {
		try {
			return revMsgDao.getDe39();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de49 for cwd msge", e);
			return null;
		}
	}

	@Override
	public String getDe19() {
		try {
			return revMsgDao.getDe19();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get de49 for cwd msge", e);
			return null;
		}
	}

	@Override
	public int check() {
		try {
			return revMsgDao.check();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to check cwd",e);
			return 0;
		}
	}

	@Override
	public void save(RevMsg revMsg) {
		try {
			revMsgDao.save(revMsg);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to save cwd",e);
		}
	}
}
