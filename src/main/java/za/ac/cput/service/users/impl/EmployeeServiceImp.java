/*  Davin Carstens 220021333
 */
package za.ac.cput.service.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.repository.users.interfaces.EmployeeRepository;
import za.ac.cput.service.users.interfaces.EmployeeService;
import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository repository;
    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }
    // FIX ME
    @Override
    public Employee read(String staffId) {
        return this.repository.getById(staffId);
    }

    @Override
    public void delete(String staffId) {
        this.repository.deleteById(staffId);
    }


    @Override
    public List<Employee> findAll() {
        return this.repository.findAll();
    }
}
