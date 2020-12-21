package jm.task.core.jdbc.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/userschema?serverTimezone=Europe/Moscow";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123qwe";
    private static String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";


    public static Connection getSQLConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Connection successfully");
        } else {
            System.out.println("Failed to make connect");
        }
        return connection;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userschema?serverTimezone=Europe/Moscow", USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}