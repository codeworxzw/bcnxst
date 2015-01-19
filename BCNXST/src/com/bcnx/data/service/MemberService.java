package com.bcnx.data.service;

import java.util.List;

import com.bcnx.data.entity.Member;

public interface MemberService {
	public void save(Member mem);
	public void update(Member mem);
	public Member getMember(int id);
	public List<Member> getMembers();
	public List<Member> getMembersLike(String keyWord);
	public Member getMemberFromIIN(String iin);
	public boolean checkMemberId(String memId);
	public void delete(Member member);
}
