package com.mz.b2b.webchatclone.model.vectordb;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qvectordb is a Querydsl query type for vectordb
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qvectordb extends EntityPathBase<vectordb> {

    private static final long serialVersionUID = -1801887396L;

    public static final Qvectordb vectordb = new Qvectordb("vectordb");

    public final StringPath collection_name = createString("collection_name");

    public final DateTimePath<java.util.Date> create_time = createDateTime("create_time", java.util.Date.class);

    public final StringPath file_name = createString("file_name");

    public final StringPath source_file_path = createString("source_file_path");

    public final StringPath uuid = createString("uuid");

    public Qvectordb(String variable) {
        super(vectordb.class, forVariable(variable));
    }

    public Qvectordb(Path<? extends vectordb> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qvectordb(PathMetadata metadata) {
        super(vectordb.class, metadata);
    }

}

