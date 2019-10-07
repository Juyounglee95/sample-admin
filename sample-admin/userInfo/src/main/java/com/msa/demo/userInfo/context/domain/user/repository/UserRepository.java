package com.msa.demo.userInfo.context.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.msa.demo.userInfo.context.domain.user.model.User;

@RepositoryRestResource
public interface UserRepository extends QuerydslPredicateExecutor<User>, JpaRepository<User, Long> {
	
}
