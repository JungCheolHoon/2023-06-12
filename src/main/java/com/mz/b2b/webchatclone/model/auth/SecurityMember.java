package com.mz.b2b.webchatclone.model.auth;

import com.mz.b2b.webchatclone.model.member.Member;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityMember extends User {

    private static final long serialVersionUID = 121452452463L;
    private Member member;

    public SecurityMember(Member member) {
        super(member.getMemberId(), member.getMemberPw(),
                AuthorityUtils.createAuthorityList(member.getRole().toString()));
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

}
