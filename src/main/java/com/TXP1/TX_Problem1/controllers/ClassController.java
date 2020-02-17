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

import com.TXP1.TX_Problem1.entities.Class;
import com.TXP1.TX_Problem1.services.ClassService;

@RestController
@RequestMapping("/api")
public class ClassController {

	@Autowired
	private ClassService classService;
	
	@GetMapping("/class")
	public List<Class> getAllStudents(){
		return classService.getAll();
	}
	
	@PostMapping("/class")
	public Class createStudent(@RequestBody Class clas) {
		return classService.create(clas);
	}
	
	@DeleteMapping("/class/{code}")
	public void deleteStudent(@PathVariable(value = "code") int code) {
		classService.delete(code);
	}
	
	@PutMapping("/class/{code}")
	public Class updateStudent(@PathVariable(value = "code") int code, @RequestBody Class clas) {
		return classService.update(code, clas);
	}
}
