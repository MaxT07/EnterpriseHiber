package repository;

import model.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee findById(int id);
    List<Employee> findByDepId(int depId);
    int create(Employee employee);
    int update(Employee employee);
    int delete(int id);
}
