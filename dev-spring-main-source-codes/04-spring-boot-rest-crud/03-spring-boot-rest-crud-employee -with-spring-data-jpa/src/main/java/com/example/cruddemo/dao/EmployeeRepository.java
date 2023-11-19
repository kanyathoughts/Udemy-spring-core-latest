package com.example.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cruddemo.entity.Employee;

//In JpaRepository, first value is entity type and second value is primary key data point
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//that's it..no need to write any code...we will get all crud operations from jpa repository interface
}
