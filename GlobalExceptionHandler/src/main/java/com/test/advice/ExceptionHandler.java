package com.test.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.test.exception.UserNotFound;

@RestControllerAdvice
public class ExceptionHandler 
{    @ResponseStatus(HttpStatus.NOT_FOUND)
	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFound.class)
	public ResponseEntity<Object>  exception(UserNotFound ex){
	
	     return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);	
		
	}

}
