package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach{
	
	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	//define our init method
	@PostConstruct
	public void doMyStartUPStuff() {
		System.out.println("in doMyStartUPStuff: " + getClass().getSimpleName());
	}
	
	
	//define our destroy method
	@PreDestroy
	public void doMyCleanUPStuff() {
		System.out.println("in doMyCleanUPStuff: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 min <3 :)";
	}

}
