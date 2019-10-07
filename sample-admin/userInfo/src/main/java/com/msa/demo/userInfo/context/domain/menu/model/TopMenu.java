package com.msa.demo.userInfo.context.domain.menu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TopMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private Boolean menuUsage;
	
	public TopMenu(){
		
	}
	
	public TopMenu(String name, Boolean menuUsage) {
		this.name = name;
		this.menuUsage = menuUsage;
	}
	
}
