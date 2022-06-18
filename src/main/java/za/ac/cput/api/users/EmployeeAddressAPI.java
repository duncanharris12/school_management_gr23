/*  Davin Carstens 220021333
 */
package za.ac.cput.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.users.EmployeeAddress;
import za.ac.cput.repository.users.interfaces.EmployeeAddressRepository;
import za.ac.cput.service.users.impl.EmployeeAddressServiceImp;

import java.util.Optional;

@Component
public class EmployeeAddressAPI {

    private final EmployeeAddressServiceImp employeeAddressServiceImp;
    private final EmployeeAddressRepository employeeAddressRepository;

    @Autowired
    public EmployeeAddressAPI(EmployeeAddressServiceImp employeeAddressServiceImp, EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressServiceImp = employeeAddressServiceImp;
        this.employeeAddressRepository = employeeAddressRepository;
    }

    public EmployeeAddress save(EmployeeAddress employeeAddress){
        Optional<EmployeeAddress> addEmployeeAddress = employeeAddressRepository.findById(employeeAddress.getStaffId());

        if(addEmployeeAddress.isPresent()){
            throw new IllegalArgumentException("This Staff ID is assigned to an address");
        }

        return this.employeeAddressRepository.save(employeeAddress);
    }

    public EmployeeAddress read(EmployeeAddress getEmpAddress){
        Optional<EmployeeAddress> staffID = employeeAddressRepository.findById(getEmpAddress.getStaffId());

        if(staffID.isEmpty()){
            throw new IllegalArgumentException("Cannot find employee with this address");
        }

        return this.employeeAddressServiceImp.read(getEmpAddress.getStaffId() + getEmpAddress.getAddress());

    }

    public EmployeeAddress delete(EmployeeAddress deleteEmpAddress){
        Optional<EmployeeAddress> staffID = employeeAddressRepository.findById(deleteEmpAddress.getStaffId());

        if(staffID.isPresent()){
            this.employeeAddressServiceImp.delete(deleteEmpAddress.getStaffId());

        }else {

            throw new IllegalStateException("Employee not found with this ID");
        }
        return deleteEmpAddress;
    }
}


