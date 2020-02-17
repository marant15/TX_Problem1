package com.TXP1.TX_Problem1.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> notFound(Exception ex, WebRequest request){
		CustomError error = new CustomError(ex.getMessage(),request.getDescription(false),404);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> errorHandler(Exception ex, WebRequest request){
		CustomError error = new CustomError(ex.getMessage(),request.getDescription(false),500);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
