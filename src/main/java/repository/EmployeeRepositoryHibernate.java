package repository;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeeRepositoryHibernate implements EmployeeRepository{
    public Employee getById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class,id);
    }
    public List<Employee> getByDepId(int depId) {
        return (List<Employee>) HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, depId);
    }

    @Override
    public List<Employee> getAll() {
        return (List<Employee>) HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }


    public int create(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(employee);
        tx1.commit();
        session.close();
        return 0;
    }

    public int delete(int employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(employee);
        tx1.commit();
        session.close();
        return employee;
    }

    public int update(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(employee);
        tx1.commit();
        session.close();
        return 0;
    }


}