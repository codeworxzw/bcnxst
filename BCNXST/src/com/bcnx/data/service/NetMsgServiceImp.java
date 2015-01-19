package com.bcnx.data.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bcnx.data.dao.NetMsgDao;
import com.bcnx.data.entity.NetMsg;

public class NetMsgServiceImp implements NetMsgService {
	private static final Logger logger = Logger.getLogger(NetMsgServiceImp.class);
	private NetMsgDao netMsgDao;
	public void setNetMsgDao(NetMsgDao netMsgDao){
		this.netMsgDao = netMsgDao;
	}
	@Override
	public void update(NetMsg netMsg) {
		try {
			netMsgDao.update(netMsg);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to update network message setting",e);
		}
	}

	@Override
	public String getDe70() {
		try {
			return netMsgDao.getDe70();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get data element 70",e);
			return null;
		}
	}
	@Override
	public void save(NetMsg netMsg) {
		try {
			netMsgDao.save(netMsg);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to save network message",e);
		}
		
	}
	@Override
	public int check() {
		try {
			return netMsgDao.check();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to check record",e);
			return 0;
		}
	}

}
