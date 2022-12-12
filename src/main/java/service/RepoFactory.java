package service;


import properties.HiberProperties;
import repository.*;

public class RepoFactory {

    public static final String JDBC_REPO_DRIVER = "JDBC";
    static String PROP_KEY_REPO_DRIVER = "repo.driver";

    public static DepartmentRepository getDepRepo() {
        return (JDBC_REPO_DRIVER.equals(HiberProperties.getProperties().getProperty(PROP_KEY_REPO_DRIVER)))? new DepartmentRepositoryJdbc(): new DepartmentRepositoryHibernate();

    }

    public static EmployeeRepository getEmpRepo() {
        return (JDBC_REPO_DRIVER.equals(HiberProperties.getProperties().getProperty(PROP_KEY_REPO_DRIVER)))? new EmployeeRepositoryJdbs(): new EmployeeRepositoryHibernate();
    }
}
