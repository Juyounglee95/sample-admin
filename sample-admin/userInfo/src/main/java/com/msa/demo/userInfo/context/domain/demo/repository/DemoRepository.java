package com.msa.demo.userInfo.context.domain.demo.repository;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RestResource;

import com.msa.demo.userInfo.context.domain.demo.model.Demo;
import com.msa.demo.userInfo.context.exception.DemoNotFoundException;

public interface DemoRepository extends QuerydslPredicateExecutor<Demo>, JpaRepository<Demo, Long>{
}
