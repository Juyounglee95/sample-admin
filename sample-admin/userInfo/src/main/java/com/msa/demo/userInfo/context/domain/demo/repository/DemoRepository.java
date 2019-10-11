package com.msa.demo.userInfo.context.domain.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.msa.demo.userInfo.context.domain.demo.model.Demo;

public interface DemoRepository extends QuerydslPredicateExecutor<Demo>, JpaRepository<Demo, Long>{

}
