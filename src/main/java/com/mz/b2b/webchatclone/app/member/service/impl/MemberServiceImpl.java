package com.mz.b2b.webchatclone.app.member.service.impl;

import com.mz.b2b.webchatclone.app.member.repository.MemberRepository;
import com.mz.b2b.webchatclone.app.member.service.MemberService;
import com.mz.b2b.webchatclone.model.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Member getMember(Member users) {

        // null 인지 아닌지 if문을 쓰지않고 optional 클래스를 사용하여 null인지 확인가능, null이더라도 일단 메소드를 제공해줌
        Optional<Member> findUser = userRepo.findById(users.getMemberId());
        if (findUser.isPresent()) // findMember 객체가 값을 가지고 있다면 true, findMember != null
            return findUser.get();
        else
            return null;
    }

    @Override
    @Transactional
    public void insertMember(Member users) {
        users.setMemberPw(encoder.encode(users.getMemberPw()));
        users.setJoindate(new Date());
        userRepo.save(users);
    }


    @Override
    public void deleteMember(Member member) {
        userRepo.deleteById(member.getMemberId());
    }

    @Override
    public List<Member> listMember() {
        List<Member> userList = (List<Member>) userRepo.findAll();
        return userList;
    }

}
