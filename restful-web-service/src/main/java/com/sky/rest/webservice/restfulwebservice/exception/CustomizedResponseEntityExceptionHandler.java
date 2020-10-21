package com.sky.rest.webservice.restfulwebservice.exception;

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
@ControllerAdvice//this is used to use the resource across all the controller in the application.m
@RestController
public class CustomizedResponseEntityExceptionHandler 
extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception{
		ExceptionResponse response=
				new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception{
		ExceptionResponse response=
				new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(response,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserDeleteException.class)
	public final ResponseEntity<Object> handleCantDeleteException(UserDeleteException ex, WebRequest request) throws Exception{
		ExceptionResponse response=
				new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
             ExceptionResponse response=
            		new ExceptionResponse(new Date(),ex.getBindingResult().toString(),request.getDescription(false));
		return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
	}

}
