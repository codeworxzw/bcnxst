package com.bcnx.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcnx.application.datasource.DataSource;
import com.bcnx.data.entity.Member;
@Repository("memberDao")
public class MemberDaoImp implements MemberDao {
	
	@Override
	public void save(Member member) throws SQLException {
		String sql = "INSERT INTO MEMBERINFO (IIN, MEMID, NAME, LOCATION) VALUES (?, ?, ?, ?)";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, member.getIin());
		stat.setString(2, member.getMemId());
		stat.setString(3, member.getName());
		stat.setString(4, member.getLocation());
		stat.execute();
	}

	@Override
	public Member getMember() throws SQLException {
		String sql="SELECT ID, MEMID, NAME, LOCATION, IIN FROM MEMBERINFO";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		Member mem = new Member();
		while(rs.next()){
			int id = rs.getInt("ID");
			String memId = rs.getString("MEMID");
			String name = rs.getString("NAME");
			String location = rs.getString("LOCATION");
			String iin = rs.getString("IIN");
			mem.setId(id);
			mem.setMemId(memId);
			mem.setName(name);
			mem.setLocation(location);
			mem.setIin(iin);
		}
		return mem;
	}

	@Override
	public void update(Member member) throws SQLException {
		String sql = "UPDATE MEMBERINFO SET MEMID = ?, NAME= ?, LOCATION = ?, IIN = ? WHERE ID = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, member.getMemId());
		stat.setString(2, member.getName());
		stat.setString(3, member.getLocation());
		stat.setString(4, member.getIin());
		stat.setInt(5,member.getId());
		stat.execute();
	}

	@Override
	public Member getMember(Member member) throws SQLException {
		String sql = "SELECT ID, IIN, MEMID, NAME, LOCATION FROM MEMBERINFO WHERE ID = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, member.getId());
		ResultSet rs = stat.executeQuery();
		Member mem = new Member();
		while(rs.next()){
			int id = rs.getInt("ID");
			String memId = rs.getString("MEMID");
			String name = rs.getString("NAME");
			String location = rs.getString("LOCATION");
			String iin = rs.getString("IIN");
			mem.setId(id);
			mem.setMemId(memId);
			mem.setName(name);
			mem.setLocation(location);
			mem.setIin(iin);
		}
		return mem;
	}

	@Override
	public List<Member> getMembers() throws SQLException {
		String sql = "SELECT ID, IIN, MEMID, NAME, LOCATION FROM MEMBERINFO";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		List<Member> members = new ArrayList<Member>();
		while(rs.next()){
			int id = rs.getInt("ID");
			String memId = rs.getString("MEMID");
			String name = rs.getString("NAME");
			String location = rs.getString("LOCATION");
			String iin = rs.getString("IIN");
			Member mem = new Member();
			mem.setId(id);
			mem.setMemId(memId);
			mem.setName(name);
			mem.setLocation(location);
			mem.setIin(iin);
			members.add(mem);
		}
		return members;
	}

	@Override
	public List<Member> getMembersLike(String keyWord) throws SQLException {
		String sql = "SELECT ID, MEMID, NAME, IIN, LOCATION FROM MEMBERINFO WHERE IIN LIKE ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, keyWord);
		ResultSet rs = stat.executeQuery();
		List<Member> members = new ArrayList<Member>();
		while(rs.next()){
			int id = rs.getInt("ID");
			String memId = rs.getString("MEMID");
			String name = rs.getString("NAME");
			String location = rs.getString("LOCATION");
			String iin = rs.getString("IIN");
			Member mem = new Member();
			mem.setId(id);
			mem.setMemId(memId);
			mem.setName(name);
			mem.setLocation(location);
			mem.setIin(iin);
			members.add(mem);
		}
		return members;
	}

	@Override
	public Member getMemberFromIIN(String iin) throws SQLException {
		String sql = "SELECT ID, MEMID, NAME, IIN, LOCATION FROM MEMBERINFO WHERE IIN = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, iin);
		ResultSet rs = stat.executeQuery();
		Member mem = null;
		while(rs.next()){
			int id = rs.getInt("ID");
			String memId = rs.getString("MEMID");
			String name = rs.getString("NAME");
			String location = rs.getString("LOCATION");
			String in = rs.getString("IIN");
			mem = new Member();
			mem.setId(id);
			mem.setMemId(memId);
			mem.setName(name);
			mem.setLocation(location);
			mem.setIin(in);
		}
		return mem;
	}

	@Override
	public boolean checkMember(String memId) throws SQLException {
		String sql = "SELECT COUNT(*) AS NUM FROM MEMBERINFO WHERE IIN = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, memId);
		ResultSet rs = stat.executeQuery();
		int num = 0;
		while(rs.next()){
			num = rs.getInt("NUM");
		}
		return num>0;
	}

	@Override
	public void delete(Member member) throws SQLException {
		String sql = "DELETE FROM MEMBERINFO WHERE ID = ?";
		Connection conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, member.getId());
		stat.execute();
	}

}
