package com.example.model;

import com.example.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.*;

public class CustomerDao {

    private static final String INSERT_NEW_CUSTOMER
            = "INSERT INTO customer(name,email,address) VALUES(?,?,?)";
    private static final String SELECT_ALL_CUSTOMER
            = "SELECT id, name, email, address FROM customer";
    private static final String SELECT_A_CUSTOMER
            = "SELECT id, name, email, address FROM customer WHERE id = ?";

    private static final String ALTER_CUSTOMER
            = "UPDATE customer SET name = ?, email = ?, address = ? where id = ?";

    private static final String DELETE_CUSTOMER
            = "DELETE FROM customer where id = ?";
    public List<Customer> getAllCustomer() throws SQLException {

        Connection connection = null;
        List<Customer> customers = new ArrayList<Customer>();

        try {
            connection = DBUtil.getConnection();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(SELECT_ALL_CUSTOMER);
            while(rs.next()) {
                customers.add(new Customer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }

            rs.close();

            System.out.println(customers.size());

        } catch(Exception e) {
            e.printStackTrace();
        }  finally {
            if(connection != null) {
                connection.close();
            }
        }

        return customers;
    }

    public Customer getCustomer(String id) throws SQLException {

        Connection connection = null;

        try {
            connection = DBUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SELECT_A_CUSTOMER);

            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();
            Customer customer;

            rs.next();
            customer = new Customer(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
            );
            rs.close();
            return customer;
        } catch(Exception e) {
            e.printStackTrace();
        }  finally {
            if(connection != null) {
                connection.close();
            }
        }
        return null;
    }

    public int insertUser(Customer cus) throws SQLException {

        int result = 0;
        Connection connection = null;

        try {
            connection = DBUtil.getConnection();

            PreparedStatement pstmt = connection.prepareStatement(INSERT_NEW_CUSTOMER);
            pstmt.setString(1, cus.getName());
            pstmt.setString(2, cus.getEmail());
            pstmt.setString(3, cus.getAddress());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
        return 0;
    }
    public int editUser(Customer cus) throws SQLException {

        int result = 0;
        Connection connection = null;

        try {
            connection = DBUtil.getConnection();

            PreparedStatement pstmt = connection.prepareStatement(ALTER_CUSTOMER);
            pstmt.setString(1, cus.getName());
            pstmt.setString(2, cus.getEmail());
            pstmt.setString(3, cus.getAddress());
            pstmt.setInt(4, cus.getId());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
        return 0;
    }

    public int deleteUser(Customer cus) throws SQLException {

        int result = 0;
        Connection connection = null;

        try {
            connection = DBUtil.getConnection();

            PreparedStatement pstmt = connection.prepareStatement(DELETE_CUSTOMER);
            pstmt.setInt(1, cus.getId());

            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
        return result;
    }
}
