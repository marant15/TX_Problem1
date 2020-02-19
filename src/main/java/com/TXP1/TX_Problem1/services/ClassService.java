package com.TXP1.TX_Problem1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.TXP1.TX_Problem1.entities.Class;
import com.TXP1.TX_Problem1.entities.ClassDetail;
import com.TXP1.TX_Problem1.errorHandling.EntityNotFoundException;
import com.TXP1.TX_Problem1.errorHandling.RepeatedKeyException;

@Service
public class ClassService {

	private List<Class> classList= new ArrayList<Class>(Arrays.asList(
			new Class(221,"Math","Math class"),
			new Class(222,"Physics","Physics class"),
			new Class(223,"Chemestry","Chemestry class")));
	
	/**
	 * get all Classes
	 * @return List<Class>
	 */
	public List<Class> getAll() {
		return classList;
	}

	/**
	 * Function that creates a new Class object in the data
	 * @param clas type of Class
	 * @return type of Class
	 */
	public Class create(Class clas) throws RepeatedKeyException {
		if(classList.stream().anyMatch(cls-> cls.getCode()==clas.getCode()))
			throw new RepeatedKeyException("class "+clas.getCode());
		classList.add(clas);
		return clas;
	}

	/**
	 * Function that deletes a class with the code parameter
	 * @param code type of integer
	 */
	public void delete(int code) throws EntityNotFoundException {
		if(!classList.removeIf(clas -> clas.getCode()== code))
			throw new EntityNotFoundException("class "+code);
	}

	/**
	 * Function that updates the data of class with the code parameter
	 * @param code type of integer
	 * @param class type of Class
	 * @return type of Class
	 */
	public Class update(int code, Class clas) throws EntityNotFoundException {
		OptionalInt classIndex = IntStream.range(0, classList.size())
			     .filter(i -> classList.get(i).getCode()==code)
			     .findFirst();
		if(classIndex.isPresent()) {
			classList.set(classIndex.getAsInt(), clas);
			return clas;
		}else
			throw new EntityNotFoundException("class "+code);
	}

	/**
	 * Function that returns the list of Classes of in the detail list
	 * @param details type of List<ClassDetail>
	 * @return List<Class>
	 */
	public List<Class> getByCodes(List<ClassDetail> details) {
		List<Class> response = new ArrayList<Class>();
		details.stream().forEach(detail -> response.add(classList.stream()
				.filter(classroom -> classroom.getCode() == detail.getCode())
				.findFirst().get()));
		return response;
	}
}
