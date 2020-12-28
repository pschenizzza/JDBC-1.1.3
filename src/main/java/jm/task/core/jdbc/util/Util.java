package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.PASS;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/userschema?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123qwe";
    private static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static Connection connection;
    private static SessionFactory sessionFactory;

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

    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        Configuration configuration = new Configuration();
        properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.URL, URL);;
        properties.setProperty(Environment.USER, USERNAME);
        properties.setProperty(Environment.PASS, PASSWORD);
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
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