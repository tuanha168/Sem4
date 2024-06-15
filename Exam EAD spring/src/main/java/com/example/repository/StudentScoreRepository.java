package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.model.StudentScore;

@Repository
public interface StudentScoreRepository extends CrudRepository<StudentScore, Integer> {
}
