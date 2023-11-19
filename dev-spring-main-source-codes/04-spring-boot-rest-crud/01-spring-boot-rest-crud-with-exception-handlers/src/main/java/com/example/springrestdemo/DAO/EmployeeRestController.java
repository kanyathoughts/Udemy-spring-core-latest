package com.example.springrestdemo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/details")
public class EmployeeRestController {
	
	@Autowired
	private daoInterface dao;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return dao.findAll();
	}
	
	@GetMapping("/employees/{employeeName}")
	public Employee getEmployeeByName(@PathVariable String employeeName) {
		return dao.findEmployeeByName(employeeName);
	}

}
