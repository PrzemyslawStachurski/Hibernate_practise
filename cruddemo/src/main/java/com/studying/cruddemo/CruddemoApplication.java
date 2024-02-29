package com.studying.cruddemo;

import com.studying.cruddemo.dao.StudentDAO;
import com.studying.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner-> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO){
		System.out.println("creating 3 students");
		Student temopStudent = new Student("Jan","Kowalski","mail@email.com");
		Student temopStudent2 = new Student("Jano","Nowak","mail@email.com");
		Student temopStudent3 = new Student("Janek","Wisniewski","mail@email.com");

		System.out.println("saving students");
		studentDAO.save(temopStudent);
		studentDAO.save(temopStudent2);
		studentDAO.save(temopStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object");
		Student temopStudent = new Student("Jan","Kowalski","number3@email.com");

		System.out.println("saving student to db");
		studentDAO.save(temopStudent);

		System.out.println("displaying student`s generated id:");
		System.out.println(temopStudent.getId());

	}
}
