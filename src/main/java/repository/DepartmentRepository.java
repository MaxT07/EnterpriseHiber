package repository;

import model.Department;

import java.util.List;

public interface DepartmentRepository {
   List<Department> getAll();

    Department getById(int id);

    int create(Department department);

    int update(Department department);

    int delete(int id);
}
