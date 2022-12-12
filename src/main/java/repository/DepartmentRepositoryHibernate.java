package repository;

import model.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class DepartmentRepositoryHibernate implements DepartmentRepository {
    @Override
    public List<Department> getAll() {
        return (List<Department>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM model.Department").list();
    }


    public Department getById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Department.class, id);
    }

    public int create(Department department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(department);
        tx1.commit();
        session.close();
        return 0;
    }

    public int update(Department department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(department);
        tx1.commit();
        session.close();
        return 0;
    }

    public int delete(int department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(department);
        tx1.commit();
        session.close();

        return department;
    }
}