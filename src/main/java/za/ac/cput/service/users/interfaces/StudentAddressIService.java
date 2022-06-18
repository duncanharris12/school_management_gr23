package za.ac.cput.service.users.interfaces;

import za.ac.cput.domain.users.StudentAddress;
import za.ac.cput.service.IService;

import java.util.List;

public interface StudentAddressIService extends IService<StudentAddress, String>
{
    List<StudentAddress> findAll();
}
