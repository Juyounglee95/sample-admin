package com.msa.demo.userInfo.context.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 2L;
 
    public RecordNotFoundException(String message) {
        super(message);
    }
}