package com.example;

import com.example.repository.ProductsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExamApiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ExamApiApplication.class, args);
        ProductsRepository productsRepository = context.getBean(ProductsRepository.class);
    }

}
