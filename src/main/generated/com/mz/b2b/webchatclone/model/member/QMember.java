package com.mz.b2b.webchatclone.model.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1030986340L;

    public static final QMember member = new QMember("member1");

    public final StringPath adminYn = createString("adminYn");

    public final DateTimePath<java.util.Date> joindate = createDateTime("joindate", java.util.Date.class);

    public final StringPath memberId = createString("memberId");

    public final StringPath memberPw = createString("memberPw");

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

