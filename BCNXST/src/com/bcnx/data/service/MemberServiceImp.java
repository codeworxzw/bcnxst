package com.bcnx.data.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcnx.data.dao.MemberDao;
import com.bcnx.data.entity.Member;
@Service("memberService")
public class MemberServiceImp implements MemberService {
	private static final Logger logger = Logger.getLogger(MemberServiceImp.class);
	@Autowired
	private MemberDao memberDao;
	public void setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	@Override
	public void save(Member mem) {
		try {
			memberDao.save(mem);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to save member", e);
		}
	}

	@Override
	public void update(Member mem) {
		try {
			memberDao.update(mem);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to update",e);
		}
	}

	@Override
	public Member getMember(int id) {
		Member member = new Member();
		member.setId(id);
		try {
			return memberDao.getMember(member);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get member", e);
			return null;
		}
	}

	@Override
	public List<Member> getMembers() {
		try {
			return memberDao.getMembers();
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get members",e);
			return null;
		}
	}
	@Override
	public List<Member> getMembersLike(String keyWord) {
		try {
			return memberDao.getMembersLike(keyWord);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get members",e);
			return null;
		}
	}
	@Override
	public Member getMemberFromIIN(String iin) {
		try {
			return memberDao.getMemberFromIIN(iin);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to get members",e);
			return null;
		}
	}
	@Override
	public boolean checkMemberId(String memId) {
		try {
			return memberDao.checkMember(memId);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to check Member", e);
			return false;
		}
	}
	@Override
	public void delete(Member member) {
		try {
			memberDao.delete(member);
		} catch (SQLException e) {
			logger.debug("Exception occured while try to delete member",e);
		}
	}

}
