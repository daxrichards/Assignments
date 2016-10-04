package com.ssa.service;

import java.util.List;

import com.ssa.entity.Student;

public interface IStudentService {

	List<Student> getAllStudents();
	Student getStudentById(int id);
	boolean addStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(int id);
}
