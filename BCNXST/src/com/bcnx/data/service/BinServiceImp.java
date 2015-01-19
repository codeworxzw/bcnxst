package com.bcnx.data.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcnx.data.dao.BinDao;
import com.bcnx.data.entity.Bin;
@Service("binService")
public class BinServiceImp implements BinService {
	private static final Logger logger = Logger.getLogger(BinServiceImp.class);
	@Autowired
	private BinDao binDao;
	public void setBinDao(BinDao binDao){
		this.binDao = binDao;
	}
	@Override
	public void save(Bin bin) {
		try {
			binDao.save(bin);
		} catch (SQLException e) {
			logger.debug("Exception occur while try to save bin",e);
		}
	}

	@Override
	public Bin getBin(int id) {
		Bin bin = new Bin();
		bin.setId(id);
		try {
			return binDao.getBin(bin);
		} catch (SQLException e) {
			logger.debug("Exception occur while try to get Bin",e);
			return null;
		}
	}

	@Override
	public void update(Bin bin) {
		try {
			binDao.update(bin);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to update bin", e);
		}
	}

	@Override
	public List<Bin> getBin() {
		try {
			return binDao.getBins();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get BINs",e);
			return null;
		}
	}
	@Override
	public Bin getBin(String bin) {
		try {
			return binDao.getBin(bin);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get BINs",e);
			return null;
		}
	}
	@Override
	public String[] getBinList() {
		try {
			return binDao.getBinList();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get BINs",e);
			return null;
		}
	}
	@Override
	public List<Bin> getBinLike(String trim) {
		try {
			return binDao.getBinLike(trim);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get BINs",e);
			return null;
		}
	}
	@Override
	public void delete(Bin b) {
		try {
			binDao.delete(b);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to delete BINs",e);
		}
	}

}
