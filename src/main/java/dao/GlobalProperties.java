package dao;

import model.Department;
import model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Properties;

public class GlobalProperties {
    private static Properties properties = new Properties();

    public static Properties getProperties() {
        FileInputStream fis;

       if(properties.isEmpty()) {
           try {
               fis = new FileInputStream("C:\\Users\\user\\Maxim\\IT\\Max\\HiberDepartment\\src\\main\\resources\\application.properties");
               properties.load(fis);

           } catch (Exception e) {
               System.out.println("Cant init application properties " + e.getMessage());
           }
       }
        return properties;

    }
}