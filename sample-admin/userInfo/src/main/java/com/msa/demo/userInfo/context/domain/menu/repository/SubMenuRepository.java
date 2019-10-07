package com.msa.demo.userInfo.context.domain.menu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.msa.demo.userInfo.context.domain.menu.model.SubMenu;

@RepositoryRestResource
public interface SubMenuRepository extends QuerydslPredicateExecutor<SubMenu>, JpaRepository<SubMenu, Long >{
	List<SubMenu> findByTopMenuId(Long topMenuId);
}
