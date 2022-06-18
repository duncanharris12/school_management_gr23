/*  Davin Carstens 220021333
 */
package za.ac.cput.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.repository.users.interfaces.EmployeeRepository;
import za.ac.cput.service.users.interfaces.EmployeeService;
import java.util.Optional;

@Component
public class EmployeeAPI {
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeAPI(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee createEmployee) {
        Optional<Employee> empID = employeeRepository.findById(createEmployee.getStaffId());
        Optional<Employee> newEmployee = Optional.ofNullable(employeeRepository.findByEmail(createEmployee.getEmail()));

        if (newEmployee.isPresent()) {
            throw new IllegalStateException("Email is already present");
        }

        if(empID.isPresent()){
            throw new IllegalStateException("ID is already present");
        }
        return this.employeeRepository.save(createEmployee);
    }


    public Employee read(Employee readEmployee) {
        Optional<Employee> staffID = employeeRepository.findById(readEmployee.getStaffId());

        if (staffID.isEmpty()) {
            throw new IllegalStateException("Cannot find Employee with this ID");
        }

        return this.employeeService.read(readEmployee.getName() + readEmployee.getEmail());
    }

    public Employee delete(Employee deleteEmployee){
        Optional<Employee> staffID = employeeRepository.findById(deleteEmployee.getStaffId());

        if(staffID.isPresent()){
            this.employeeService.delete(deleteEmployee.getStaffId());

        }else {
            throw new IllegalStateException("Cannot find Employee with this ID");
        }
        return deleteEmployee;
    }

}
