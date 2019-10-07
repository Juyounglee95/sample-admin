package com.msa.demo.userInfo.context.domain.user.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String password;
	private String name;
	private String email;
	private String phoneNum;
	private Long companyId;
	private String companyName;
	private Boolean userUsage;
	
	
	public User() {
			
		}
	public User(String name, String password, String email, String phoneNum, Long companyId, Boolean userUsage) {
			this.name= name;
			this.password= password;
			this.email= email;
			this.phoneNum = phoneNum;
			this.companyId= companyId;
			this.userUsage = userUsage;
		}
}
