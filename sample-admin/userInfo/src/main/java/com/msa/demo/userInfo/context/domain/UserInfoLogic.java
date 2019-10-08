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
import com.msa.demo.userInfo.context.domain.permission.model.Permission;
import com.msa.demo.userInfo.context.domain.permission.repository.PermissionRepository;
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
	@Autowired
	private PermissionRepository perRepository;
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
	public void addPermission(Long groupId, List<String> perList) {
		for(String perStr : perList) {
			Long perId = Long.parseLong(perStr.substring(3));
			Permission per = perRepository.findById(perId).get();
			if(!per.getUserGroupIdList().contains(groupId)) {
				per.getUserGroupIdList().add(groupId);
				perRepository.save(per);
			}
		}
		
	}
	public void deletePermission(Long groupId) {
		// TODO Auto-generated method stub
    	List<Permission> permissions = perRepository.findAll();
    	for(Permission per: permissions) {
    		if(per.getUserGroupIdList().contains(groupId)) {
    			int idx =per.getUserGroupIdList().indexOf(groupId);
    			per.getUserGroupIdList().remove(idx);
    			perRepository.save(per);
    		}
    	}

	}
	
	

}
