package com.msa.demo.userInfo.context.domain.company.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	@Enumerated(EnumType.STRING)
	private CompanyType companyType;
	public Company() {
		
	}
	public Company(String name, CompanyType companyType) {
		this.name= name;
		this.companyType= companyType;
	}
}
