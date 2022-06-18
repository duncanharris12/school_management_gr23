/*  Davin Carstens 220021333
 */
package za.ac.cput.service.users.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.users.EmployeeAddress;
import za.ac.cput.repository.users.interfaces.EmployeeAddressRepository;
import za.ac.cput.service.users.interfaces.EmployeeAddressService;
import java.util.List;

@Service
public class EmployeeAddressServiceImp implements EmployeeAddressService {

    private EmployeeAddressRepository repository;

    private EmployeeAddressServiceImp(EmployeeAddressRepository employeeAddressRepository){
        this.repository = employeeAddressRepository;
    }

    @Override
    public EmployeeAddress read(String staffId) {
        return this.repository.getById(staffId);
    }

    @Override
    public void delete(String staffId) {
        this.repository.deleteById(staffId);
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress)
    {
        return this.repository.save(employeeAddress);
    }

    @Override
    public List<EmployeeAddress> findAll() {
        return this.repository.findAll();
    }
}
