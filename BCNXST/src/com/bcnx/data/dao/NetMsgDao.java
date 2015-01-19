package com.bcnx.data.dao;

import java.sql.SQLException;

import com.bcnx.data.entity.NetMsg;

public interface NetMsgDao {
	public void save(NetMsg netMsg) throws SQLException;
	public void update(NetMsg netMsg) throws SQLException;
	public String getDe70() throws SQLException;
	public int check() throws SQLException;
}
