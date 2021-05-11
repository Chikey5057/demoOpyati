package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.Special;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class SpecialDAOIMPL implements DAO<Special,Integer> {

    SessionFactory factory;

    public SpecialDAOIMPL(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Special special) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(special);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Special special) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(special);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Special special) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(special);
            session.getTransaction().commit();
        }
    }

    @Override
    public Special read(Integer integer) {
        try(Session session = factory.openSession()) {
            return session.get(Special.class,integer);
        }
    }

    @Override
    public List<Special> readAll() {
        try(Session session = factory.openSession()) {
            Query<Special> query = session.createQuery("FROM Lesson");
            return query.list();
        }
    }
}
