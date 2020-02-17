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

@RestController
@RequestMapping("/api")
public class StudentController {

		@Autowired
		private StudentService studentService;
		@Autowired
		private ClassDetailService classDetailService;
		
		@GetMapping("/students")
		public List<Student> getAllStudents(){
			return studentService.getAll();
		}
		
		@PostMapping("/students")
		public Student createStudent(@RequestBody Student student) {
			return studentService.create(student);
		}
		
		@DeleteMapping("/students/{id}")
		public void deleteStudent(@PathVariable(value = "id") int studentId) {
			studentService.delete(studentId);
		}
		
		@PutMapping("/students/{id}")
		public Student updateStudent(@PathVariable(value = "id") int studentId, @RequestBody Student student) {
			return studentService.update(studentId, student);
		}
		
		@GetMapping("/studentsInClass/{code}")
		public List<Student> getStudentsInClass(@PathVariable(value = "code") int code){
			return studentService.getByIds(classDetailService.getByClass(code));
		}
		
}
