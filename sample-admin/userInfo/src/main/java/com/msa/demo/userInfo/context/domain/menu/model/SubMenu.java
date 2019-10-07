package com.msa.demo.userInfo.context.domain.menu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SubMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private Boolean menuUsage; 
	private Long topMenuId;
	private String topMenuName;
	public SubMenu() {
		
	}
	public SubMenu(String name, Boolean menuUsage, Long topMenuId) {
		this.name= name;
		this.menuUsage = menuUsage;
		this.topMenuId = topMenuId;
	}
}
