package com.msa.demo.userInfo.context.domain.permission.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long menuId;
	private Long boardId;
	private Long userGroupId;
	
	@Enumerated(EnumType.STRING)
	private PermissionTargetType permissionTargetType;
	@Enumerated(EnumType.STRING)
	private PermissionType permissionType;
	
	public Permission() {
		
	}
	
	public Permission(PermissionType permissionType, PermissionTargetType permissionTargetType) {
		this.permissionTargetType= permissionTargetType;
		this.permissionType= permissionType;
	}
}
