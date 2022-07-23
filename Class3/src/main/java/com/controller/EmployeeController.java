package com.controller;

import com.model.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/new")
    public String newEmployeeForm(Map<String, Object> model) {
        Employee employee = new Employee();
        model.put("employee", employee);
        return "new_employee";
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        List<Employee> listEmployee = employeeService.getAllEmployees();
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("listEmployee", listEmployee);
        return mav;
    }
}
