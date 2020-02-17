package com.TXP1.TX_Problem1.entities;

public class ClassDetail {
	
	private int studentId;
	private int code;
	
	public ClassDetail() {
		
	}

	public ClassDetail(int studentId, int code) {
		super();
		this.studentId = studentId;
		this.code = code;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
