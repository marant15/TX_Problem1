package com.TXP1.TX_Problem1.entities;

public class Class {
	
	private int code;
	private String title;
	private String description;
	
	/**
	 * Class constructor with parameters
	 * @param code type of integer
	 * @param title type of String
	 * @param description type of String
	 */
	public Class(int code, String title, String description) {
		this.code = code;
		this.title = title;
		this.description = description;
	}
	
	/**
	 * Clean constructor
	 */
	public Class() {
		
	}

	/**
	 * get Class code
	 * @return code type of integer
	 */
	public int getCode() {
		return code;
	}

	/**
	 * set Class code 
	 * @param code type of integer
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Get the class title
	 * @return title type of String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set Class title
	 * @param title type of String
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get class description type of String
	 * @return description type of String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set class description
	 * @param description type of String
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
