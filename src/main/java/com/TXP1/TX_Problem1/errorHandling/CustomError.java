package com.TXP1.TX_Problem1.errorHandling;

public class CustomError extends Exception{
	
	private static final long serialVersionUID = 1L;
	private int code;
	
	/**
	 * Class that includes the code error for exception
	 * @param message type of String
	 * @param code type of int
	 */
	public CustomError(String message, int code) {
		super(message);
		this.code = code;
	}
	
	/**
	 * get the exception code
	 * @return
	 */
	public int getCode() {
		return this.code;
	}
}
