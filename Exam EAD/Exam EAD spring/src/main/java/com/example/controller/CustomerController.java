package com.example.controller;

import com.example.model.Customer;
import com.example.repository.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/list")
    public List<Customer> customerInformation() {
        List<Customer> customers = customerService.getAllCustomers();
        return customers;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public Customer registerStudent(@RequestBody Customer customer) {
        customerService.save(customer);
        return customer;
    }

}
