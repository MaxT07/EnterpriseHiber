package services;

import dao.GlobalProperties;
import repository.*;

public class RepoFactory {

    public static final String JDBC_REPO_DRIVER = "JDBC";
    static String PROP_KEY_REPO_DRIVER = "repo.driver";

    public static DepartmentRepository getDepRepo() {
        return (JDBC_REPO_DRIVER.equals(GlobalProperties.getProperties().getProperty(PROP_KEY_REPO_DRIVER)))? new DepartmentRepositoryJdbc(): new DepRepoHiber();

    }

    public static EmployeeRepository getEmpRepo() {
        return (JDBC_REPO_DRIVER.equals(GlobalProperties.getProperties().getProperty(PROP_KEY_REPO_DRIVER)))? new EmployeeRepositoryJdbs(): new EmpRepoHiber();
    }
}
