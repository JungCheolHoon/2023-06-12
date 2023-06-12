package com.mz.b2b.webchatclone.model.response_evaluation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QResponseEvaluation is a Querydsl query type for ResponseEvaluation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResponseEvaluation extends EntityPathBase<ResponseEvaluation> {

    private static final long serialVersionUID = 343486883L;

    public static final QResponseEvaluation responseEvaluation = new QResponseEvaluation("responseEvaluation");

    public final StringPath bot_message = createString("bot_message");

    public final StringPath collection_name = createString("collection_name");

    public final StringPath original_message = createString("original_message");

    public final StringPath uuid = createString("uuid");

    public final NumberPath<Integer> value = createNumber("value", Integer.class);

    public QResponseEvaluation(String variable) {
        super(ResponseEvaluation.class, forVariable(variable));
    }

    public QResponseEvaluation(Path<? extends ResponseEvaluation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResponseEvaluation(PathMetadata metadata) {
        super(ResponseEvaluation.class, metadata);
    }

}

