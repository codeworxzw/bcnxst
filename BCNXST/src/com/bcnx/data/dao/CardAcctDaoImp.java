package com.bcnx.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bcnx.application.datasource.DataSource;
import com.bcnx.data.entity.CardAcct;

public class CardAcctDaoImp implements CardAcctDao {

	@Override
	public List<CardAcct> list() throws SQLException {
		String sql = "SELECT ID, CARD, TYPE, CURR, FLAG, BAL, EXPDATE, CAV, BIN FROM CARDACCT";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		List<CardAcct> list = new ArrayList<CardAcct>();
		while(rs.next()){
			int id = rs.getInt("ID");
			String card = rs.getString("CARD");
			String type = rs.getString("TYPE");
			String curr = rs.getString("CURR");
			String flag = rs.getString("FLAG");
			double bal  = rs.getDouble("BAL");
			String exp  = rs.getString("EXPDATE");
			String cav  = rs.getString("CAV");
			String bin  = rs.getString("BIN");
			
			CardAcct ca = new CardAcct();
			ca.setId(id);
			ca.setCard(card);
			ca.setType(type);
			ca.setCurr(curr);
			ca.setFlag(flag);
			ca.setBal(bal);
			ca.setExp(exp);
			ca.setCav(cav);
			ca.setBin(bin);
			list.add(ca);
		}
		return list;
	}

	@Override
	public CardAcct getCardAcct(String card) throws SQLException {
		String sql = "SELECT ID, CARD, EXPDATE, CAV, TYPE, BAL, CURR, FLAG, BIN "
				+ "FROM CARDACCT WHERE CARD = ? ";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, card);
		ResultSet rs = stat.executeQuery();
		CardAcct cardAcct = null;
		while(rs.next()){
			int id 		= rs.getInt("ID");
			String cd 	= rs.getString("CARD");
			String exp 	= rs.getString("EXPDATE");
			String cav 	= rs.getString("CAV");
			String type = rs.getString("TYPE");
			double bal 	= rs.getDouble("BAL");
			String curr = rs.getString("CURR");
			String flag = rs.getString("FLAG");
			String bin 	= rs.getString("BIN");
			
			cardAcct = new CardAcct();
			cardAcct.setId(id);
			cardAcct.setCard(cd);
			cardAcct.setExp(exp);
			cardAcct.setCav(cav);
			cardAcct.setType(type);
			cardAcct.setBal(bal);
			cardAcct.setCurr(curr);
			cardAcct.setFlag(flag);
			cardAcct.setBin(bin);
		}
		return cardAcct;
	}

	@Override
	public void save(CardAcct cardAcct) throws SQLException {
		String sql = "INSERT INTO CARDACCT (CARD, EXPDATE, CAV, TYPE, BAL, FLAG, BIN) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, cardAcct.getCard());
		stat.setString(2, cardAcct.getExp());
		stat.setString(3, cardAcct.getCav());
		stat.setString(4, cardAcct.getType());
		stat.setDouble(5, cardAcct.getBal());
		stat.setString(6, cardAcct.getFlag());
		stat.setString(7, cardAcct.getBin());
		stat.execute();
	}

	@Override
	public void update(CardAcct cardAcct) throws SQLException{
		String sql = "UPDATE CARDACCT SET EXPDATE = ?, CAV = ?, TYPE = ?, BAL = ?, CURR= ?, FLAG = ?, BIN = ? WHERE CARD = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, cardAcct.getExp());
		stat.setString(2, cardAcct.getCav());
		stat.setString(3, cardAcct.getType());
		stat.setDouble(4, cardAcct.getBal());
		stat.setString(5, cardAcct.getCurr());
		stat.setString(6, cardAcct.getFlag());
		stat.setString(7, cardAcct.getBin());
		stat.setString(8, cardAcct.getCard());
		stat.execute();
	}

	@Override
	public CardAcct getCardAcct(CardAcct cardAcct) throws SQLException {
		String sql = "SELECT ID, CARD, EXPDATE, CAV, TYPE, BAL, CURR, FLAG, BIN FROM CARDACCT WHERE CARD = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, cardAcct.getCard());
		ResultSet rs = stat.executeQuery();
		CardAcct cardAc = null;
		while(rs.next()){
			int id = rs.getInt("ID");
			String card = rs.getString("CARD");
			String exp = rs.getString("EXPDATE");
			String cav = rs.getString("CAV");
			String type = rs.getString("TYPE");
			double bal = rs.getDouble("BAL");
			String curr = rs.getString("CURR");
			String flag = rs.getString("FLAG");
			String bin = rs.getString("BIN");
			
			cardAc = new CardAcct();
			cardAc.setId(id);
			cardAc.setCard(card);
			cardAc.setExp(exp);
			cardAc.setType(type);
			cardAc.setCav(cav);
			cardAc.setBal(bal);
			cardAc.setCurr(curr);
			cardAc.setFlag(flag);
			cardAc.setBin(bin);
		}
		return cardAc;
	}

	@Override
	public String getExpDate(String card) throws SQLException {
		String sql = "SELECT EXPDATE FROM CARDACCT WHERE CARD = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, card);
		ResultSet rs = stat.executeQuery();
		String exp = null;
		while(rs.next()){
			exp = rs.getString("EXPDATE");
		}
		return exp;
	}

	@Override
	public String getCav(String card) throws SQLException {
		String sql = "SELECT CAV FROM CARDACCT WHERE CARD = ? ";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, card);
		ResultSet rs = stat.executeQuery();
		String cav = null;
		while(rs.next()){
			cav = rs.getString("CAV");
		}
		return cav;
	}

	@Override
	public String getType(String card) throws SQLException {
		String sql = "SELECT TYPE FROM CARDACCT WHERE CARD = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, card);
		ResultSet rs = stat.executeQuery();
		String type = null;
		while(rs.next()){
			type = rs.getString("TYPE");
		}
		return type;
	}

	@Override
	public String getBalance(String card) throws SQLException {
		String sql = "SELECT BAL FROM CARDACCT WHERE CARD = ? ";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, card);
		ResultSet rs = stat.executeQuery();
		String bal = null;
		while(rs.next()){
			bal = String.format("%012d", (int)rs.getDouble("BAL")*100);
		}
		return bal;
	}

	@Override
	public String getCurr(String card) throws SQLException {
		String sql = "SELECT CURR FROM CARDACCT WHERE CARD = ? ";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, card);
		ResultSet rs = stat.executeQuery();
		String curr = null;
		while(rs.next()){
			curr = rs.getString("CURR");
		}
		return curr;
	}

	@Override
	public String getFlag(String card) throws SQLException {
		String sql = "SELECT FLAG FROM CARDACCT WHERE CARD = ? ";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, card);
		ResultSet rs = stat.executeQuery();
		String flag = null;
		while(rs.next()){
			flag = rs.getString("FLAG");
		}
		return flag;
	}

	@Override
	public List<CardAcct> getCardLike(String card) throws SQLException {
		String sql = "SELECT CARD, EXPDATE, CAV, AMTTYPE, BALANCE, FLAG, BIN FROM CARDACCT WHERE CARD LIKE ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, card);
		ResultSet rs = stat.executeQuery();
		List<CardAcct> list = new ArrayList<CardAcct>();
		while(rs.next()){
			String ca = rs.getString("CARD");
			String exp = rs.getString("EXPDATE");
			String cav = rs.getString("CAV");
			String type = rs.getString("AMTTYPE");
			double bal = rs.getDouble("BALANCE");
			String flag = rs.getString("FLAG");
			String bin = rs.getString("BIN");
			CardAcct cardAc = new CardAcct();
			cardAc.setCard(ca);
			cardAc.setExp(exp);
			cardAc.setType(type);
			cardAc.setCav(cav);
			cardAc.setBal(bal);
			cardAc.setFlag(flag);
			cardAc.setBin(bin);
			list.add(cardAc);
		}
		return list;
	}

	@Override
	public void delete(CardAcct c) throws SQLException {
		String sql = "DELETE FROM CARDACCT WHERE CARD = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1,c.getCard());
		stat.execute();
	}
	
}
