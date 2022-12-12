package repository;

import model.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee getById(int id);
    List<Employee> getByDepId(int depId);
    List<Employee> getAll();
    int create(Employee employee);
    int update(Employee employee);
    int delete(int id);
}