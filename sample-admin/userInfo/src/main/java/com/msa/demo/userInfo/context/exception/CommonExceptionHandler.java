package com.msa.demo.userInfo.context.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(DataIntegrityViolationException.class)
	  public ResponseEntity<?> handleDataIntegrityViolation(DataIntegrityViolationException ex, HttpServletRequest req) {

	        String causeMessage = NestedExceptionUtils.getMostSpecificCause(ex).getMessage(); // determine the root cause message

	        String reqPath = req.getServletPath(); // get the request path            

	        String userMessage =  "there is error";// Decide what the message you will show to users

	        HttpStatus status =  HttpStatus.NOT_FOUND; // Decide what the status your response will be have, for example HttpStatus.CONFLICT

	        ApiErrorDetail message = new ApiErrorDetail(); // Create your custom error message
	        message.setCode(1234);
	        message.setMessage(userMessage);
	        message.setTimeStamp(LocalDateTime.now());
	        return new ResponseEntity<>(message, status); // return response to users
	    }
}
