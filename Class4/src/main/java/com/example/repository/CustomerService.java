package com.example.repository;

import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL = "select * from customer";

    public List<Customer> getAllCustomers() {

        List<Customer> customers = new ArrayList<Customer>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

        for (Map<String, Object> row : rows)
        {
            Customer customer = new Customer();
            customer.setId((int)row.get("id"));
            customer.setName((String)row.get("name"));
            customer.setEmail((String)row.get("email"));
            customer.setAddress((String)row.get("address"));

            customers.add(customer);
        }

        return customers;
    }

    public int save(Customer c) {
        String sql = "insert into customer(name, email, address) VALUES('" + c.getName() + "','" + c.getEmail() + "','"
                + c.getAddress() + "')";
        return jdbcTemplate.update(sql);
    }

}
