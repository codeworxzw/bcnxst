package com.bcnx.data.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bcnx.data.dao.NetWkDao;
import com.bcnx.data.entity.NetWk;

public class NetWkServiceImp implements NetWkService {
	private static final Logger logger = Logger.getLogger(NetWkServiceImp.class);
	private NetWkDao netWkDao;
	public void setNetWkDao(NetWkDao netWkDao){
		this.netWkDao = netWkDao;
	}
	@Override
	public void save(NetWk netWk) {
		try {
			netWkDao.save(netWk);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to save network setup",e);
		}
	}

	@Override
	public void update(NetWk netWk) {
		try {
			netWkDao.update(netWk);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to update network setup",e);
		}
	}

	@Override
	public NetWk getNetWk(String mode) {
		try {
			return netWkDao.getNetWk(mode);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get network",e);
			return null;
		}
	}

	@Override
	public int checkNetWk(int id) {
		try {
			return netWkDao.checkNetWk(id);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get network", e);
			return 0;
		}
	}

}
