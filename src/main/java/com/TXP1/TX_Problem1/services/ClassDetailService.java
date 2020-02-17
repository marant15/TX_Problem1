package com.TXP1.TX_Problem1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.TXP1.TX_Problem1.entities.ClassDetail;

@Service
public class ClassDetailService {
	
	private List<ClassDetail> classDetailList= new ArrayList<ClassDetail>(Arrays.asList(
			new ClassDetail(111,221),
			new ClassDetail(112,221),
			new ClassDetail(113,222),
			new ClassDetail(111,222)));
	
	public List<ClassDetail> getAll() {
		return classDetailList;
	}
	
	public List<ClassDetail> getByStudent(int studentId){
		return classDetailList.stream().filter(detail -> detail.getStudentId()==studentId).collect(Collectors.toList());
	}
	
	public List<ClassDetail> getByClass(int code){
		return classDetailList.stream().filter(detail -> detail.getCode()==code).collect(Collectors.toList());
	}
}
