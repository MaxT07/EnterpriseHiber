package services;

import exception.EmployeeException;
import model.Employee;
import repository.EmployeeRepository;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import repository.EmployeeRepositoryJdbs;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeService() {
        this.employeeRepository = RepoFactory.getEmpRepo();
    }

   // public List<Employee> getAll() {
     //   return employeeRepository.findAllEmployees();
  //  }

    public List<Employee> getByDepId(int depId) {
        return employeeRepository.findByDepId(depId);
    }

    public Employee getById(String id) {
        if (id == null) {
            throw new EmployeeException("employee id mast not be null");
        }
        return getById(Integer.parseInt(id));
    }

    public Employee getById(int id) {
        return employeeRepository.findById(id);
    }

    public int create(Employee employee) {
        List<ConstraintViolation> violations  = new Validator().validate(employee);
        if(!violations.isEmpty()) {
            throw new EmployeeException(violations);
        }
        return employeeRepository.create(employee);
    }

    public int update(Employee employee){
        List<ConstraintViolation> violations  = new Validator().validate(employee);
        if(!violations.isEmpty()) {
            throw new EmployeeException(violations);
        }
        return employeeRepository.update(employee);
    }
    public void delete(String id){
        if (id == null){
            throw new EmployeeException("employee id mast not be null");
    }
        delete(Integer.parseInt(id));

}
    public  void delete(int id) {
        Employee employee = getById(id);
        if( employee == null){
            throw new EmployeeException("cannot find employee with id " + id);
        }
        employeeRepository.delete(id);
    }

}
