package com.msa.demo.userInfo.context.domain.menu.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubMenu is a Querydsl query type for SubMenu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSubMenu extends EntityPathBase<SubMenu> {

    private static final long serialVersionUID = -1537046420L;

    public static final QSubMenu subMenu = new QSubMenu("subMenu");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath menuUsage = createBoolean("menuUsage");

    public final StringPath name = createString("name");

    public final NumberPath<Long> topMenuId = createNumber("topMenuId", Long.class);

    public final StringPath topMenuName = createString("topMenuName");

    public QSubMenu(String variable) {
        super(SubMenu.class, forVariable(variable));
    }

    public QSubMenu(Path<? extends SubMenu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubMenu(PathMetadata metadata) {
        super(SubMenu.class, metadata);
    }

}

