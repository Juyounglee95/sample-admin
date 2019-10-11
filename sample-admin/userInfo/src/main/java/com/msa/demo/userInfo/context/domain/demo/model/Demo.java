package com.msa.demo.userInfo.context.domain.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Demo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message="demoName 필드가 null입니다.")
	private String demoName;
	private String email;
	
	public Demo() {
		
	}
	public Demo(String demoName, String email) {
		
	}
}
