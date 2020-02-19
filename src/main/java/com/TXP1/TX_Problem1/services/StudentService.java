package com.TXP1.TX_Problem1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.TXP1.TX_Problem1.entities.ClassDetail;
import com.TXP1.TX_Problem1.entities.Student;
import com.TXP1.TX_Problem1.errorHandling.EntityNotFoundException;
import com.TXP1.TX_Problem1.errorHandling.RepeatedKeyException;

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
	 * @throws RepeatedKeyException 
	 */
	public Student create(Student student) throws RepeatedKeyException {
		if(studentList.stream().anyMatch(std-> std.getStudentId()==student.getStudentId()))
			throw new RepeatedKeyException("studentId "+student.getStudentId());
		studentList.add(student);
		return student;
	}

	/**
	 * delete the student with studentId parameter
	 * @param studentId type of int
	 * @throws EntityNotFoundException 
	 */
	public void delete(int studentId) throws EntityNotFoundException {
		if(!studentList.removeIf(student -> student.getStudentId()== studentId))
			throw new EntityNotFoundException("studentId "+studentId);
	}

	/**
	 * update the student with studentId parameter
	 * @param studentId type of int
	 * @param student type of Student
	 * @return student type of Student
	 * @throws EntityNotFoundException 
	 */
	public Student update(int studentId, Student student) throws EntityNotFoundException {
		OptionalInt classIndex = IntStream.range(0, studentList.size())
			     .filter(i -> studentList.get(i).getStudentId()==studentId)
			     .findFirst();
		if(classIndex.isPresent()) {
			studentList.set(classIndex.getAsInt(), student);
			return student;
		}else
			throw new EntityNotFoundException("studentId "+studentId);
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
