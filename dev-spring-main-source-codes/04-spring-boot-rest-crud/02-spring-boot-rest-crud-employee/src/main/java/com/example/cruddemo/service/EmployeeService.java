package com.example.cruddemo.service;

import java.util.List;

import com.example.cruddemo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int id);
	
	void add(Employee employee);

}
