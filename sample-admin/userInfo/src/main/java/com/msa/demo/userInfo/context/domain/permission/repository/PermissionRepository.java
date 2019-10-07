package com.msa.demo.userInfo.context.domain.permission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.msa.demo.userInfo.context.domain.permission.model.Permission;

@RepositoryRestResource
public interface PermissionRepository extends QuerydslPredicateExecutor<Permission>, JpaRepository<Permission,Long>{

}
