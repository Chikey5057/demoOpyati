package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.Faculty;
import h8.chikey.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOIMPL implements DAO<Student,Integer> {

    SessionFactory factory;

    public StudentDAOIMPL(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Student student) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Student student) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Student student) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public Student read(Integer integer) {
        try(Session session = factory.openSession()) {
            return session.get(Student.class,integer);
        }
    }

    @Override
    public List<Student> readAll() {
        try(Session session = factory.openSession()) {
            Query<Student> query = session.createQuery("FROM Student ");
            return query.list();
        }
    }
}
