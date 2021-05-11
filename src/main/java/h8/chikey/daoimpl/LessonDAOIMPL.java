package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.Lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class LessonDAOIMPL implements DAO<Lesson,Integer> {

    SessionFactory factory;

    public LessonDAOIMPL(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Lesson lesson) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(lesson);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Lesson lesson) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(lesson);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Lesson lesson) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(lesson);
            session.getTransaction().commit();
        }
    }

    @Override
    public Lesson read(Integer integer) {
        try(Session session = factory.openSession()) {
            return session.get(Lesson.class,integer);
        }
    }

    @Override
    public List<Lesson> readAll() {
        try(Session session = factory.openSession()) {
            Query<Lesson> query = session.createQuery("FROM Lesson");
            return query.list();
        }
    }
}
