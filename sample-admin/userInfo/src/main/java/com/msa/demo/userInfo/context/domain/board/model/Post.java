package com.msa.demo.userInfo.context.domain.board.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Enumerated(EnumType.STRING)
	private PostType postType;
	
	private Long writerId;
	private String content;
	private String title;
	private Long boardId;
	public Post() 
	{
		
	}
	public Post(PostType postType,  Long writerId, String content, String title, Long boardId) 
	{
		this.postType = postType;
		
		this.writerId= writerId;
		this.content= content;
		this.title = title;
		this.boardId = boardId;
		
	}
}
