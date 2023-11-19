package com.example.springrestdemo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class DAOImpl implements daoInterface {

	@Autowired
	EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(Employee employee) {
		entityManager.persist(employee);
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
		return theQuery.getResultList();
	}

	@Override
	public Employee findEmployeeByName(String name) {
		return entityManager.find(Employee.class, name);
	}

}
