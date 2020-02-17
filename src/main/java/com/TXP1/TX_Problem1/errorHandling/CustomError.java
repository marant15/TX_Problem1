package com.TXP1.TX_Problem1.errorHandling;

public class CustomError {
	
	private String message;
	private String details;
	private int code;
	
	public CustomError(String message, String details, int code) {
		this.message = message;
		this.details = details;
		this.code = code;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String getDetails() {
		return this.details;
	}
	
	public int getCode() {
		return this.code;
	}
}
