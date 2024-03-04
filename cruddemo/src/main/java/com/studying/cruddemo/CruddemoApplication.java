package com.studying.cruddemo;

import com.studying.cruddemo.dao.StudentDAO;
import com.studying.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner-> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			findByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int i =studentDAO.deleteAll();

		System.out.println(i + " students deleted");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("deleting student");
		studentDAO.delete(2);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student= studentDAO.findById(1);

		student.setFirstName("maurycy");

		studentDAO.update(student);

		System.out.println(student);
	}

	private void findByLastName(StudentDAO studentDAO) {
		List<Student> listOfStudents = studentDAO.findByLastName("truskawa");

		for (Student s : listOfStudents){
			System.out.println(s);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> listOfStudents = studentDAO.findAll();

		for (Student tempStudent: listOfStudents){
			System.out.println(tempStudent);
		}


	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("creating student");
		Student tempStudent = new Student("krzychu","truskawa","email@email");

		studentDAO.save(tempStudent);

		System.out.println("id of saved student" + tempStudent.getId());
		int id = tempStudent.getId();


		System.out.println("RETRIEVED STUDENT: " +studentDAO.findById(id));

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
		Student temopStudent = new Student("test","przywracany","powienienMiecID=2");

		System.out.println("saving student to db");
		studentDAO.save(temopStudent);

		System.out.println("displaying student`s generated id:");
		System.out.println(temopStudent.getId());

	}
}
