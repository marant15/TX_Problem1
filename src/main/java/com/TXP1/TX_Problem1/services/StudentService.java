package com.TXP1.TX_Problem1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.TXP1.TX_Problem1.entities.Student;

@Service
public class StudentService {
	
	private List<Student> studentList= new ArrayList<Student>(Arrays.asList(
			new Student(111,"Wilson","John"),
			new Student(112,"Graham","Jane"),
			new Student(113,"Bam","Pam")));
	
	public List<Student> getAll() {
		return studentList;
	}

	public Student create(Student student) {
		studentList.add(student);
		return student;
	}

	public void delete(int studentId) {
		studentList.removeIf(student -> student.getStudentId()== studentId);
	}

	public Student update(int studentId, Student student) {
		for(int i =0; i<studentList.size(); i++) {
			if(studentList.get(i).getStudentId() == studentId) {
				studentList.set(i,student);
				return student;
			}
		}
		return null;
	}
	
	
}
