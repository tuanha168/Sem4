package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.service.StudentScoreService;
import com.example.model.StudentScore;
import com.example.dto.CreateStudentScoreDTO;


@RestController
@RequestMapping("student-score")
public class StudentScoreController {
    @Autowired
    StudentScoreService studentScoreService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public StudentScore registerStudent(@RequestBody CreateStudentScoreDTO studentScoreDto) {
        return studentScoreService.save(studentScoreDto);
    }

}
