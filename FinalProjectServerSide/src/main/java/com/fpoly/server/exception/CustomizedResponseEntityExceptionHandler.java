/*
 * (C) Copyright 2020 Fresher Academy. All Rights Reserved.
 * 
 * @author HoangMH1
 * @date Oct 8, 2020
 * @version 1.0
 */
package com.fpoly.server.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request ){
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
						new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
						new Date(), ex.getMessage(), ex.getBindingResult().toString());
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	/*
	
	// DuyNT34 created
	@ExceptionHandler(CategoryNotFoundException.class)
	public final ResponseEntity<Object> handleCategoryNotFoundExceptions(CategoryNotFoundException ex, WebRequest request){
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
						new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	*/
	// DuyNT34 created
	@ExceptionHandler(BadRequestException.class)
	protected ResponseEntity<Object> handleBadRequestExceptions(BadRequestException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
						new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
}