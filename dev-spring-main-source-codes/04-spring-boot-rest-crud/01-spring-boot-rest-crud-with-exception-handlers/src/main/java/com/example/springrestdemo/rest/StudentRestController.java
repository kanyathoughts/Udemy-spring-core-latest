package com.example.springrestdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrestdemo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> stu;
	
	//define @PostConstruct to load student data only once 
	@PostConstruct
	public void loadData() {
		stu = new ArrayList<>();
		
		stu.add(new Student("kanya", "kumari"));
		stu.add(new Student("jashu", "buddi"));
		stu.add(new Student("tanvi", "lalli"));
	}
	
	//Here by using the jackson this below list will be converted to array of json while returning to REST client from REST Server
	@GetMapping("/students")
	public List<Student> getStudents() {
		return stu;
	}
	
	//retrieve single student by studentID
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		//just index into the list..keep it simple for now
		
		//check studentId against students list
		
		if((studentId >= stu.size() || studentId < 0)) {
			throw new StudentNotFoundException("student id not found: " + studentId);
		}
		
		return stu.get(studentId);
	}
}
