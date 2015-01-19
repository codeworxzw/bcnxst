package com.bcnx.data.dao;

import java.sql.SQLException;
import java.util.List;

import com.bcnx.data.entity.Member;

public interface MemberDao {
	public void save(Member member) throws SQLException;
	public Member getMember() throws SQLException;
	public void update(Member member) throws SQLException;
	public Member getMember(Member member) throws SQLException;
	public List<Member> getMembers() throws SQLException;
	public List<Member> getMembersLike(String keyWord) throws SQLException;
	public Member getMemberFromIIN(String iin) throws SQLException;
	public boolean checkMember(String memId) throws SQLException;
	public void delete(Member member) throws SQLException;
}
