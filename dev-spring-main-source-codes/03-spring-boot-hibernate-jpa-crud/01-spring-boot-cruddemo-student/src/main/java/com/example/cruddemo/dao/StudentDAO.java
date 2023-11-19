package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.entity.Student;

public interface StudentDAO {
	
	void save(Student student);
	
	Student findById(int id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String lastName);
	
	void updateStudent(Student student);
	
	int updateStudentById(int id);
	
	void deleteById(int id);
	
	int deleteAll();

}
