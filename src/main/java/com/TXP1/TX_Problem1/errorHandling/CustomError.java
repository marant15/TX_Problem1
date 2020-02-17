package com.TXP1.TX_Problem1.errorHandling;

public class CustomError extends Exception{
	
	private static final long serialVersionUID = 1L;
	private int code;
	
	public CustomError(String message, int code) {
		super(message);
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
}
