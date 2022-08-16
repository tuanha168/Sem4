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

    @RequestMapping(value = "/api/employees")
    public ResponseEntity<Object> findAllEmployees() {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/employees", method = RequestMethod.POST)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEmployee(
            @PathVariable("id") String id,
            @RequestBody Employee employee) {
        if (employeeRepository.findById(Integer.parseInt(id)).isPresent()) {
            Employee emp = employeeRepository.findById(Integer.parseInt(id)).get();
            emp.setWage(employee.getWage());
            emp.setName(employee.getName());
            employeeRepository.save(emp);
            return new ResponseEntity<>("Employee is updated successfully", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Employee not found", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/api/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        employeeRepository.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>("Employee is deleted successfully", HttpStatus.OK);
    }
}
