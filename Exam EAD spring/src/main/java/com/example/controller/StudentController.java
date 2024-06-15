package com.example.controller;

import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.service.StudentService;
import com.example.model.Student;


@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/list")
    public Iterable<Student> studentInformation() {
        Iterable<Student> students = studentService.getAllStudents();
        return students;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public Student registerStudent(@RequestBody Student student) {
        studentService.save(student);
        return student;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    @ResponseBody
    public Student updateStudent(@RequestBody Student student) {
        studentService.update(student);
        return student;
    }

}
