package za.ac.cput.service.users.interfaces;

import za.ac.cput.domain.users.EmployeeAddress;
import za.ac.cput.service.IService;

import java.util.List;

public interface EmployeeAddressService extends IService<EmployeeAddress, String> {
    List<EmployeeAddress> findAll();
}
