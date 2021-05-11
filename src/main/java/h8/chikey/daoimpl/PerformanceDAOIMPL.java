package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.Performance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PerformanceDAOIMPL implements DAO<Performance,Integer> {

    SessionFactory factory;

    public PerformanceDAOIMPL(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Performance performance) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(performance);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Performance performance) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(performance);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Performance performance) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(performance);
            session.getTransaction().commit();
        }
    }

    @Override
    public Performance read(Integer integer) {
        try(Session session = factory.openSession()) {
            return session.get(Performance.class,integer);
        }
    }

    @Override
    public List<Performance> readAll() {
        try(Session session = factory.openSession()) {
            Query<Performance> query = session.createQuery("FROM Lesson");
            return query.list();
        }
    }
}
