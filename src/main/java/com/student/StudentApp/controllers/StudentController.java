package com.student.StudentApp.controllers;

import com.student.StudentApp.models.Students;
import com.student.StudentApp.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController{
    private final StudentService studentService;

//    Dependency Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    GET REQUEST
    @GetMapping
    public List<Students> getStudents(){
        return studentService.getAllStudents();
    }

//    POST REQUEST
    @PostMapping
    public Students createStudent(@RequestBody Students student){
        studentService.addStudent(student);
        System.out.println("Student with the id " + student.getId() + " has succesfully been created");
        return student;

    }

//    PUT REQUEST (UPDATE)
    @PutMapping("/{id}")
    public Students updateStudent(@PathVariable Long id, @RequestBody Students student){
        return studentService.updateStudent(id, student);
    }

//    DELETE REQUEST (DELETE)
    @DeleteMapping("/{id}")
    public List<Students> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return getStudents();
    }

}
