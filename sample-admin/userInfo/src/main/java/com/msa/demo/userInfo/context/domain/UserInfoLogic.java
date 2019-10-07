package com.msa.demo.userInfo.context.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.msa.demo.userInfo.context.domain.board.model.Board;
import com.msa.demo.userInfo.context.domain.board.model.Post;
import com.msa.demo.userInfo.context.domain.board.repository.BoardRepository;
import com.msa.demo.userInfo.context.domain.board.repository.PostRepository;
import com.msa.demo.userInfo.context.domain.company.model.Company;
import com.msa.demo.userInfo.context.domain.company.model.CompanyType;
import com.msa.demo.userInfo.context.domain.company.repository.CompanyRepository;
import com.msa.demo.userInfo.context.domain.user.model.User;
import com.msa.demo.userInfo.context.domain.user.repository.UserRepository;
import com.msa.demo.userInfo.context.domain.usergroup.model.UserGroup;
import com.msa.demo.userInfo.context.domain.usergroup.repository.UserGroupRepository;

@Service
public class UserInfoLogic implements UserInfoService{
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserGroupRepository userGroupRepository;
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	@Override
	public Page<Post> findPostList(Pageable pageable) {
		pageable = PageRequest.of(pageable.getPageNumber()<=0?0:pageable.getPageNumber()-1,
				pageable.getPageSize());
		return postRepository.findAll(pageable);
	}
	@Override
	public Page<UserGroup> findUserGroupList(Pageable pageable) {
		pageable = PageRequest.of(pageable.getPageNumber()<=0?0:pageable.getPageNumber()-1,
				pageable.getPageSize());
		return userGroupRepository.findAll(pageable);
	}
	
	

}
