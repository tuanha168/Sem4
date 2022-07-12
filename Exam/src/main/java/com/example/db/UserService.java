package com.example.db;

import com.example.model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService {
    public Users getUser(int id) {
        Transaction transaction = null;
        Users user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            user = (Users) session.createQuery("from Users as u where u.id = :id").setParameter("id", id).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }
}
