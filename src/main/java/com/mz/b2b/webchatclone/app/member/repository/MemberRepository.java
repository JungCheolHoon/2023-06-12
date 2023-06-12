package com.mz.b2b.webchatclone.app.member.repository;

import com.mz.b2b.webchatclone.model.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, String>, QuerydslPredicateExecutor<Member> {

    @Query("select u From Member u")
    Page<Member> findAll(Pageable pageable);

    @Query("select u from Member u where email = ?1")
    List<Member> findMember(String email);


}
