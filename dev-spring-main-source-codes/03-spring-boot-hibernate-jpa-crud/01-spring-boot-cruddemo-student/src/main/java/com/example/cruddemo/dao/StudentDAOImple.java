package com.example.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImple implements StudentDAO {
	
	private EntityManager entityManager;
	
	//constructor injection for entity manager
	@Autowired
	public StudentDAOImple(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	//implement save method
	//transactional is actually spring framework annotation not the jakarta one
	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		//Here we are using JPQL (Jakarta persistence Query Language) and purely uses Entity class name and entity fields 
		//instead of database table name and table columns
		
		//create query
		//FROM Student to return all students
		//FROM Student order by lastName desc to return all students with lastName in descending order
		//
		TypedQuery<Student> theQuery =  entityManager.createQuery("FROM Student order by lastName desc", Student.class);
		
		//return query results
		List<Student> students = theQuery.getResultList();
		
		return students;
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		
		//Create query
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData", Student.class);
		
		//changing parameter value
		theQuery.setParameter("theData", lastName);
		
		//return query results
		List<Student> students = theQuery.getResultList();
		
		return students;
	}

	
	//@Transactional is mandatory if we are changing data in database
	@Override
	@Transactional
	public void updateStudent(Student student) {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Student theStudent = entityManager.find(Student.class, id);
		entityManager.remove(theStudent);
	}

	@Override
	@Transactional
	public int deleteAll() {
		return entityManager.createQuery("DELETE FROM Student", Student.class).executeUpdate();
	}

	@Override
	@Transactional
	public int updateStudentById(int id) {
		TypedQuery<Student> theQuery = entityManager.createQuery("UPDATE Student set lastName='chinnu' WHERE id=:theId", Student.class);
		theQuery.setParameter("theId", id);
		return theQuery.executeUpdate();
	}

}
