package com.example.controller;

import com.example.model.Customer;
import com.example.model.CustomerDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "UserServlet", value = "/")
public class UserServlet extends HttpServlet {

    private CustomerDao dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new CustomerDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<h2>This is User Servlet inside doGet method</h2>");

        String action = request.getServletPath();
        switch (action) {
            case "/add":
                addUser(request, response);
                break;
            case "/edit":
                editUser(request, response);
                break;
            case "/delete":
                deleteUser(request, response);
                break;
            default:
                listUser(request, response);
                break;
        }

    }

    void listUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Customer> customerList = dao.getAllCustomer();
            request.setAttribute("customerList", customerList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            //redirect error.jsp
        }

    }

    void addUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("action", "New");
            RequestDispatcher dispatcher = request.getRequestDispatcher("formUser.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void editUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            Customer customer = dao.getCustomer(request.getParameter("id"));
            request.setAttribute("customer", customer);
            request.setAttribute("action", "Edit");

            RequestDispatcher dispatcher = request.getRequestDispatcher("formUser.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            // Hello
            PrintWriter out = response.getWriter();
            Customer customer = dao.getCustomer(request.getParameter("id"));
            int result = dao.deleteUser(customer);
            if (result > 0) {
                response.sendRedirect("list");
            } else {
                out.println("Error");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Do post inside UserServlet
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        // Hello

        String action = request.getServletPath();
        try {
            if (Objects.equals(action, "/UserServletNew")) {
                Customer cus = new Customer(
                        0,
                        request.getParameter("name"),
                        request.getParameter("email"),
                        request.getParameter("address")
                );

                int result = dao.insertUser(cus);
                if (result > 0) {
                    response.sendRedirect("list");
                } else {
                    out.println("Error");
                }
            }
            if (Objects.equals(action, "/UserServletEdit")) {
                Customer cus = dao.getCustomer(request.getParameter("id"));
                cus.setEmail(request.getParameter("email"));
                cus.setName(request.getParameter("name"));
                cus.setAddress(request.getParameter("address"));

                int result = dao.editUser(cus);
                if (result > 0) {
                    response.sendRedirect("list");
                } else {
                    out.println("Error");
                }
            }

        } catch (Exception e) {
            out.println("Error : " + e.getMessage());
        }

    }
}
