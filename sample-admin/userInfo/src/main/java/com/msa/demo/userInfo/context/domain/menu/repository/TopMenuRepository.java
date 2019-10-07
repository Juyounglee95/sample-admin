package com.msa.demo.userInfo.context.domain.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.msa.demo.userInfo.context.domain.menu.model.TopMenu;

@RepositoryRestResource
public interface TopMenuRepository extends QuerydslPredicateExecutor<TopMenu>, JpaRepository<TopMenu, Long>{

}
