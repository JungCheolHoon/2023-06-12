package com.mz.b2b.webchatclone.app.member.service;

import com.mz.b2b.webchatclone.model.member.Member;

import java.util.List;

public interface MemberService {

    Member getMember(Member member);

    public void deleteMember(Member member);

    public void insertMember(Member member);

    public List<Member> listMember();


}
