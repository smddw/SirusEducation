package dao;

import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CommonDao {

    public static void add(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Can't Insert");
        } finally {
            session.close();
        }
    }

    public static ObservableList select(String nameQuery) {
        ObservableList list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery(nameQuery);
            list = FXCollections.observableList(query.list());
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Can't select");
        } finally {
            session.close();
        }
        return list;
    }

    public static ObservableList select(String nameQuery, HashMap properties) {
        ObservableList list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            Query query = session.getNamedQuery(nameQuery).setProperties(properties);
            list = FXCollections.observableList(query.list());
        } catch (HibernateException e) {
            e.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Can't select list");
        } finally {
            session.close();
        }
        return list;
    }

    public static void update(Object object) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Can't update");
        } finally {
            session.close();
        }
    }

    public static void delete(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Can't delete");
        } finally {
            session.close();
        }
    }

}
