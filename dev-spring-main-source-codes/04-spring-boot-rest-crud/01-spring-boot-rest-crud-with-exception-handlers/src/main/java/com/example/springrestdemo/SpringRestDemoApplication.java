package com.example.springrestdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springrestdemo.DAO.daoInterface;

@SpringBootApplication
public class SpringRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(daoInterface dao) {
		return runner -> {
//			dao.save(new com.example.springrestdemo.DAO.Employee("Thanvitha", 25, "female"));
//			dao.save(new com.example.springrestdemo.DAO.Employee("Gundu", 04, "female"));
//			dao.findAll();
		};
	}

}
