package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
