package com.dao;

import com.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployee() {
        List<Employee> empList = sessionFactory.getCurrentSession()
                .createQuery("from Employee")
                .list();
        return empList;
    }
}
