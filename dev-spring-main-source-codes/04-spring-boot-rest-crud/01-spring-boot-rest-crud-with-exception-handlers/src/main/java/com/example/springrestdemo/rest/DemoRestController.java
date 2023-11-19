package com.example.springrestdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrestdemo.DAO.Employee;

@RestController
@RequestMapping("/test")
public class DemoRestController {
//	@Autowired
//	private Employee employee;
	
//	//Constructor dependency Injection
//	@Autowired
//	public DemoRestController(Employee theEmployee) {
//		employee = theEmployee;
//	}
	
	
	//add code for "/hello" endpoint
	//so for http://localhost:8080/test/hello we get "Hello World!" message
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
	
	

	@PostMapping("/getEmployee")
	public String getEmploee(@RequestBody Employee newEmployee) {
		return newEmployee.toString();
	}
}
