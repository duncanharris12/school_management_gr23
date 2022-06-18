package za.ac.cput.service.users.interfaces;

import za.ac.cput.domain.users.Employee;
import za.ac.cput.service.IService;

import java.util.List;

public interface EmployeeService extends IService<Employee, String> {
    List<Employee> findAll();

}
