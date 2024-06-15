package com.example.service;

import com.example.repository.StudentRepository;
import com.example.repository.SubjectRepository;
import com.example.repository.StudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Student;
import com.example.model.Subject;
import com.example.model.StudentScore;
import com.example.dto.CreateStudentScoreDTO;


@Service
public class StudentScoreService {
    @Autowired
    private StudentScoreRepository studentScoreRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public StudentScore save(CreateStudentScoreDTO studentScoreDto) {
        Student student = studentRepository.findById(studentScoreDto.getStudent_id())
        .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + studentScoreDto.getStudent_id()));

        Subject subject = subjectRepository.findById(studentScoreDto.getSubject_id())
        .orElseThrow(() -> new IllegalArgumentException("Subject not found with id: " + studentScoreDto.getSubject_id()));

        StudentScore studentScore = new StudentScore();
        studentScore.setStudent(student);
        studentScore.setSubject(subject);
        studentScore.setScore1(studentScoreDto.getScore1());
        studentScore.setScore2(studentScoreDto.getScore2());

        return studentScoreRepository.save(studentScore);
    }

}
