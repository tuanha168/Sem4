package com.example.service;

import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.model.Student;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Student student) {
        if (studentRepository.existsById(student.getStudent_id())) {
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found");
        }
    }

}
