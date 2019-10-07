package com.msa.demo.userInfo.context.domain.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.msa.demo.userInfo.context.domain.board.model.Post;
import com.msa.demo.userInfo.context.domain.board.model.PostType;

@RepositoryRestResource
public interface PostRepository extends PagingAndSortingRepository<Post,Long>, QuerydslPredicateExecutor<Post>, JpaRepository<Post, Long>{
	Page<Post> findByBoardId(Pageable pageable, Long BoardId);
}
