package utils;

import dao.GlobalProperties;
import model.Department;
import model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.io.FileInputStream;
import java.sql.Driver;
import java.util.Properties;

public class HibernateSessionFactoryUtil {
    public static final String DB_DRIVER = "db.Driver";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.setProperties(GlobalProperties.getProperties());
                configuration.addAnnotatedClass(Department.class);
                configuration.addAnnotatedClass(Employee.class);

                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.out.println("Cant application initialize");;
            }
        }
        return sessionFactory;

    }
}

