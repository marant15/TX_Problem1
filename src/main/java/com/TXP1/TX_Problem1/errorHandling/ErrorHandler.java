package com.TXP1.TX_Problem1.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorHandler {
	/**
	 * Handler function for not found exception
	 * @param ex type of Exception
	 * @param request type of WebRequest
	 * @return Response
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> notFound(Exception ex, WebRequest request){
		return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Handler function for NotFundException thrown by services or controllers
	 * @param ex type of Exception
	 * @param request type of WebRequest
	 * @return Response
	 */
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> entityNotFound(EntityNotFoundException ex, WebRequest request){
		return new ResponseEntity<>(ex, HttpStatus.resolve(ex.getCode()));
	}
	
	/**
	 * Handler function for RepeatedKeyException thrown by services or controllers
	 * @param ex type of Exception
	 * @param request type of WebRequest
	 * @return Response
	 */
	@ExceptionHandler(RepeatedKeyException.class)
	public ResponseEntity<?> repeatedKey(RepeatedKeyException ex, WebRequest request){
		return new ResponseEntity<>(ex, HttpStatus.resolve(ex.getCode()));
	}
	
	/**
	 * Handler function for exceptions caused by internal server errors
	 * @param ex type of Exception
	 * @param request type of WebRequest
	 * @return Response
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> errorHandler(Exception ex, WebRequest request){
		return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
