package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.Faculty;
import h8.chikey.model.Lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FacultyDAOIMPL implements DAO<Faculty,Integer> {

    SessionFactory factory;

    public FacultyDAOIMPL(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Faculty faculty) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(faculty);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Faculty faculty) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(faculty);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Faculty faculty) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(faculty);
            session.getTransaction().commit();
        }
    }

    @Override
    public Faculty read(Integer integer) {
        try(Session session = factory.openSession()) {
            return session.get(Faculty.class,integer);
        }
    }

    @Override
    public List<Faculty> readAll() {
        try(Session session = factory.openSession()) {
            Query<Faculty> query = session.createQuery("FROM Lesson");
            return query.list();
        }
    }
}
