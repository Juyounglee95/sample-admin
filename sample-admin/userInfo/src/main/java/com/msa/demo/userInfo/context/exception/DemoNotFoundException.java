package com.msa.demo.userInfo.context.exception;

public class DemoNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DemoNotFoundException() {
		
	}
	public DemoNotFoundException(String message) {
		super(message);
	}
}
