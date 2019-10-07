package com.msa.demo.userInfo;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.msa.demo.userInfo.context.domain.board.model.Board;
import com.msa.demo.userInfo.context.domain.board.model.Post;
import com.msa.demo.userInfo.context.domain.board.model.PostType;
import com.msa.demo.userInfo.context.domain.board.repository.BoardRepository;
import com.msa.demo.userInfo.context.domain.board.repository.PostRepository;
import com.msa.demo.userInfo.context.domain.company.model.Company;
import com.msa.demo.userInfo.context.domain.company.model.CompanyType;
import com.msa.demo.userInfo.context.domain.company.repository.CompanyRepository;
import com.msa.demo.userInfo.context.domain.menu.model.SubMenu;
import com.msa.demo.userInfo.context.domain.menu.model.TopMenu;
import com.msa.demo.userInfo.context.domain.menu.repository.SubMenuRepository;
import com.msa.demo.userInfo.context.domain.menu.repository.TopMenuRepository;
import com.msa.demo.userInfo.context.domain.permission.model.Permission;
import com.msa.demo.userInfo.context.domain.permission.model.PermissionTargetType;
import com.msa.demo.userInfo.context.domain.permission.model.PermissionType;
import com.msa.demo.userInfo.context.domain.permission.repository.PermissionRepository;
import com.msa.demo.userInfo.context.domain.user.model.User;
import com.msa.demo.userInfo.context.domain.user.repository.UserRepository;
import com.msa.demo.userInfo.context.domain.usergroup.model.UserGroup;
import com.msa.demo.userInfo.context.domain.usergroup.repository.UserGroupRepository;


@SpringBootApplication
public class UserInfoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserInfoApplication.class, args);
	}
	@Bean
	public CommandLineRunner execSampleCode(CompanyRepository companyRepository, UserRepository userRepository, UserGroupRepository userGroupRepository,
			TopMenuRepository topMenuRepository, SubMenuRepository subMenuRepository
			, PermissionRepository permissionRepository, PostRepository postRepository, BoardRepository boardRepository
			
			) {	
		return (args) -> {
			insertMember(companyRepository);
			insertUser(userRepository);
			insertUserGroup(userGroupRepository);
			insertTopMenu(topMenuRepository);
			insertSubMenu(subMenuRepository);
			createPermission(permissionRepository);
			insertBoard(boardRepository);

			IntStream.rangeClosed(1, 200).forEach(idx->
				insertPost(postRepository, idx)
				
					);
			
			
		};
	}
	
	private void insertBoard(BoardRepository boardRepository) {
		Board board1 = new Board("SKN 자유게시판", (long)1, true);
		Board board2 = new Board("SKN Q&A", (long)1, false);
		Board board3 = new Board("SKN 공지사항", (long)1, true);
		boardRepository.save(board1);
		boardRepository.save(board2);
		boardRepository.save(board3);
		Board board4 = new Board("SKT 자유게시판", (long)2, true);
		Board board5 = new Board("SKT Q&A", (long)2, true);
		Board board6 = new Board("SKT 공지사항", (long)2, false);
		boardRepository.save(board4);
		boardRepository.save(board5);
		boardRepository.save(board6);
		Board board7 = new Board("SK Hynix 자유게시판", (long)3, false);
		Board board8 = new Board("SK Hynix Q&A", (long)3, false);
		Board board9 = new Board("SK Hynix 공지사항", (long)3, true);
		boardRepository.save(board7);
		boardRepository.save(board8);
		boardRepository.save(board9);
		
	}
	private void insertPost(PostRepository postRepository, int idx) {
		Post post = new Post();
		post.setBoardId((long)1);
		post.setContent("Contents");
		post.setPostType(PostType.NORMAL);
		post.setTitle("게시글 "+idx);
		post.setWriterId((long)1);
		postRepository.save(post);
	}
	private void createPermission(PermissionRepository permissionRepository) {
		Permission per = new Permission(PermissionType.ADMIN, PermissionTargetType.MENU);
		per.setMenuId((long)1);
		per.setUserGroupId((long)1);
		permissionRepository.save(per);
		Permission per2 = new Permission(PermissionType.VIEW, PermissionTargetType.MENU);
		Permission per3 = new Permission(PermissionType.EDIT, PermissionTargetType.MENU);
		permissionRepository.save(per2);
		permissionRepository.save(per3);
		
	}
	private void insertSubMenu(SubMenuRepository subMenuRepository) {
	
		SubMenu sub3 = new SubMenu("Board Management", true, (long)1);
		subMenuRepository.save(sub3);
		SubMenu sub4 = new SubMenu("User Permission", true, (long)2);
		subMenuRepository.save(sub4);
		SubMenu sub5 = new SubMenu("User Dashboard", true, (long)2);
		subMenuRepository.save(sub5);
		
	}
	private void insertTopMenu(TopMenuRepository topMenuRepository) {
		TopMenu top1 = new TopMenu("Board", true);
		topMenuRepository.save(top1);
		TopMenu top2 = new TopMenu("UserManagement", true);
		topMenuRepository.save(top2);
		
	}
	private void insertUserGroup(UserGroupRepository userGroupRepository) {
		
		UserGroup group1 = new UserGroup("admin",(long) 1, true);
		userGroupRepository.save(group1);
		
		UserGroup group2 = new UserGroup("common",(long)2, true);
		userGroupRepository.save(group2);
		
		UserGroup group3 = new UserGroup("control", (long)1, true);
		userGroupRepository.save(group3);
		
	}
	private void insertUser(UserRepository userRepository) {
		User user1 = new User("juyoung","pw", "jy@sk.com","01065430518", (long)1, true);
		userRepository.save(user1);
		
		User user2 = new User("sujin", "pw","sj@sk.com","01045678956",(long)2, true);
		userRepository.save(user2);
		
		User user3 = new User("hyemi","pw", "hm@sk.com","01078569235",(long)3, true);
		userRepository.save(user3);
		
	}
	private void insertMember(CompanyRepository companyRepository) {
		Company member1 = new Company("SKN", CompanyType.PARTNER);
		companyRepository.save(member1);
		Company member2 = new Company("SK Telecom", CompanyType.PARTNER);
		companyRepository.save(member2);
		Company member3 = new Company("SK Hynix", CompanyType.MEMBER);
		companyRepository.save(member3);
		
	}
}
