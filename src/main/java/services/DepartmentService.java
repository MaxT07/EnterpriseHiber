package services;

import exception.DepartmentException;
import model.Department;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.apache.commons.lang3.StringUtils;
import repository.DepRepoHiber;
import repository.DepartmentRepository;
import repository.DepartmentRepositoryJdbc;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {



    private final DepartmentRepository departmentRepository;

    public DepartmentService() {
        this.departmentRepository = RepoFactory.getDepRepo();

    }

            public ArrayList<Department> getAll() {

                return (ArrayList<Department>) departmentRepository.findAll();
            }

            public Department getById(int id) {
                return departmentRepository.findById(id);
            }


            public int create(Department department) {
                List<ConstraintViolation> violations = new Validator().validate(department);
                if (!violations.isEmpty()) {
                    throw new DepartmentException(violations);
                }
                return departmentRepository.create(department);
            }

            private void validate(Department department) {
                if (StringUtils.isBlank(department.getName())) {
                    throw new DepartmentException("Department name has");
                }
                if (StringUtils.isBlank(department.getAddress())) {
                    throw new DepartmentException("Address has to be filled");
                }
                if (StringUtils.isBlank(department.getDescription())) {
                    throw new DepartmentException("Description has be filled");
                }
            }

            public void update(Department department) {
                List<ConstraintViolation> violations = new Validator().validate(department);
                if (!violations.isEmpty()) {
                    throw new DepartmentException(violations);
                }
               departmentRepository.update(department);
            }

            public void delete(int id) {
                Department department = getById(id);
                if (department == null) {

                    throw new DepartmentException("cannot find department with id " + id);
                }

                departmentRepository.delete(id);
            }



            }




