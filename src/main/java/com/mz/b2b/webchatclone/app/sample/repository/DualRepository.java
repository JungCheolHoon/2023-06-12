package com.mz.b2b.webchatclone.app.sample.repository;

import com.mz.b2b.webchatclone.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DualRepository extends JpaRepository<Member, Long> {

    @Query(value = "SELECT 1 FROM dual", nativeQuery = true)
    int selectOneFromDual();

}
