package com.mz.b2b.webchatclone.model.member;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {

    private static final long serialVersionUID = -5714482763426111465L;

    @Id
    private String memberId;

    private String memberPw;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String adminYn = "no";

    @Temporal(TemporalType.TIMESTAMP)
    private Date joindate;


    public Member(String memberId, String memberPw) {
        this.memberId = memberId;
        this.memberPw = memberPw;
    }
}