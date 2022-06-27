package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://localhost:3306/FPT";
            String jdbcUsername = "root";
            String jdbcPassword = "01642587195";

            return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {

        }

        return null;
    }


}
