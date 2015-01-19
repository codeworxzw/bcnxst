package com.bcnx.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcnx.application.datasource.DataSource;
import com.bcnx.data.entity.NetMsg;

public class NetMsgDaoImp implements NetMsgDao {
	
	@Override
	public void update(NetMsg netMsg) throws SQLException {
		String sql = "UPDATE NETMSG SET DE70 = ? WHERE MTI= ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, netMsg.getDe70());
		stat.setString(2, netMsg.getMti());
		stat.execute();
	}
	@Override
	public String getDe70() throws SQLException {
		String sql = "SELECT DE70 FROM NETMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de70 = null;
		while(rs.next()){
			de70 = rs.getString("DE70");
		}
		return de70;
	}
	@Override
	public void save(NetMsg netMsg) throws SQLException {
		String sql = "INSERT INTO NETMSG (MTI, DE70) VALUES (?, ?)";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, netMsg.getMti());
		stat.setString(2, netMsg.getDe70());
		stat.execute();
	}
	@Override
	public int check() throws SQLException {
		String sql = "SELECT COUNT(*) AS NUM FROM NETMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		int num = 0;
		while(rs.next()){
			num = rs.getInt("NUM");
		}
		return num;
	}
	
}
