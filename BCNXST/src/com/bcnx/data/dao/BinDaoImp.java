package com.bcnx.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcnx.application.datasource.DataSource;
import com.bcnx.data.entity.Bin;
@Repository("binDao")
public class BinDaoImp implements BinDao {

	@Override
	public void save(Bin bin) throws SQLException {
		String sql = "INSERT INTO BININFO (BIN, BINTYPE, IIN) VALUES (?, ?, ?)";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, bin.getBin());
		stat.setString(2, bin.getType());
		stat.setString(3, bin.getIin());
		stat.execute();
	}

	@Override
	public Bin getBin() throws SQLException {
		String sql = "SELECT ID, BIN, BINTYPE, IIN FROM BININFO";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		Bin bin = new Bin();
		while(rs.next()){
			int id = rs.getInt("ID");
			String bi = rs.getString("BIN");
			String type = rs.getString("BINTYPE");
			String iin = rs.getString("IIN");
			bin.setId(id);
			bin.setBin(bi);
			bin.setType(type);
			bin.setIin(iin);
		}
		return bin;
	}

	@Override
	public void update(Bin bin) throws SQLException {
		String sql = "UPDATE BININFO SET BIN = ?, BINTYPE = ?, IIN = ? WHERE ID = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, bin.getBin());
		stat.setString(2, bin.getType());
		stat.setString(3, bin.getIin());
		stat.setInt(4, bin.getId());
		stat.execute();
	}

	@Override
	public Bin getBin(Bin bin) throws SQLException {
		String sql = "SELECT ID, BIN, BINTYPE, IIN FROM BININFO WHERE ID = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, bin.getId());
		ResultSet rs = stat.executeQuery();
		Bin b = new Bin();
		while(rs.next()){
			int id = rs.getInt("ID");
			String bi = rs.getString("BIN");
			String type = rs.getString("BINTYPE");
			String iin = rs.getString("IIN");
			b.setBin(bi);
			b.setType(type);
			b.setIin(iin);
			b.setId(id);
		}
		return b;
	}

	@Override
	public List<Bin> getBins() throws SQLException {
		String sql = "SELECT ID, BIN, BINTYPE, IIN FROM BININFO";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		List<Bin> bins = new ArrayList<Bin>();
		while(rs.next()){
			int id = rs.getInt("ID");
			String bi = rs.getString("BIN");
			String type = rs.getString("BINTYPE");
			String iin = rs.getString("IIN");
			Bin b = new Bin();
			b.setBin(bi);
			b.setType(type);
			b.setIin(iin);
			b.setId(id);
			bins.add(b);
		}
		return bins;
	}

	@Override
	public Bin getBin(String bin) throws SQLException {
		String sql = "SELECT ID, BIN, BINTYPE, IIN FROM BININFO WHERE BIN = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1,bin);
		ResultSet rs = stat.executeQuery();
		Bin b = null;
		while(rs.next()){
			int id = rs.getInt("ID");
			String bi = rs.getString("BIN");
			String type = rs.getString("BINTYPE");
			String iin = rs.getString("IIN");
			b = new Bin();
			b.setBin(bi);
			b.setType(type);
			b.setIin(iin);
			b.setId(id);
		}
		return b;
	}

	@Override
	public String[] getBinList() throws SQLException {
		String sql = "SELECT BIN FROM BININFO";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		List<String> list = new ArrayList<>();
		while(rs.next()){
			String bi = rs.getString("BIN");
			list.add(bi);
		}
		String[] b = new String[list.size()];
		b = list.toArray(b);
		return b;
	}

	@Override
	public List<Bin> getBinLike(String trim) throws SQLException {
		String sql = "SELECT ID, BIN, BINTYPE, IIN FROM BININFO WHERE BIN LIKE ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, trim);
		ResultSet rs = stat.executeQuery();
		List<Bin> bins = new ArrayList<Bin>();
		while(rs.next()){
			int id = rs.getInt("ID");
			String bi = rs.getString("BIN");
			String type = rs.getString("BINTYPE");
			String iin = rs.getString("IIN");
			Bin b = new Bin();
			b.setBin(bi);
			b.setType(type);
			b.setIin(iin);
			b.setId(id);
			bins.add(b);
		}
		return bins;
	}

	@Override
	public void delete(Bin bin) throws SQLException {
		String sql = "DELETE FROM BININFO WHERE ID=?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, bin.getId());
		stat.execute();
	}

}
