package com.bcnx.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcnx.application.datasource.DataSource;
import com.bcnx.data.entity.RevMsg;

public class RevMsgDaoImp implements RevMsgDao {

	@Override
	public void update(RevMsg revMsg) throws SQLException {
		String sql = "UPDATE REVMSG SET DE02 = ?, DE03 = ?, DE04 = ?, DE28 = ?, DE32 = ?, DE41 = ?, DE42 = ?, DE43 = ? WHERE MTI= ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, revMsg.getDe02());
		stat.setString(2, revMsg.getDe03());
		stat.setString(3, revMsg.getDe04());
		stat.setString(4, revMsg.getDe28());
		stat.setString(5, revMsg.getDe32());
		stat.setString(6, revMsg.getDe41());
		stat.setString(7, revMsg.getDe42());
		stat.setString(8, revMsg.getDe43());
		stat.setString(9, revMsg.getMti());
		stat.execute();
	}

	@Override
	public String getDe02() throws SQLException {
		String sql = "SELECT DE02 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de02 = null;
		while(rs.next()){
			de02 = rs.getString("DE02");
		}
		return de02;
	}

	@Override
	public String getDe03() throws SQLException {
		String sql = "SELECT DE03 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de03 = null;
		while(rs.next()){
			de03 = rs.getString("DE03");
		}
		return de03;
	}

	@Override
	public String getDe04() throws SQLException {
		String sql = "SELECT DE04 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de04 = null;
		while(rs.next()){
			de04 = rs.getString("DE04");
		}
		return de04;
	}

	@Override
	public String getDe18() throws SQLException {
		String sql = "SELECT DE18 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de18 = null;
		while(rs.next()){
			de18 = rs.getString("DE18");
		}
		return de18;
	}

	@Override
	public String getDe19() throws SQLException {
		String sql = "SELECT DE19 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de19 = null;
		while(rs.next()){
			de19 = rs.getString("DE19");
		}
		return de19;
	}

	@Override
	public String getDe22() throws SQLException {
		String sql = "SELECT DE22 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de22 = null;
		while(rs.next()){
			de22 = rs.getString("DE22");
		}
		return de22;
	}

	@Override
	public String getDe25() throws SQLException {
		String sql = "SELECT DE25 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de25 = null;
		while(rs.next()){
			de25 = rs.getString("DE25");
		}
		return de25;
	}

	@Override
	public String getDe28() throws SQLException {
		String sql = "SELECT DE28 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de28 = null;
		while(rs.next()){
			de28 = rs.getString("DE28");
		}
		return de28;
	}

	@Override
	public String getDe32() throws SQLException {
		String sql = "SELECT DE32 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de32 = null;
		while(rs.next()){
			de32 = rs.getString("DE32");
		}
		return de32;
	}

	@Override
	public String getDe41() throws SQLException {
		String sql = "SELECT DE41 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de41 = null;
		while(rs.next()){
			de41 = rs.getString("DE41");
		}
		return de41;
	}

	@Override
	public String getDe42() throws SQLException {
		String sql = "SELECT DE42 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de42 = null;
		while(rs.next()){
			de42 = rs.getString("DE42");
		}
		return de42;
	}

	@Override
	public String getDe43() throws SQLException {
		String sql = "SELECT DE43 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de43 = null;
		while(rs.next()){
			de43 = rs.getString("DE43");
		}
		return de43;
	}

	@Override
	public String getDe49() throws SQLException {
		String sql = "SELECT DE49 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de49 = null;
		while(rs.next()){
			de49 = rs.getString("DE49");
		}
		return de49;
	}

	@Override
	public String getDe39() throws SQLException {
		String sql = "SELECT DE39 FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de39 = null;
		while(rs.next()){
			de39 = rs.getString("DE39");
		}
		return de39;
	}

	@Override
	public int check() throws SQLException {
		String sql = "SELECT COUNT(*) AS NUM FROM REVMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		int num = 0;
		while(rs.next()){
			num = rs.getInt("NUM");
		}
		return num;
	}

	@Override
	public void save(RevMsg revMsg) throws SQLException {
		String sql = "INSERT INTO REVMSG (DE02,DE03,DE04,DE28,DE32,DE41,DE42,DE43) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, revMsg.getDe02());
		stat.setString(2, revMsg.getDe03());
		stat.setString(3, revMsg.getDe04());
		stat.setString(4, revMsg.getDe28());
		stat.setString(5, revMsg.getDe32());
		stat.setString(6, revMsg.getDe41());
		stat.setString(7, revMsg.getDe42());
		stat.setString(8, revMsg.getDe43());
		stat.execute();
	}

}
