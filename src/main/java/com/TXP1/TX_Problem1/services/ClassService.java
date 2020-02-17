package com.TXP1.TX_Problem1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.TXP1.TX_Problem1.entities.Class;
import com.TXP1.TX_Problem1.entities.ClassDetail;
import com.TXP1.TX_Problem1.errorHandling.CustomError;

@Service
public class ClassService {

	private List<Class> classList= new ArrayList<Class>(Arrays.asList(
			new Class(221,"Math","Math class"),
			new Class(222,"Physics","Physics class"),
			new Class(223,"Chemestry","Chemestry class")));
	
	public List<Class> getAll() {
		return classList;
	}

	public Class create(Class clas) throws CustomError {
		if(classList.stream().anyMatch(cls-> cls.getCode()==clas.getCode()))
			throw new CustomError("Repeated Class code", 400);
		classList.add(clas);
		return clas;
	}

	public void delete(int code) throws CustomError {
		if(!classList.removeIf(clas -> clas.getCode()== code))
			throw new CustomError("class code does not exist", 400);
	}

	public Class update(int code, Class clas) throws CustomError {
		for(int i =0; i<classList.size(); i++) {
			if(classList.get(i).getCode() == code) {
				classList.set(i,clas);
				return clas;
			}
		}
		throw new CustomError("class code does not exist", 400);
	}

	public List<Class> getByCodes(List<ClassDetail> details) {
		List<Class> response = new ArrayList<Class>();
		for(ClassDetail detail: details) {
			for(Class clas : classList) {
				if (detail.getCode() == clas.getCode()) {
					response.add(clas);
					break;
				}
			}
		}
		return response;
	}
}
