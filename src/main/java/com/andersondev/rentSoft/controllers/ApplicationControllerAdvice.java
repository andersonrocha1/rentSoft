package com.andersondev.rentSoft.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.andersondev.rentSoft.exceptions.RecordNotFoundException;


@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	
	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND )
	public String handleNotFoundException(RecordNotFoundException except) {
		
		return except.getMessage();
		
	}

}
