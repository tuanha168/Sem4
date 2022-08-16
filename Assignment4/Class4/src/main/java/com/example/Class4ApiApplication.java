package com.example;

import com.example.repository.CustomerService;
import com.example.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Class4ApiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Class4ApiApplication.class, args);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        CustomerService customerService = context.getBean(CustomerService.class);
    }

}
