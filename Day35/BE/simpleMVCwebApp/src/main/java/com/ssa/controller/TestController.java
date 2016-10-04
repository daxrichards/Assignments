/*package com.ssa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eddb.Student;



@CrossOrigin
@RestController
public class TestController {
	
	@RequestMapping("/student")
//Returns an object
public Student student(){
		return new Student("Charlie","Brown",1610,4.4);
	}
	
@RequestMapping("/students")
public List<Student> students(){
	ArrayList<Student> students = new ArrayList<Student>();
	students.add(new Student("John","Thomas",1300, 4.0));
	students.add(new Student("Peter","Lane",1200, 3.9));
	students.add(new Student("Ronald","Harris",1600, 3.5));
	students.add(new Student("Alison","Nagle",1500, 3.5));
	students.add(new Student("Yvette","Lawrence",1600, 4.0));
	return students;
}
	
	
	
	
}
*/