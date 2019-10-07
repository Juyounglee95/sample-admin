package com.msa.demo.userInfo.context.domain.usergroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.msa.demo.userInfo.context.domain.usergroup.model.UserGroup;

@RepositoryRestResource
public interface UserGroupRepository extends QuerydslPredicateExecutor<UserGroup>, JpaRepository<UserGroup, Long>{

}
