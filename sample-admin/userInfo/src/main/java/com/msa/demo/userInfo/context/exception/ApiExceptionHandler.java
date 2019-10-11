package com.msa.demo.userInfo.context.exception;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(DemoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ApiErrorDetail> handleDemoNotFoundException(DemoNotFoundException dnfe){
		ApiErrorDetail errorDetail = new ApiErrorDetail();
		errorDetail.setTimeStamp(LocalDateTime.now());
		errorDetail.setCode(1002);
		errorDetail.setMessage(dnfe.getMessage());
		return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	}
}
