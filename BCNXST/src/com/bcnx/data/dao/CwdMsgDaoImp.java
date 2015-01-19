package com.bcnx.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcnx.application.datasource.DataSource;
import com.bcnx.data.entity.CwdMsg;

public class CwdMsgDaoImp implements CwdMsgDao {

	@Override
	public void update(CwdMsg cwdMsg) throws SQLException {
		String sql = "UPDATE CWDMSG SET DE02 = ?, DE03 = ?, DE04 = ?, DE28 = ?, DE32 = ?, DE41 = ?, DE42 = ?, DE43 = ?, DE52 = ? WHERE MTI= ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString( 1, cwdMsg.getDe02());
		stat.setString( 2, cwdMsg.getDe03());
		stat.setString( 3, cwdMsg.getDe04());
		stat.setString( 4, cwdMsg.getDe28());
		stat.setString( 5, cwdMsg.getDe32());
		stat.setString( 6, cwdMsg.getDe41());
		stat.setString( 7, cwdMsg.getDe42());
		stat.setString( 8, cwdMsg.getDe43());
		stat.setString( 9, cwdMsg.getDe52());
		stat.setString(10, cwdMsg.getMti());
		stat.execute();
	}

	@Override
	public String getDe02() throws SQLException {
		String sql = "SELECT DE02 FROM CWDMSG";
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
		String sql = "SELECT DE03 FROM CWDMSG";
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
		String sql = "SELECT DE04 FROM CWDMSG";
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
		String sql = "SELECT DE18 FROM CWDMSG";
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
		String sql = "SELECT DE19 FROM CWDMSG";
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
		String sql = "SELECT DE22 FROM CWDMSG";
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
		String sql = "SELECT DE25 FROM CWDMSG";
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
		String sql = "SELECT DE28 FROM CWDMSG";
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
		String sql = "SELECT DE32 FROM CWDMSG";
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
		String sql = "SELECT DE41 FROM CWDMSG";
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
		String sql = "SELECT DE42 FROM CWDMSG";
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
		String sql = "SELECT DE43 FROM CWDMSG";
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
		String sql = "SELECT DE49 FROM CWDMSG";
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
	public String getDe52() throws SQLException {
		String sql = "SELECT DE52 FROM BALMSG";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		String de52 = null;
		while(rs.next()){
			de52 = rs.getString("DE52");
		}
		return de52;
	}

	@Override
	public void save(CwdMsg cwdMsg) throws SQLException {
		String sql = "INSERT INTO CWDMSG (DE02, DE03, DE04, DE28, DE32, DE41, DE42, DE43, DE52) "
				+" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, cwdMsg.getDe02());
		stat.setString(2, cwdMsg.getDe03());
		stat.setString(3, cwdMsg.getDe04());
		stat.setString(4, cwdMsg.getDe28());
		stat.setString(5, cwdMsg.getDe32());
		stat.setString(6, cwdMsg.getDe41());
		stat.setString(7, cwdMsg.getDe42());
		stat.setString(8, cwdMsg.getDe43());
		stat.setString(9, cwdMsg.getDe52());
		stat.execute();
	}

	@Override
	public int check() throws SQLException {
		String sql = "SELECT COUNT(*) AS NUM FROM CWDMSG";
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
