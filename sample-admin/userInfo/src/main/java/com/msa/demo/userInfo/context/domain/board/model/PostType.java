package com.msa.demo.userInfo.context.domain.board.model;

public enum PostType {
	REPLY("답변"),
	NORMAL("일반게시판");
	
	private String value;
	
	PostType(String value){
		this.value = value;
		
	}
	public String getValue() {
		return this.value;
	}
}
