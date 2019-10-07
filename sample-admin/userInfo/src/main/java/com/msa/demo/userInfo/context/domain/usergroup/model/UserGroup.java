package com.msa.demo.userInfo.context.domain.usergroup.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private Long companyId;
	private String companyName;
	private Boolean userGroupUsage;
	
	
	@ElementCollection
	private List<Long> userIdList;
	
	public UserGroup() {
		
	}
	public UserGroup(String name, Long companyId, Boolean userGroupUsage) {
		this.name= name;
		this.companyId = companyId;
		this.userGroupUsage = userGroupUsage;
	}
}
