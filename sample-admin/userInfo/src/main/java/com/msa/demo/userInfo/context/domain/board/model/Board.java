package com.msa.demo.userInfo.context.domain.board.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long companyId;
	private String name;
	private Boolean boardUsage;
	
	public Board() {
		
	}
	public Board(String name,Long companyId, Boolean boardUsage) {
		this.name= name;
		this.companyId = companyId;
		this.boardUsage = boardUsage;
		
	}
}
