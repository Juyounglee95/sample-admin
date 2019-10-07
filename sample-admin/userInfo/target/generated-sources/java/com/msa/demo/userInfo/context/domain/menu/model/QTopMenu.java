package com.msa.demo.userInfo.context.domain.menu.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTopMenu is a Querydsl query type for TopMenu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTopMenu extends EntityPathBase<TopMenu> {

    private static final long serialVersionUID = -808388351L;

    public static final QTopMenu topMenu = new QTopMenu("topMenu");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath menuUsage = createBoolean("menuUsage");

    public final StringPath name = createString("name");

    public QTopMenu(String variable) {
        super(TopMenu.class, forVariable(variable));
    }

    public QTopMenu(Path<? extends TopMenu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTopMenu(PathMetadata metadata) {
        super(TopMenu.class, metadata);
    }

}

