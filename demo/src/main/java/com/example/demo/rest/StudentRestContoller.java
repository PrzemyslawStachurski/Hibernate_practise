package com.example.demo.rest;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestContoller {

    //defining endpoint for getting list of all students
    @GetMapping("/students")
    public List<Student> getStudents(){

        //hardcoding students
        List<Student> students = new ArrayList<>();

        students.add(new Student("jano" ,"banano"));
        students.add(new Student("Cyprian" ,"Banino"));
        students.add(new Student("kamil" ,"kowal"));
        students.add(new Student("jan" ,"nowak"));

        return students;
    }

}
