package com.example.db;

import com.example.model.Products;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductService {

    public void saveProduct(Products pro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(pro);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateProduct(Products pro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(pro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteProduct(Products pro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(pro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Products> getAllProduct() {
        Transaction transaction = null;
        List <Products> listOfProducts = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            listOfProducts = session.createQuery("from Products").getResultList();

            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfProducts;
    }

    public Products getProduct(int id) {
        Transaction transaction = null;
        Products products = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            products = (Products) session.createQuery("from Products as p where p.id = :id").setParameter("id", id).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return products;
    }

}
