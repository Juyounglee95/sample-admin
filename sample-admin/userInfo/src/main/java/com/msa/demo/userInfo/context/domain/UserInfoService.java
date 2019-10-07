package com.msa.demo.userInfo.context.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.msa.demo.userInfo.context.domain.board.model.Post;
import com.msa.demo.userInfo.context.domain.company.model.CompanyType;
import com.msa.demo.userInfo.context.domain.user.model.User;
import com.msa.demo.userInfo.context.domain.usergroup.model.UserGroup;

public interface UserInfoService {
	public Page<Post> findPostList(Pageable pageable);
	public Page<UserGroup> findUserGroupList(Pageable pageable);

	
}
