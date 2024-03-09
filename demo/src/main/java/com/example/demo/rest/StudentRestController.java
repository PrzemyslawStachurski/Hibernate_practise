package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    //PostConstruct loads the student data only once upon bean creation
    @PostConstruct
    public void loadData() {

        //hardcoding students
        students = new ArrayList<>();

        students.add(new Student("jano", "banano"));
        students.add(new Student("Cyprian", "Banino"));
        students.add(new Student("kamil", "kowal"));
        students.add(new Student("jan", "nowak"));
    }

    //defining endpoint for getting list of all students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    //define endpoint for getting single student by id
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if ((studentId < 0) || (studentId >= students.size())) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }
}
