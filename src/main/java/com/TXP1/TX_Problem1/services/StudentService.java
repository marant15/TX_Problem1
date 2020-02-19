package com.TXP1.TX_Problem1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.TXP1.TX_Problem1.entities.ClassDetail;
import com.TXP1.TX_Problem1.entities.Student;
import com.TXP1.TX_Problem1.errorHandling.CustomError;

@Service
public class StudentService {
	
	private List<Student> studentList= new ArrayList<Student>(Arrays.asList(
			new Student(111,"Wilson","John"),
			new Student(112,"Graham","Jane"),
			new Student(113,"Bam","Pam")));
	
	/**
	 * Get all students
	 * @return List<Student>
	 */
	public List<Student> getAll() {
		return studentList;
	}

	/**
	 * Creates a Student with student parameters
	 * @param student type of Student
	 * @return student type of Student
	 */
	public Student create(Student student) throws CustomError {
		if(studentList.stream().anyMatch(std-> std.getStudentId()==student.getStudentId()))
			throw new CustomError("Repeated studentId", 400);
		studentList.add(student);
		return student;
	}

	/**
	 * delete the student with studentId parameter
	 * @param studentId type of int
	 */
	public void delete(int studentId) throws CustomError {
		if(!studentList.removeIf(student -> student.getStudentId()== studentId))
			throw new CustomError("StudentId does not exist", 400);
	}

	/**
	 * update the student with studentId parameter
	 * @param studentId type of int
	 * @param student type of Student
	 * @return student type of Student
	 */
	public Student update(int studentId, Student student) throws CustomError {
		OptionalInt classIndex = IntStream.range(0, studentList.size())
			     .filter(i -> studentList.get(i).getStudentId()==studentId)
			     .findFirst();
		if(classIndex.isPresent()) {
			studentList.set(classIndex.getAsInt(), student);
			return student;
		}else
			throw new CustomError("StudentId does not exist", 400);
	}

	/**
	 * function that returns all students of the details List
	 * @param details type of List<Student>
	 * @return List<Student>
	 */
	public List<Student> getByIds(List<ClassDetail> details) {
		List<Student> response = new ArrayList<Student>();
		details.stream().forEach(detail -> response.add(studentList.stream()
				.filter(student -> student.getStudentId() == detail.getStudentId())
				.findFirst().get()));
		return response;
	}
	
	
}
