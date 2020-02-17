package com.TXP1.TX_Problem1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TXP1.TX_Problem1.services.StudentService;
import com.TXP1.TX_Problem1.entities.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

		@Autowired
		private StudentService studentService;
		
		@GetMapping("/students")
		public List<Student> getAllStudents(){
			return studentService.getAll();
		}
}
