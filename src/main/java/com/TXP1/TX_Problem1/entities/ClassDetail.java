package com.TXP1.TX_Problem1.entities;

public class ClassDetail {
	
	private int studentId;
	private int code;
	
	/**
	 * Clean constructor
	 */
	public ClassDetail() {
		
	}

	/**
	 * Constructor with parameters
	 * @param studentId type of int
	 * @param code type of int
	 */
	public ClassDetail(int studentId, int code) {
		super();
		this.studentId = studentId;
		this.code = code;
	}
	
	/**
	 * get StudentId
	 * @return studentId type of int
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * set studentId
	 * @param studentId type of int
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * get class code
	 * @return code type of int
	 */
	public int getCode() {
		return code;
	}

	/**
	 * set class code
	 * @param code type of int
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	
}
