package com.example.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.dao.StudentDAOImple;
import com.example.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// Command line runner is an interface to be executed after all the beans
	// execution.
	//Here inside the command line runner we have to inject DAO interface
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO, new Student("buddi", "laddu", "345@gmail.com"));
			//readStudent(studentDAO);
			//findAllStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteRow(studentDAO);
			
			studentDAO.deleteAll();
//			deleteAllStudents(studentDAO);
//			studentDAO.updateStudentById(3);
		};
	}


	private void deleteAllStudents(StudentDAO studentDAO) {
		//deleting all students
		System.out.println("deleting all students");
		studentDAO.deleteAll();
	}

	private void deleteRow(StudentDAO studentDAO) {
		//deleting row by id: primary key
		studentDAO.deleteById(1);
		
	}

//	private void createStudent(StudentDAO studentDAO) {
//		
//		//Creating student
//		Student student = new Student("kanya", "kumari", "123@gmail.com");
//		
//		//save this student to database
//		studentDAO.save(student);
//		
//		//display id of the saved student
//		System.out.println("id of the student: " + student.getId());
//		
//	}

	private void updateStudent(StudentDAO studentDAO) {
		//first we have to get the row where we need to update
		//getting table row based on primary key which is id
		int idNumber = 1;
		
		//Got the table row by id
		Student student = studentDAO.findById(idNumber);
		
		System.out.println("Before updation: " + student);
		
		//update the student properties like first name
		student.setFirstName("Jashvitha");
		
		//After updating we need to merge changes as in to update in database
		//In this updateStudent we are merging changes to database
		studentDAO.updateStudent(student);
		
		System.out.println("updated row: " + student);
		
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//returning list of students
		List<Student> students = studentDAO.findByLastName("laddu");
		
		
		//display list of students
		for(Student s : students) {
			System.out.println(s);
		}
	}

	private void createStudent(StudentDAO studentDAO, Student student) {

		// Creating student
//		Student student = new Student("kanya", "kumari", "123@gmail.com");

		// save this student to database
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("id of the student: " + student.getId());

	}
	
	private void readStudent(StudentDAO studentDAO) {
		// Creating student
		Student tempStudent = new Student("kanya", "kumari", "123@gmail.com");

		// save this student to database
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("id of the student: " + tempStudent.getId());
		
		//retrieving student by primary key id
		Student myStudent = studentDAO.findById(tempStudent.getId());
		
		//read student
		System.out.println("reading student: " + myStudent);
	}
	
	private void findAllStudents(StudentDAO studentDAO) {
		//find all students
		List<Student> students = studentDAO.findAll();
		
		//printing all students in students list
		for(Student s : students) {
			System.out.println(s);
		}
		
	}
	
	

}
