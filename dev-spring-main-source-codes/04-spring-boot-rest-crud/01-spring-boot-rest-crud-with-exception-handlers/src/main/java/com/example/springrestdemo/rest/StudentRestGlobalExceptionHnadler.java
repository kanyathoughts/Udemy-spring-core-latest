package com.example.springrestdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestGlobalExceptionHnadler {
	
	//The actual flow is whenever we send bad request to REST server then it 
		//will throw the exception and it will handle the exception by returning response entity as response
		
		//Here we are only handling StudentNotFoundException
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exce) {
			
			//create a student error response
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value()); //not found means 404 status code
			error.setMessage(exce.getMessage()); //This is exception "Student not found message" which we are throwing
			error.setTimeStamp(System.currentTimeMillis()); //current time in milliseconds
			
			//return response entity
			//here we are returning response entity with error means StudentErrorResponse entity as a body and http status code as not found
			return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
		}
		
		//Here we are handling any kind of exception
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleGenericException(Exception exce) {
			
			//create a student error response
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.BAD_REQUEST.value()); //bad request means 400 status code
			error.setMessage(exce.getMessage()); //This is any exception that will be throwing
			error.setTimeStamp(System.currentTimeMillis()); //current time in milliseconds
			
			//return response entity
			return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
		}

}
