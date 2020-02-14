package com.TXP1.TX_Problem1.entities;

public class Student {
	
	private int studentId;
	private String lastNmae;
	private String firstName;
	
	public Student(int studentId, String lastNmae, String firstName) {
		this.studentId = studentId;
		this.lastNmae = lastNmae;
		this.firstName = firstName;
	}
	
	public Student() {
		
	}
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getLastNmae() {
		return lastNmae;
	}

	public void setLastNmae(String lastNmae) {
		this.lastNmae = lastNmae;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
}
