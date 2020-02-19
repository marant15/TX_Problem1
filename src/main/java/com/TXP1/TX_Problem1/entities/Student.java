package com.TXP1.TX_Problem1.entities;

public class Student {
	
	private int studentId;
	private String lastName;
	private String firstName;
	
	/**
	 * Constructor with all parameters
	 * @param studentId type of integer
	 * @param lastName type of String
	 * @param firstName type of String
	 */
	public Student(int studentId, String lastName, String firstName) {
		this.studentId = studentId;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	/**
	 * Clean constructor
	 */
	public Student() {
		
	}
	
	/**
	 * get studentId
	 * @return studentId type of integer
	 */
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * set studentId
	 * @param studentId type of integer
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * get student lastName
	 * @return lastName String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * set student lastName
	 * @param lastName type of String
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * get student firstName
	 * @return firstName type of String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set student firstName
	 * @param firstName type of String
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
}
