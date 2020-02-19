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
import com.TXP1.TX_Problem1.errorHandling.EntityNotFoundException;
import com.TXP1.TX_Problem1.errorHandling.RepeatedKeyException;
import com.TXP1.TX_Problem1.services.ClassDetailService;
import com.TXP1.TX_Problem1.services.ClassService;

@RestController
@RequestMapping("/api")
public class ClassController {

	@Autowired
	private ClassService classService;
	@Autowired
	private ClassDetailService classDetailService;
	
	/**
	 * Retrieve all classes in the data
	 * @return List<Class>
	 */
	@GetMapping("/class")
	public List<Class> getAllClasses(){
		return classService.getAll();
	}
	
	/**
	 * Receives a class object and retrieves the same class object if
	 * no errors occur
	 * @param class type of Class
	 * @return type of Class 
	 */
	@PostMapping("/class")
	public Class createClass(@RequestBody Class clas) throws RepeatedKeyException {
		return classService.create(clas);
	}
	
	/**
	 * Delete the Class with the same parameter code
	 * @param code type of integer
	 */
	@DeleteMapping("/class/{code}")
	public void deleteClass(@PathVariable(value = "code") int code) throws EntityNotFoundException {
		classService.delete(code);
	}
	
	/**
	 * Update the class with the same parameter code with class parameter values
	 * @param code type of integer
	 * @param clas type of Class
	 * @return Type of Class
	 */
	@PutMapping("/class/{code}")
	public Class updateClass(@PathVariable(value = "code") int code, @RequestBody Class clas) throws EntityNotFoundException {
		return classService.update(code, clas);
	}
	
	/**
	 * Return all the classes assigned to the student with the same studentId parameter
	 * @param studentId type of integer
	 * @return List<Class>
	 */
	@GetMapping("/studentClasses/{id}")
	public List<Class> getSudentsInClass(@PathVariable(value = "id") int studentId){
		return classService.getByCodes(classDetailService.getByStudent(studentId));
	}
}
