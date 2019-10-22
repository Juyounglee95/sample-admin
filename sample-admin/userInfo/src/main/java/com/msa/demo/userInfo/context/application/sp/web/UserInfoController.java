package com.msa.demo.userInfo.context.application.sp.web;


import java.util.List;

import javax.annotation.Nullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msa.demo.userInfo.context.domain.UserInfoService;
import com.msa.demo.userInfo.context.domain.board.model.Board;
import com.msa.demo.userInfo.context.domain.board.model.Post;
import com.msa.demo.userInfo.context.domain.board.repository.PostRepository;
import com.msa.demo.userInfo.context.domain.company.model.CompanyType;
import com.msa.demo.userInfo.context.domain.company.repository.CompanyRepository;
import com.msa.demo.userInfo.context.domain.menu.repository.SubMenuRepository;
import com.msa.demo.userInfo.context.domain.menu.repository.TopMenuRepository;
import com.msa.demo.userInfo.context.domain.permission.model.Permission;
import com.msa.demo.userInfo.context.domain.permission.repository.PermissionRepository;
import com.msa.demo.userInfo.context.domain.user.model.User;
import com.msa.demo.userInfo.context.domain.user.repository.UserRepository;
import com.msa.demo.userInfo.context.domain.usergroup.repository.UserGroupRepository;
import com.msa.demo.userInfo.context.exception.RecordNotFoundException;
@Controller
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	TopMenuRepository topMenuRepository;
	@Autowired
	SubMenuRepository subMenuRepository;
	@Autowired
	UserGroupRepository userGroupRepository;
	@Autowired
	PermissionRepository permissionRepository;
	
	@GetMapping("")
	public String index() {
		return "index";
	}
//	@GetMapping({"/post"})
//	public String post(@RequestParam(value="id", defaultValue = "0")Long id, Model model)
//	{
//		model.addAttribute("post", postRepository.findById(id));
//		
//		return "/post/form";
//		
//	}
	@GetMapping("/post")
    public String board(@RequestParam(value = "id", defaultValue = "0") Long id, Model model) {
        model.addAttribute("post", postRepository.findById(id).orElse(new Post()));
        return "/post/form";
    }
//	@GetMapping("/post")
//	public String post(@PageableDefault Pageable pageable, Model model) {
//		
//		model.addAttribute("postList", userInfoService.findPostList(pageable));
//		
//		return "/post/list";
//	}
	
	@GetMapping("/post/list")
	public String getPostPage(@PageableDefault Pageable pageable, Model model) {
		
		model.addAttribute("postList", userInfoService.findPostList(pageable));
		
		return "/post/list";
	}
//	@GetMapping("/post/list/{companyType}")
//	public String postList(@PageableDefault Pageable pageable, Model model, @PathVariable CompanyType companyType) {
//		model.addAttribute("companyList", companyRepository.findByCompanyType(companyType));
//		model.addAttribute("postList", userInfoService.findPostList(pageable));
//		
//		return "/post/list";
//	}
//	@GetMapping("/post/list/company/{companyId}")
//	public String postList(@PageableDefault Pageable pageable, Model model, @PathVariable Long companyId) {
//		//model.addAttribute("companyList", companyRepository.findById(companyId));
//		model.addAttribute("postList", userInfoService.findByCompanyId(companyId));
//		
//		return "/post/list";
//	}
	@GetMapping("/user")
	public String userList(@PageableDefault Pageable pageable, Model model) {
		model.addAttribute("userGroupList", userInfoService.findUserGroupList(pageable));
		
		return "/usergroup/list";
	}
	@GetMapping("/menu")
	public String getMenuList(@PageableDefault Pageable pageable, Model model) {
		model.addAttribute("topMenuList", topMenuRepository.findAll(pageable));
		model.addAttribute("subMenuList", subMenuRepository.findAll(pageable));		
		
		return "/menu/list";
	}
	@GetMapping("/permission")
	public String getPerList(@RequestParam(value = "group", defaultValue = "0") Long group,@PageableDefault Pageable pageable, Model model) {
		
		
		model.addAttribute("userGroupList", userInfoService.findUserGroupList(pageable));
		if(group!=0) {
		model.addAttribute("permissionList", permissionRepository.findAll(pageable));		
		model.addAttribute("groupname", userGroupRepository.findById(group).get().getName() );
		}
		return "/permission/list";
	}
	@PostMapping("/permission/edit")
	public String save(
			@RequestParam("groupId") String groupId,
			@RequestParam("isChecked")@Nullable List<String> perList) {
		Long group = Long.parseLong(groupId);
		
		if(perList != null){

			userInfoService.addPermission(group, perList);
	    }else {

	    	userInfoService.deletePermission(group);
	    }
	    return "redirect:/permission";
	}
	

	
}
