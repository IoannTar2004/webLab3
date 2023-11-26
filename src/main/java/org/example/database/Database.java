package org.example.database;

import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Database {

    private final Session session;
    private final Transaction transaction;

    public Database() {
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public void add(Point point) {
        session.merge(point);
    }

    public void clear() {
        String sql = "DELETE FROM points";
        session.createNativeQuery(sql, Point.class).executeUpdate();
    }

    public List<Point> getPoints() {
        var criteriaQuery = session.getCriteriaBuilder().createQuery(Point.class);
        Root<Point> root = criteriaQuery.from(Point.class);
        return session.createQuery(criteriaQuery.select(root)).getResultList();
    }

    public void commit() {
        transaction.commit();
        session.close();
    }
}
