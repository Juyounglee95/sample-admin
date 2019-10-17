package com.msa.demo.userInfo.context.exception;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.msa.demo.userInfo.context.exception.apierror.ApiErrorDetail;
//@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {
	 private ResponseEntity<Object> buildResponseEntity(ApiErrorDetail apiError) { 
	        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	    }

	 @ExceptionHandler(RuntimeException.class)
	 @ResponseBody
	   protected ResponseEntity<?> handleNoHandlerFoundException(
	           RuntimeException ex) {
	      	System.out.println("Entity Not Found Exception");
	       return buildResponseEntity(new ApiErrorDetail(HttpStatus.NOT_FOUND, ex));
	   }
	
	@ExceptionHandler({RecordNotFoundException.class}) 
	public ModelAndView handleError(HttpServletRequest req, Exception exception) 
	{ 	
		logger.error("Request: " + req.getRequestURL() + " raised " + exception); 
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("exception", exception); 
		mav.addObject("url", req.getRequestURL());
	
		mav.setViewName("/error/4xx"); 
			return mav; 
	}
	
}

