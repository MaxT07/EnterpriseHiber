package repository;

import model.Department;

import java.util.ArrayList;
import java.util.List;

public interface DepartmentRepository {
   List<Department> findAll();

    Department findById(int id);

    int create(Department department);

    int update(Department department);

    int delete(int id);
}
