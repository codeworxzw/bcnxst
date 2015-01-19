package com.bcnx.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcnx.application.datasource.DataSource;
import com.bcnx.data.entity.NetWk;

public class NetWkDaoImp implements NetWkDao {

	@Override
	public void save(NetWk netWk) throws SQLException {
		String sql = "insert into NETWK(MODE, IP, PORT) values (?, ?, ?)";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, netWk.getMode());
		stat.setString(2, netWk.getIp());
		stat.setInt(3, netWk.getPort());
		stat.execute();
	}

	@Override
	public void update(NetWk netWk) throws SQLException {
		String sql = "UPDATE NETWK SET IP = ?, PORT = ? WHERE MODE = ? ";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		
		stat.setString(1, netWk.getIp());
		stat.setInt(2, netWk.getPort());
		stat.setString(3, netWk.getMode());
		
		stat.execute();
	}

	@Override
	public NetWk getNetWk(String mode) throws SQLException {
		String sql = "SELECT IP, PORT FROM NETWK WHERE MODE = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, mode);
		ResultSet rs = stat.executeQuery();
		NetWk netWk = null;
		while(rs.next()){
			String ip = rs.getString("IP");
			int port = rs.getInt("PORT");
			netWk = new NetWk();
			netWk.setIp(ip);
			netWk.setPort(port);
		}
		return netWk;
	}

	@Override
	public int checkNetWk(int id) throws SQLException {
		String sql = "SELECT COUNT(*) AS NUM FROM NETWK WHERE ID = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, id);
		ResultSet rs = stat.executeQuery();
		int num = 0;
		while(rs.next()){
			num = rs.getInt("NUM");
		}
		return num;
	}

}
