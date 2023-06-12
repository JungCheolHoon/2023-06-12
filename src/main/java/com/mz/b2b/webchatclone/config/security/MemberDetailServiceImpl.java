package com.mz.b2b.webchatclone.config.security;

import com.mz.b2b.webchatclone.app.member.repository.MemberRepository;
import com.mz.b2b.webchatclone.model.auth.SecurityMember;
import com.mz.b2b.webchatclone.model.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberDetailServiceImpl implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> memberOptional = memberRepository.findById(username);

        Member members = memberOptional.orElseThrow(() -> new UsernameNotFoundException(username + " 사용자 없음"));
        return new SecurityMember(members);
    }


}
