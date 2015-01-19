package com.bcnx.data.dao;

import java.sql.SQLException;

import com.bcnx.data.entity.NetWk;

public interface NetWkDao {
	public void save(NetWk netWk) throws SQLException;
	public void update(NetWk netWk) throws SQLException;
	public NetWk getNetWk(String mode) throws SQLException;
	public int checkNetWk(int id) throws SQLException;
}
