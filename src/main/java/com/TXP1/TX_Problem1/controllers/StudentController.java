package com.TXP1.TX_Problem1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TXP1.TX_Problem1.services.ClassDetailService;
import com.TXP1.TX_Problem1.services.StudentService;
import com.TXP1.TX_Problem1.entities.Student;
import com.TXP1.TX_Problem1.errorHandling.CustomError;

@RestController
@RequestMapping("/api")
public class StudentController {

		@Autowired
		private StudentService studentService;
		@Autowired
		private ClassDetailService classDetailService;
		
		/**
		 * Get all Students
		 * @return List<Student>
		 */
		@GetMapping("/students")
		public List<Student> getAllStudents(){
			return studentService.getAll();
		}
		
		/**
		 * Create a student with student parameter values
		 * @param student type of Student
		 * @return student type of Student
		 */
		@PostMapping("/students")
		public Student createStudent(@RequestBody Student student) throws CustomError {
			return studentService.create(student);
		}
		
		/**
		 * Delete the student with the same studentId of parameter
		 * @param studentId type of int
		 */
		@DeleteMapping("/students/{id}")
		public void deleteStudent(@PathVariable(value = "id") int studentId) throws CustomError {
			studentService.delete(studentId);
		}
		
		/**
		 *Update the student with the same studentId parameter
		 * @param studentId type of int
		 * @param student type of Student
		 * @return student type of Student
		 */
		@PutMapping("/students/{id}")
		public Student updateStudent(@PathVariable(value = "id") int studentId, @RequestBody Student student) throws CustomError {
			return studentService.update(studentId, student);
		}
		
		/**
		 * Retrieves the list of all students in one class with the same parameter code  
		 * @param code type of int
		 * @return List<Student>
		 */
		@GetMapping("/studentsInClass/{code}")
		public List<Student> getStudentsInClass(@PathVariable(value = "code") int code){
			return studentService.getByIds(classDetailService.getByClass(code));
		}
		
}
