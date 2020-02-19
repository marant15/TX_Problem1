package com.TXP1.TX_Problem1.errorHandling;

public class RepeatedKeyException extends Exception{
	private static final long serialVersionUID = 1L;
	private int code;
	
	/**
	 * Class that includes the code error for exception
	 * @param message type of String
	 * @param code type of int
	 */
	public RepeatedKeyException(String keyType) {
		super(keyType+" already exists");
		this.code = 400;
	}
	
	/**
	 * get the exception code
	 * @return
	 */
	public int getCode() {
		return this.code;
	}
}
