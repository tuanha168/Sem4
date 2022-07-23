package com.example.class4api;

import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/employees")
    public ResponseEntity<Object> findAllEmployees() {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEmployee(
            @PathVariable("id") String id,
            @RequestBody Employee employee) {
//        employeeRepo.remove(id);
//        employee.setId(id);
//        employeeRepo.put(id, employee);
        return new ResponseEntity<>("Employee is updated successfully", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
//        employeeRepo.remove(id);
        return new ResponseEntity<>("Employee is deleted successfully", HttpStatus.OK);
    }
}
