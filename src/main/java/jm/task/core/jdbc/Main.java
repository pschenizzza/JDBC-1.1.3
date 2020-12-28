package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        /*Util.getSQLConnection();
        System.out.println("Start Main");
        UserDao userService = new UserDaoJDBCImpl();


        userService.createUsersTable();
        userService.saveUser("Harry", "Potter", (byte) 14);
        userService.saveUser("Ron", "Weasley", (byte) 15);
        userService.saveUser("Hermione", "Granger", (byte) 16);
        userService.saveUser("Neville", "Longbottom", (byte) 17);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
       userService.dropUsersTable();
    }*/
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();
        userDao.saveUser("Harry", "Potter", (byte) 14);
        userDao.saveUser("Ron", "Weasley", (byte) 15);
        userDao.saveUser("Hermione", "Granger", (byte) 16);
        userDao.saveUser("Neville", "Longbottom", (byte) 17);
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
