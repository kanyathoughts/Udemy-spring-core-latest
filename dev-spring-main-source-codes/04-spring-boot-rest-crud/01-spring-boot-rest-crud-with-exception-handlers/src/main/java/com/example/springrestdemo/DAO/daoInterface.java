package com.example.springrestdemo.DAO;

import java.util.List;

public interface daoInterface {
	
	void save(Employee employee);

	List<Employee> findAll();
	
	Employee findEmployeeByName(String name);
}
