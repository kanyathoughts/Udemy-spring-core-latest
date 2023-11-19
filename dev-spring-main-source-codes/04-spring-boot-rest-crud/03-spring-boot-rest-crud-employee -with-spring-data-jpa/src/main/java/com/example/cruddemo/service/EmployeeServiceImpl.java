package com.example.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddemo.dao.EmployeeRepository;
import com.example.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	//Here when we use Employee DAO then we can inject that but here we are using Employee Repository which extends the JPA repository 
	//so we need to inject Employee repository
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not find employee with id : " + id);
		}
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}
