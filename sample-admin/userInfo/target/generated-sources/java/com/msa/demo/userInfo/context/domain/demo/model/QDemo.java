package com.msa.demo.userInfo.context.domain.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDemo is a Querydsl query type for Demo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDemo extends EntityPathBase<Demo> {

    private static final long serialVersionUID = -731872942L;

    public static final QDemo demo = new QDemo("demo");

    public final StringPath demoName = createString("demoName");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QDemo(String variable) {
        super(Demo.class, forVariable(variable));
    }

    public QDemo(Path<? extends Demo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDemo(PathMetadata metadata) {
        super(Demo.class, metadata);
    }

}

