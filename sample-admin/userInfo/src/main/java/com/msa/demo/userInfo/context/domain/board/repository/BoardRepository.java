package com.msa.demo.userInfo.context.domain.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.msa.demo.userInfo.context.domain.board.model.Board;

@RepositoryRestResource
public interface BoardRepository extends QuerydslPredicateExecutor<Board>, JpaRepository<Board, Long> {
	List<Board> findByCompanyId(Long companyId);
}
