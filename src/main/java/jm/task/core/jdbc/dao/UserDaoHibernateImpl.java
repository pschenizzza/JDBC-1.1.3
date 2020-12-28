package jm.task.core.jdbc.dao;
//
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
        private Transaction transaction;
        private SessionFactory sessionFactory;
        private Session session;

    public UserDaoHibernateImpl() {
        }


    @Override
    public void createUsersTable() {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS userlist" +
                "(\n" +
                "    id       BIGINT auto_increment\n" +
                "        primary key,\n" +
                "    name     varchar(45) not null,\n" +
                "    lastName varchar(45) not null,\n" +
                "    age      int     null\n" +
                ");");
        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery("DROP TABLE `userlist`;").executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        User user = new User(name, lastName, age);
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List getAllUsers() {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List users = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery("delete from userlist").executeUpdate();
        transaction.commit();
        session.close();
    }
}