package com.arya.swagger.controller;

import com.arya.swagger.model.Employee;
import com.arya.swagger.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = createAllStudentList();

    @GetMapping(value = "/students", produces = "application/json")
    public List<Student> firstPage() {
        System.out.println(" Student Size : " + students.size());
        return students;
    }

    private static List<Student> createAllStudentList() {
        List<Student> allStudents = new ArrayList<>();
        for (long i = 1; i < 5; i++) {
            var student = new Student(
                    i, "Arya", "aarya@gmail.com", "New Baneshor"
            );
            allStudents.add(student);
        }
        return allStudents;
    }
}
