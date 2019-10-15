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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.msa.demo.userInfo.context.exception.apierror.ApiErrorDetail;
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler{
	 private ResponseEntity<Object> buildResponseEntity(ApiErrorDetail apiError) {
	        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	    }
	 @ExceptionHandler(EntityNotFoundException.class)
	   protected ResponseEntity<Object> handleEntityNotFound(
	           EntityNotFoundException ex) {
	      
	       return buildResponseEntity(new ApiErrorDetail(HttpStatus.NOT_FOUND, ex));
	   }
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseBody
	  public ResponseEntity<?> handleDataIntegrityViolation(DataIntegrityViolationException ex, HttpServletRequest req) {

	        String causeMessage = NestedExceptionUtils.getMostSpecificCause(ex).getMessage(); // determine the root cause message

	        String reqPath = req.getServletPath(); // get the request path            

	        String userMessage =  "there is error";// Decide what the message you will show to users

	        HttpStatus status =  HttpStatus.NOT_FOUND; // Decide what the status your response will be have, for example HttpStatus.CONFLICT

	        ApiErrorDetail message = new ApiErrorDetail(status); // Create your custom error message
	        message.setMessage(userMessage);
	        return new ResponseEntity<>(message, status); // return response to users
	    }
	@ExceptionHandler({Exception.class, RecordNotFoundException.class}) 
	public ModelAndView handleError(HttpServletRequest req, Exception exception) 
	{ 	
		logger.error("Request: " + req.getRequestURL() + " raised " + exception); 
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("exception", exception); 
		mav.addObject("url", req.getRequestURL());
	
		mav.setViewName("/error/4xx"); 
			return mav; 
	}

	private ResponseEntity<?> error(HttpStatus status, Exception e) {
        System.out.println("Exception: "+ e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
